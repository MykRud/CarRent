package com.misharyduk.CarRent.dao;

import com.misharyduk.CarRent.model.CreditCard;
import com.misharyduk.CarRent.model.Driver;

import java.util.List;

public interface CreditCardDao {
    CreditCard getCreditCard(int id);

    CreditCard getCreditCardByDriver(int driver_id);

    void saveCreditCard(CreditCard creditCard, Driver driver);
}
