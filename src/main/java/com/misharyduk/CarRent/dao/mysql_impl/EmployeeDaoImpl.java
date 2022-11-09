package com.misharyduk.CarRent.dao.mysql_impl;

import com.misharyduk.CarRent.dao.EmployeeDao;
import com.misharyduk.CarRent.model.Company;
import com.misharyduk.CarRent.model.Employee;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl extends CommonMySQL implements EmployeeDao {

    @Override
    public Employee getEmployee(int employee_id) {
        Employee employee = new Employee();
        String SQLQuery = "SELECT * FROM Employee WHERE id=?";
        try(PreparedStatement statement = getConnection().prepareStatement(SQLQuery)){
            statement.setInt(1, employee_id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                CompanyDaoImpl companyDao = new CompanyDaoImpl();
                employee.setCompany(companyDao.getCompany());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();

        String SQLQuery = "SELECT * FROM Employee";
        try(Statement statement = getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(SQLQuery);
            CompanyDaoImpl companyDao = new CompanyDaoImpl();
            Company company = companyDao.getCompany();
            while(resultSet.next()){
                Employee employee = new Employee();

                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));

                employee.setCompany(company);

                employees.add(employee);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return employees;
    }
}
