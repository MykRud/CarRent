package com.misharyduk.CarRent.service;

import com.misharyduk.CarRent.dao.CarDao;
import com.misharyduk.CarRent.dao.CompanyDao;
import com.misharyduk.CarRent.dao.DriverDao;
import com.misharyduk.CarRent.model.Car;
import com.misharyduk.CarRent.model.Company;
import com.misharyduk.CarRent.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarDao carDao;
    @Autowired
    private DriverDao driverDao;
    @Autowired
    private CompanyDao companyDao;

    public boolean addCar(Car car){
        return carDao.addCar(car);
    }

    public Car getCar(int id){
        Car car = carDao.getCar(id);
        Driver foundDriver = driverDao.getDriverByRentCar(car.getId());
        if(foundDriver.getId() != 0) {
            car.setDriver(foundDriver);
            car.setIsRent(true);
        }
        car.setCompany(companyDao.getCompany());
        return car;
    }

    public Car findNearestCar(){
        return carDao.findNearestCar();
    }

    public boolean deleteCar(int id){
        return carDao.deleteCar(id);
    }

    public boolean updateCar(Car car){
        return carDao.updateCar(car);
    }

    public List<Car> getCars(){
        List<Car> cars = carDao.getCars();
        Company company = companyDao.getCompany();
        for(Car car : cars){
            Driver foundDriver = driverDao.getDriverByRentCar(car.getId());
            if(foundDriver.getId() != 0) {
                car.setDriver(foundDriver);
                car.setIsRent(true);
            }
            car.setCompany(company);
        }
        return cars;
    }

    public Car getCarByNumber(int carNumber){
        Car car = carDao.getCarByNumber(carNumber);
        Driver foundDriver = driverDao.getDriverByRentCar(car.getId());
        if(foundDriver.getId() != 0) {
            car.setDriver(foundDriver);
            car.setIsRent(true);
        }
        car.setCompany(companyDao.getCompany());
        return car;
    }

    public void releaseCar(int car_id) {
        Car car = getCar(car_id);
        if(car.getDriver() != null) {
            Driver driver = driverDao.getDriver(car.getDriver().getId());
            car.setIsRent(false);
            car.setDriver(null);
            carDao.updateCar(car);

            driver.setRentCar(null);
            driverDao.updateDriver(driver);
        }
    }
}
