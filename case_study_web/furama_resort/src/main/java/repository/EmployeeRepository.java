package repository;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {
    List<Employee> selectAll();

    List<Employee> selectAllEmployee();

    Employee selectEmployee(int id);

    void insertEmployee(Employee employee) throws SQLException;

    boolean updateEmployee(Employee employee) throws SQLException;

    boolean deleteEmployee(int id) throws SQLException;

    List<Employee> search(String keySearch);
}
