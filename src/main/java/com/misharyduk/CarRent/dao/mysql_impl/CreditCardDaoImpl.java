package com.misharyduk.CarRent.dao.mysql_impl;

import com.misharyduk.CarRent.dao.CreditCardDao;
import com.misharyduk.CarRent.model.CreditCard;
import com.misharyduk.CarRent.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CreditCardDaoImpl extends CommonMySQL implements CreditCardDao{

    @Override
    public CreditCard getCreditCard(int id) {
        CreditCard creditCard = new CreditCard();
        String SQLQuery = "SELECT card.numberOfCard, card.expMonth, card.expYear, card.bankSystem, " +
                                 "driv.id, driv.Name FROM CreditCard card " +
                "JOIN CreditCard_Driver ON card.numberOfCard=creditCard_id " +
                "JOIN Driver driv ON driver_id=driv.id WHERE card.numberOfCard=?";

        try (PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                creditCard.setNumberOfCard(resultSet.getInt("numberOfCard"));
                creditCard.setExpMonth(resultSet.getInt("expMonth"));
                creditCard.setExpYear(resultSet.getInt("expYear"));
                creditCard.setBankSystem(resultSet.getString("bankSystem"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return creditCard;
    }

    @Override
    public CreditCard getCreditCardByDriver(int driver_id) {
        CreditCard creditCard = new CreditCard();
        String SQLQuery = "SELECT card.numberOfCard, card.expMonth, card.expYear, card.bankSystem, " +
                "driv.id, driv.Name FROM CreditCard card " +
                "JOIN CreditCard_Driver ON card.numberOfCard=creditCard_id " +
                "JOIN Driver driv ON driver_id=driv.id WHERE driv.id=?";

        try (PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setInt(1, driver_id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                creditCard.setNumberOfCard(resultSet.getInt("numberOfCard"));
                creditCard.setExpMonth(resultSet.getInt("expMonth"));
                creditCard.setExpYear(resultSet.getInt("expYear"));
                creditCard.setBankSystem(resultSet.getString("bankSystem"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return creditCard;
    }

    @Override
    public void saveCreditCard(CreditCard creditCard, Driver driver) {
        String SQLQuery1 = "INSERT INTO CreditCard VALUES(?, ?, ?, ?)";
        String SQLQuery2 = "INSERT INTO CreditCard_Driver(driver_id, creditCard_id) VALUES(?, ?)";
        try (PreparedStatement statement1 = getConnection().prepareStatement(SQLQuery1);
            PreparedStatement statement2 = getConnection().prepareStatement(SQLQuery2)){

            statement1.setInt(1, creditCard.getNumberOfCard());
            statement1.setInt(2, creditCard.getExpMonth());
            statement1.setInt(3, creditCard.getExpYear());
            statement1.setString(4, creditCard.getBankSystem());
            statement1.executeUpdate();

            statement2.setInt(1, driver.getId());
            statement2.setInt(2, creditCard.getNumberOfCard());
            statement2.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
