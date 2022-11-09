package com.misharyduk.CarRent.dao;

import com.misharyduk.CarRent.model.Car;
import com.misharyduk.CarRent.model.Company;

import java.util.List;

public interface CompanyDao {

    Company getCompany();


    void updateIncome(Company company, double price);
}
