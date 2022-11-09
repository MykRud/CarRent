package com.misharyduk.CarRent.dao;

import com.misharyduk.CarRent.model.Transaction;

import java.util.List;

public interface TransactionDao {
    List<Transaction> getAllTransactions();

    Transaction getTransactionById(int id);

    List<Transaction> getAllTransactionsByDriver(int driver_id);

    List<Transaction> getAllTransactionsByCar(int car_id);

    void saveTransaction(Transaction transaction);
}
