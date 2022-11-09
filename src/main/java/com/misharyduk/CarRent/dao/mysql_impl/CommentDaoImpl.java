package com.misharyduk.CarRent.dao.mysql_impl;

import com.misharyduk.CarRent.dao.CommentDao;
import com.misharyduk.CarRent.model.Car;
import com.misharyduk.CarRent.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentDaoImpl extends CommonMySQL implements CommentDao{

    @Override
    public Comment getComment(int id) {
        Comment comment = new Comment();
        String SQLQuery = "SELECT * FROM Comment WHERE id=?";
        try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                comment.setId(resultSet.getInt("id"));
                comment.setName(resultSet.getString("name"));
                comment.setText(resultSet.getString("text"));
                CarDaoImpl carDao = new CarDaoImpl();
                comment.setCar(carDao.getCar(resultSet.getInt("car_id")));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return comment;
    }

    @Override
    public List<Comment> getCommentsByCar(int car_id) {
        List<Comment> comments = new ArrayList<>();
        String SQLQuery = "SELECT * FROM Comment WHERE car_id=?";
        try (PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setInt(1, car_id);
            ResultSet resultSet = statement.executeQuery();
            CarDaoImpl carDao = new CarDaoImpl();
            Car car = carDao.getCar(car_id);
            while (resultSet.next()){
                Comment comment = new Comment();

                comment.setId(resultSet.getInt("id"));
                comment.setName(resultSet.getString("name"));
                comment.setText(resultSet.getString("text"));
                comment.setCar(car);

                comments.add(comment);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return comments;
    }

    @Override
    public List<Comment> getComments() {
        List<Comment> comments = new ArrayList<>();
        String SQLQuery = "SELECT * FROM Comment";
        try (Statement statement = getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(SQLQuery);
            CarDaoImpl carDao = new CarDaoImpl();
            while (resultSet.next()){
                Comment comment = new Comment();

                comment.setId(resultSet.getInt("id"));
                comment.setName(resultSet.getString("name"));
                comment.setText(resultSet.getString("text"));
                comment.setCar(carDao.getCar(resultSet.getInt("car_id")));

                comments.add(comment);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return comments;
    }

    @Override
    public void addComment(Comment comment) {
        String SQLQuery = "INSERT INTO Comment(name, text, car_id) VALUES(?, ?, ?)";
        try (PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setString(1, comment.getName());
            statement.setString(2, comment.getText());
            statement.setInt(3, comment.getCar().getId());

            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
