package com.misharyduk.CarRent.dao.mysql_impl;

import com.misharyduk.CarRent.dao.CarDao;
import com.misharyduk.CarRent.model.Car;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl extends CommonMySQL implements CarDao{
    @Override
    public boolean addCar(Car car) {
        String SQLQuery = "INSERT INTO Car(model, numberOfSeats, isRent, price, " +
                "totalKilometrage, distance, company_id, carNumber) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        int isAdded = 0;

        try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setString(1, car.getModel());
            statement.setInt(2, car.getNumberOfSeats());
            statement.setBoolean(3, car.getIsRent());
            statement.setDouble(4, car.getPrice());
            statement.setDouble(5, car.getTotalKilometrage());
            statement.setDouble(6, car.getDistance());
            statement.setInt(7, 1);
            statement.setInt(8, car.getCarNumber());

            isAdded = statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return isAdded != 0;
    }

    @Override
    public Car getCar(int id) {
        Car car = new Car();

        try (PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM Car WHERE id=?")){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                car.setId(resultSet.getInt("id"));
                car.setModel(resultSet.getString("model"));
                car.setNumberOfSeats(resultSet.getInt("numberOfSeats"));
                car.setPrice(resultSet.getDouble("price"));
                car.setDistance(resultSet.getDouble("distance"));
                car.setTotalKilometrage(resultSet.getDouble("totalKilometrage"));
                car.setIsRent(resultSet.getBoolean("isRent"));
                car.setCarNumber(resultSet.getInt("carNumber"));


            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return car;
    }

    @Override
    public Car getCarByNumber(int carNumber) {
        Car car = new Car();

        try (PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM Car WHERE carNumber=?")){
            statement.setInt(1, carNumber);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                car.setId(resultSet.getInt("id"));
                car.setModel(resultSet.getString("model"));
                car.setNumberOfSeats(resultSet.getInt("numberOfSeats"));
                car.setPrice(resultSet.getDouble("price"));
                car.setDistance(resultSet.getDouble("distance"));
                car.setTotalKilometrage(resultSet.getDouble("totalKilometrage"));
                car.setIsRent(resultSet.getBoolean("isRent"));
                car.setCarNumber(resultSet.getInt("carNumber"));

            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return car;
    }

    @Override
    public Car findNearestCar() {
        Car foundCar = new Car();

        String SQLQuery = "SELECT id FROM Car WHERE isRent=false ORDER BY distance LIMIT 1";
        try(Statement statement = getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(SQLQuery);
            if(resultSet.next()){
                foundCar = getCar(resultSet.getInt("id"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return foundCar;
    }

    @Override
    public boolean deleteCar(int id) {
        Car foundCar = getCar(id);

        String SQLQuery = "";

        int isDeleted = 0;

        if(foundCar.getId() != 0){
            try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
                statement.setInt(1, id);
                isDeleted = statement.executeUpdate();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        return isDeleted != 0;
    }

    @Override
    public boolean updateCar(Car car) {
        String SQLQuery = "UPDATE Car SET isRent=?, price=?, totalKilometrage=?, distance=?, carNumber=? WHERE id=?";
        try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setBoolean(1, car.getIsRent());
            statement.setDouble(2, car.getPrice());
            statement.setDouble(3, car.getTotalKilometrage());
            statement.setDouble(4, car.getDistance());
            statement.setInt(5, car.getCarNumber());
            statement.setInt(6, car.getId());

            int numberOfChanges = statement.executeUpdate();

            return numberOfChanges != 0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        try(Statement statement = getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Car");
            while (resultSet.next()){
                Car car = new Car();

                car.setId(resultSet.getInt("id"));
                car.setModel(resultSet.getString("model"));
                car.setNumberOfSeats(resultSet.getInt("numberOfSeats"));
                car.setPrice(resultSet.getDouble("price"));
                car.setDistance(resultSet.getDouble("distance"));
                car.setTotalKilometrage(resultSet.getDouble("totalKilometrage"));
                car.setIsRent(resultSet.getBoolean("isRent"));

                cars.add(car);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return cars;
    }
}
