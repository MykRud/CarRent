package com.misharyduk.CarRent.dao.mysql_impl;

import com.misharyduk.CarRent.dao.DriverDao;
import com.misharyduk.CarRent.model.Driver;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DriverDaoImpl extends CommonMySQL implements DriverDao {
    @Override
    public boolean addDriver(Driver driver) {
        String SQLQuery = "INSERT INTO Driver(name, driverLicence) VALUES(?, ?)";

        int isAdded = 0;

        try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setString(1, driver.getName());
            statement.setLong(2, driver.getDriverLicence());


            isAdded = statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return isAdded != 0;
    }

    @Override
    public Driver getDriver(int id) {
        Driver driver = new Driver();

        try (PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM Driver WHERE id=?")){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                driver.setId(resultSet.getInt("id"));
                driver.setName(resultSet.getString("name"));
                driver.setDriverLicence(resultSet.getLong("driverLicence"));

                int rentCarId = resultSet.getInt("car_id");

                if(rentCarId != 0) {
                    CarDaoImpl carDao = new CarDaoImpl();
                    driver.setRentCar(carDao.getCar(rentCarId));
                }

            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return driver;
    }

    @Override
    public Driver getDriverByName(String name) {
        Driver driver = new Driver();

        try (PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM Driver WHERE name=?")){
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                driver.setId(resultSet.getInt("id"));
                driver.setName(resultSet.getString("name"));
                driver.setDriverLicence(resultSet.getLong("driverLicence"));

                int rentCarId = resultSet.getInt("car_id");

                if(rentCarId != 0) {
                    CarDaoImpl carDao = new CarDaoImpl();
                    driver.setRentCar(carDao.getCar(rentCarId));
                }

            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return driver;
    }

    @Override
    public List<Driver> getDrivers() {
        List<Driver> drivers = new ArrayList<>();
        try(Statement statement = getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Driver");
            CarDaoImpl carDao = new CarDaoImpl();
            while (resultSet.next()){
                Driver driver = new Driver();

                driver.setId(resultSet.getInt("id"));
                driver.setName(resultSet.getString("name"));
                driver.setDriverLicence(resultSet.getLong("driverLicence"));

                int rentCarId = resultSet.getInt("car_id");

                if(rentCarId != 0)
                    driver.setRentCar(carDao.getCar(rentCarId));

                drivers.add(driver);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return drivers;
    }

    @Override
    public boolean deleteDriver(int id) {
        Driver foundDriver = getDriver(id);

        String SQLQuery = "DELETE FROM Driver WHERE id=?";

        int isDeleted = 0;

        if(foundDriver.getId() != 0){
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
    public boolean updateDriver(Driver driver) {
        String SQLQuery = "UPDATE Driver SET driverLicence=?, car_id=? WHERE id=?";
        try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setLong(1, driver.getDriverLicence());
            if(driver.getRentCar() != null)
                statement.setInt(2, driver.getRentCar().getId());
            else
                statement.setNull(2, java.sql.Types.NULL);
            statement.setInt(3, driver.getId());

            int numberOfChanges = statement.executeUpdate();

            return numberOfChanges != 0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void setCarForDriver(int driver_id, int car_id){
        String SQLQuery = "UPDATE Driver SET car_id=? WHERE id=?";
        try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setInt(1, car_id);
            statement.setInt(2, driver_id);
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Driver getDriverByRentCar(int car_id) {
        String SQLQuery = "SELECT * FROM Driver WHERE car_id=?";
        Driver driver = new Driver();
        try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setInt(1, car_id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                driver.setId(resultSet.getInt("id"));
                driver.setName(resultSet.getString("name"));
                driver.setDriverLicence(resultSet.getLong("driverLicence"));

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return driver;
    }
}
