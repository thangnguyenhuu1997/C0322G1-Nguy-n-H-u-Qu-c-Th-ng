package repository.employee.impl;

import model.employee.Employee;
import repository.BaseRepository;
import repository.employee.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    private final String SELECT_ALL_EMPLOYEE = "SELECT * FROM employee";
    private final String INSERT_NEW_EMPLOYEE = "insert into employee (employee_name," +
            " employee_birthday," +
            " employee_id_card," +
            " employee_salary," +
            " employee_phone," +
            " employee_email," +
            " employee_address," +
            " position_id," +
            " education_degree_id," +
            " division_id," +
            " username)" +
            " values (?,?,?,?,?,?,?,?,?,?,?);";
    private final String UPDATE_EMPLOYEE = "UPDATE `employee` SET `employee_name` = ?," +
                                                                " `employee_birthday` = ?," +
                                                                " `employee_id_card` = ?," +
                                                                " `employee_salary` = ?," +
                                                                " `employee_phone` = ?," +
                                                                " `employee_email` = ?," +
                                                                " `employee_address` = ?," +
                                                                " `position_id` = ?," +
                                                                " `education_degree_id` = ?," +
                                                                " `division_id` = ?," +
                                                                " `username` = ?" +
                                                                " WHERE (`employee_id` = ?);";
    private final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id = ?;";
    private final String DELETE_EMPLOYEE_BY_ID = "delete from employee where employee_id = ?;";

    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                Employee employee = new Employee(employeeId,
                                                employeeName,
                                                employeeBirthday,
                                                employeeIdCard,
                                                employeeSalary,
                                                employeePhone,
                                                employeeEmail,
                                                employeeAddress,
                                                positionId,
                                                educationDegreeId,
                                                divisionId,username);
                employeeList.add(employee);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                employee = new Employee(employeeId,
                                        employeeName,
                                        employeeBirthday,
                                        employeeIdCard,
                                        employeeSalary,
                                        employeePhone,
                                        employeeEmail,
                                        employeeAddress,
                                        positionId,
                                        educationDegreeId,
                                        divisionId,
                                        username);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        System.out.println(INSERT_NEW_EMPLOYEE);
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_NEW_EMPLOYEE);
            ps.setString(1,employee.getEmployeeName());
            ps.setString(2,employee.getEmployeeBirth());
            ps.setString(3,employee.getEmployeeIdCard());
            ps.setDouble(4,employee.getEmployeeSalary());
            ps.setString(5,employee.getEmployeePhone());
            ps.setString(6,employee.getEmployeeEmail());
            ps.setString(7,employee.getEmployeeAddress());
            ps.setInt(8,employee.getPositionId());
            ps.setInt(9,employee.getEducationDegreeId());
            ps.setInt(10,employee.getDivisionId());
            ps.setString(11,employee.getUsername());
            ps.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_EMPLOYEE);
            ps.setString(1,employee.getEmployeeName());
            ps.setString(2,employee.getEmployeeBirth());
            ps.setString(3,employee.getEmployeeIdCard());
            ps.setDouble(4,employee.getEmployeeSalary());
            ps.setString(5,employee.getEmployeePhone());
            ps.setString(6,employee.getEmployeeEmail());
            ps.setString(7,employee.getEmployeeAddress());
            ps.setInt(8,employee.getPositionId());
            ps.setInt(9,employee.getEducationDegreeId());
            ps.setInt(10,employee.getDivisionId());
            ps.setString(11,employee.getUsername());
            ps.setInt(12,employee.getEmployeeId());
            return ps.executeUpdate() > 0;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID);
            ps.setInt(1, id);
            return ps.executeUpdate()>0;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Employee> searchEmployee(String keyword) {
        return null;
    }
}
