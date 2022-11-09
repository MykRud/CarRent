package com.misharyduk.CarRent.service;

import com.misharyduk.CarRent.dao.CarDao;
import com.misharyduk.CarRent.dao.CompanyDao;
import com.misharyduk.CarRent.model.Car;
import com.misharyduk.CarRent.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private CarDao carDao;

    public Company getCompany(){
        Company company = companyDao.getCompany();
        company.setCars(carDao.getCars());
        return company;
    }

    public void increaseIncome(double price) {
        companyDao.updateIncome(getCompany(), price);
    }
}
