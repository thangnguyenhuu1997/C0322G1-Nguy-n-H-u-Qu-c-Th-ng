package service.employee.impl;

import model.employee.Employee;
import repository.Employee.IEmployeeRepository;
import repository.Employee.impl.EmployeeRepository;
import service.employee.IEmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> selectAllEmployee() {
        return employeeRepository.selectAllEmployee();
    }

    @Override
    public Employee selectEmployee(int id) {
        return employeeRepository.selectEmployee(id);
    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        employeeRepository.insertEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> searchCustomer(String idSearch, String nameSearch) {
        return employeeRepository.searchCustomer(idSearch,nameSearch);
    }
}
