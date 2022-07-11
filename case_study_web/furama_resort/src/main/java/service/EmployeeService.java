package service;

import model.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee> selectAll();

    List<Employee> selectAllEmployee();

    Employee selectEmployee(int id);

    Map<String, String> insertEmployee(Employee employee) throws SQLException;

    Map<String, String> updateEmployee(Employee employee) throws SQLException;

    boolean deleteEmployee(int id) throws SQLException;

    List<Employee> search(String keySearch);
}
