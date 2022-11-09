package com.misharyduk.CarRent.service;

import com.misharyduk.CarRent.dao.CreditCardDao;
import com.misharyduk.CarRent.model.CreditCard;
import com.misharyduk.CarRent.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {
    @Autowired
    private CreditCardDao creditCardDao;

    public CreditCard getCreditCard(int id){
        return creditCardDao.getCreditCard(id);
    }

    public CreditCard getCreditCardByDriver(int driver_id){
        return creditCardDao.getCreditCardByDriver(driver_id);
    }

    public void saveCreditCard(CreditCard creditCard, Driver driver){
        creditCardDao.saveCreditCard(creditCard, driver);
    }
}
