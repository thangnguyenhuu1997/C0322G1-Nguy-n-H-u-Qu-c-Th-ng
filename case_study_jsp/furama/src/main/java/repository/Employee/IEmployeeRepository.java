package repository.Employee;

import model.employee.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeRepository {
    public List<Employee> selectAllEmployee();

    public Employee selectEmployee(int id);

    public void insertEmployee(Employee employee) throws SQLException;

    public boolean updateEmployee(Employee employee) throws SQLException;

    public boolean deleteEmployee(int id) throws SQLException;

    public List<Employee> searchCustomer(String idSearch, String nameSearch);
}
