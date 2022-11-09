package com.misharyduk.CarRent.service;

import com.misharyduk.CarRent.dao.EmployeeDao;
import com.misharyduk.CarRent.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee getEmployee(int employee_id){
        return employeeDao.getEmployee(employee_id);
    }

    public List<Employee> getAllEmployee(){
        return employeeDao.getAllEmployee();
    }

}
