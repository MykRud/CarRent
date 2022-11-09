package com.misharyduk.CarRent.service;

import com.misharyduk.CarRent.dao.CarDao;
import com.misharyduk.CarRent.dao.DriverDao;
import com.misharyduk.CarRent.model.Car;
import com.misharyduk.CarRent.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverDao driverDao;
    @Autowired
    private CarService carService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CreditCardService creditCardService;

    public boolean addDriver(Driver driver){
        boolean isAdded = driverDao.addDriver(driver);
        creditCardService.saveCreditCard(driver.getCreditCard(), getDriverByName(driver.getName()));
        return isAdded;
    }

    public Driver getDriverByName(String name){
        Driver driver = driverDao.getDriverByName(name);
        driver.setCreditCard(creditCardService.getCreditCardByDriver(driver.getId()));
        return driver;
    }

    public Driver getDriver(int id){
        Driver driver = driverDao.getDriver(id);
        driver.setCreditCard(creditCardService.getCreditCardByDriver(driver.getId()));
        return driver;
    }

    public List<Driver> getDrivers(){
        List<Driver> drivers = driverDao.getDrivers();
        for (Driver driver : drivers)
            driver.setCreditCard(creditCardService.getCreditCardByDriver(driver.getId()));

        return drivers;
    }

    public boolean deleteDriver(int id){
        return driverDao.deleteDriver(id);
    }

    public boolean updateDriver(Driver driver){
        return driverDao.updateDriver(driver);
    }

    public boolean rentCar(int driver_id, int car_id, double distance){
        Car foundCar = carService.getCar(car_id);
        if(!foundCar.getIsRent()) {
            driverDao.setCarForDriver(driver_id, car_id);
            Car car = carService.getCar(car_id);
            car.setDistance(distance);
            car.setTotalKilometrage(car.getTotalKilometrage() + distance);
            carService.updateCar(car);

            companyService.increaseIncome(car.getPrice() * car.getDistance() / 200);
            return true;
        }
        return false;
    }

}
