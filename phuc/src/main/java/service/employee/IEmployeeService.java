package service.employee;

import model.employee.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IEmployeeService {

    public List<Employee> selectAllEmployee();

    public Employee selectEmployee(int id);

    public Map<String, String> save(Employee employee);

    public Map<String, String> updateEmployee(Employee employee);

    public boolean deleteEmployee(int id) throws SQLException;

    public List<Employee> searchEmployee(String keyword);

}
