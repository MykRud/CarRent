package com.misharyduk.CarRent.service;

import com.misharyduk.CarRent.dao.TransactionDao;
import com.misharyduk.CarRent.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionDao transactionDao;
    @Autowired
    private DriverService driverService;
    @Autowired
    private CarService carService;
    @Autowired
    private EmployeeService employeeService;

    public List<Transaction> getAllTransactions(){
        return transactionDao.getAllTransactions();
    }

    public Transaction getTransactionById(int id){
        return transactionDao.getTransactionById(id);
    }

    public List<Transaction> getAllTransactionsByDriver(int driver_id){
        return transactionDao.getAllTransactionsByDriver(driver_id);
    }

    public List<Transaction> getAllTransactionsByCar(int car_id){
        return transactionDao.getAllTransactionsByCar(car_id);
    }

    public void saveTransaction(int car_id, int driver_id, double distance, int employee_id){
        Transaction tx = new Transaction();
        tx.setDistance(distance);
        tx.setCar(carService.getCar(car_id));
        tx.setDriver(driverService.getDriver(driver_id));
        tx.setEmployee(employeeService.getEmployee(employee_id));

        transactionDao.saveTransaction(tx);
    }
}
