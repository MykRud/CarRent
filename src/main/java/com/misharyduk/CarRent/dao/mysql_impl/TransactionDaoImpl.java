package com.misharyduk.CarRent.dao.mysql_impl;

import com.misharyduk.CarRent.dao.TransactionDao;
import com.misharyduk.CarRent.model.Car;
import com.misharyduk.CarRent.model.Driver;
import com.misharyduk.CarRent.model.Employee;
import com.misharyduk.CarRent.model.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionDaoImpl extends CommonMySQL implements TransactionDao {
    @Override
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        String SQLQuery = "SELECT tx.id AS `id`, c.id AS `car_id`, c.model AS `car_model`, " +
                "driv.id AS `driver_id`, driv.name AS `driver_name`, " +
                "tx.distance AS `distance`, empl.id AS `employee_id`, " +
                "empl.name AS `employee_name` FROM Transaction tx " +
                "INNER JOIN Car c ON tx.car_id=c.id " +
                "INNER JOIN Driver driv ON tx.driver_id=driv.id " +
                "INNER JOIN Employee empl ON tx.employee_id=empl.id";

        try(Statement statement = getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(SQLQuery);
            while (resultSet.next()){
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getInt("id"));

                Car car = new Car();
                car.setId(resultSet.getInt("car_id"));
                car.setModel(resultSet.getString("car_model"));
                transaction.setCar(car);

                Driver driver = new Driver();
                driver.setId(resultSet.getInt("driver_id"));
                driver.setName(resultSet.getString("driver_name"));
                transaction.setDriver(driver);

                Employee employee = new Employee();
                employee.setId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("employee_name"));
                transaction.setEmployee(employee);

                transaction.setDistance(resultSet.getDouble("distance"));

                transactions.add(transaction);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return transactions;
    }

    @Override
    public Transaction getTransactionById(int id) {
        Transaction transaction = new Transaction();

        String SQLQuery = "SELECT tx.id AS `id`, c.id AS `car_id`, c.model AS `car_model`, " +
                                        "driv.id AS `driver_id`, driv.name AS `driver_name`, " +
                                        "tx.distance AS `distance`, empl.id AS `employee_id`, " +
                                        "empl.name AS `employee_name` FROM Transaction tx " +
                "INNER JOIN Car c ON tx.car_id=c.id " +
                "INNER JOIN Driver driv ON tx.driver_id=driv.id " +
                "INNER JOIN Employee empl ON tx.employee_id=empl.id " +
                                        "WHERE tx.id=?";

        try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                transaction.setId(resultSet.getInt("id"));

                Car car = new Car();
                car.setId(resultSet.getInt("car_id"));
                car.setModel(resultSet.getString("car_model"));
                transaction.setCar(car);

                Driver driver = new Driver();
                driver.setId(resultSet.getInt("driver_id"));
                driver.setName(resultSet.getString("driver_name"));
                transaction.setDriver(driver);

                Employee employee = new Employee();
                employee.setId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("employee_name"));
                transaction.setEmployee(employee);

                transaction.setDistance(resultSet.getDouble("distance"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return transaction;
    }

    @Override
    public List<Transaction> getAllTransactionsByDriver(int driver_id) {

        List<Transaction> transactions = new ArrayList<>();

        String SQLQuery = "SELECT tx.id AS `id`, c.id AS `car_id`, c.model AS `car_model`, " +
                                  "driv.id AS `driver_id`, driv.name AS `driver_name`, " +
                                  "tx.distance AS `distance`, empl.id AS `employee_id`, " +
                                  "empl.name AS `employee_name` FROM Transaction tx " +
                "INNER JOIN Car c ON tx.car_id=c.id " +
                "INNER JOIN Driver driv ON tx.driver_id=driv.id " +
                "INNER JOIN Employee empl ON tx.employee_id=empl.id " +
                                  "WHERE driv.id=?";

        try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setInt(1, driver_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getInt("id"));

                Car car = new Car();
                car.setId(resultSet.getInt("car_id"));
                car.setModel(resultSet.getString("car_model"));
                transaction.setCar(car);

                Driver driver = new Driver();
                driver.setId(resultSet.getInt("driver_id"));
                driver.setName(resultSet.getString("driver_name"));
                transaction.setDriver(driver);

                Employee employee = new Employee();
                employee.setId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("employee_name"));
                transaction.setEmployee(employee);

                transaction.setDistance(resultSet.getDouble("distance"));

                transactions.add(transaction);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return transactions;
    }

    @Override
    public List<Transaction> getAllTransactionsByCar(int car_id) {
        List<Transaction> transactions = new ArrayList<>();

        String SQLQuery = "SELECT tx.id AS `id`, c.id AS `car_id`, c.model AS `car_model`, " +
                                 "driv.id AS `driver_id`, driv.name AS `driver_name`, " +
                                 "tx.distance AS `distance`, empl.id AS `employee_id`, " +
                                 "empl.name AS `employee_name` FROM Transaction tx " +
                "INNER JOIN Car c ON tx.car_id=c.id " +
                "INNER JOIN Driver driv ON tx.driver_id=driv.id " +
                "INNER JOIN Employee empl ON tx.employee_id=empl.id " +
                                 "WHERE c.id=?";

        try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setInt(1, car_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getInt("id"));

                Car car = new Car();
                car.setId(resultSet.getInt("car_id"));
                car.setModel(resultSet.getString("car_model"));
                transaction.setCar(car);

                Driver driver = new Driver();
                driver.setId(resultSet.getInt("driver_id"));
                driver.setName(resultSet.getString("driver_name"));
                transaction.setDriver(driver);

                Employee employee = new Employee();
                employee.setId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("employee_name"));
                transaction.setEmployee(employee);

                transaction.setDistance(resultSet.getDouble("distance"));

                transactions.add(transaction);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return transactions;

    }

    @Override
    public void saveTransaction(Transaction transaction) {
        String SQLQuery = "insert into Transaction VALUES(?, ?, ?, ?, ?)";
        try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setInt(1, transaction.getId());
            statement.setInt(2, transaction.getCar().getId());
            statement.setInt(3, transaction.getDriver().getId());
            statement.setDouble(4, transaction.getDistance());
            statement.setInt(5, transaction.getEmployee().getId());

            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
