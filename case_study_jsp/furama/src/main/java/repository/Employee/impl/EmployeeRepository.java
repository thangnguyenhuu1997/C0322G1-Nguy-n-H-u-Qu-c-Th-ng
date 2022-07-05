package repository.Employee.impl;

import model.employee.Employee;
import repository.BaseRepository;
import repository.Employee.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final String SELECT_ALL_EMPLOYEE = "SELECT * FROM employee";
    private final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employee where employee_id = ?;";
    private final String INSERT_NEW_EMPLOYEE = "insert into employee (employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username) values (?,?,?,?,?,?,?,?,?,?,?);";
    private final String DELETE_EMPLOYEE = "delete from employee where employee_id = ?;";
    private final String SEARCH_BY_KEYWORD = "select * from employee where employee_id like ? and employee_name like ?;";
    private final String UPDATE_EMPLOYEE = "update employee set employee_name =?, employee_birthday =?, employee_id_card=?, employee_salary=?, employee_phone=?, employee_email=?, employee_address=?, position_id=?, education_degree_id=?, division_id=?, username=? where employee_id = ?;";

    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employee_id = resultSet.getInt("employee_id");
                String employee_name = resultSet.getString("employee_name");
                String employee_birthday = resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                double employee_salary = resultSet.getDouble("employee_salary");
                String employee_phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                String employee_address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                Employee employee = new Employee(employee_id,
                        employee_name,
                        employee_birthday,
                        employee_id_card,
                        employee_salary,
                        employee_phone,
                        employee_email,
                        employee_address,
                        position_id,
                        education_degree_id,
                        division_id,
                        username);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employee_id = resultSet.getInt("employee_id");
                String employee_name = resultSet.getString("employee_name");
                String employee_birthday = resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                double employee_salary = resultSet.getDouble("employee_salary");
                String employee_phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                String employee_address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                employee = new Employee(employee_id,
                        employee_name,
                        employee_birthday,
                        employee_id_card,
                        employee_salary,
                        employee_phone,
                        employee_email,
                        employee_address,
                        position_id,
                        education_degree_id,
                        division_id,
                        username);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        System.out.println(INSERT_NEW_EMPLOYEE);
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_NEW_EMPLOYEE);
            preparedStatement.setString(1, employee.getEmployee_name());
            preparedStatement.setDate(2, Date.valueOf(employee.getEmployee_birthday()));
            preparedStatement.setString(3, employee.getEmployee_id_card());
            preparedStatement.setDouble(4,employee.getEmployee_salary());
            preparedStatement.setString(5, employee.getEmployee_phone());
            preparedStatement.setString(6, employee.getEmployee_email());
            preparedStatement.setString(7, employee.getEmployee_address());
            preparedStatement.setInt(8,employee.getPosition_id());
            preparedStatement.setInt(9,employee.getEducation_degree_id());
            preparedStatement.setInt(10,employee.getDivision_id());
            preparedStatement.setString(11, employee.getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
            preparedStatement.setString(1, employee.getEmployee_name());
            preparedStatement.setDate(2, Date.valueOf(employee.getEmployee_birthday()));
            preparedStatement.setString(3, employee.getEmployee_id_card());
            preparedStatement.setDouble(4,employee.getEmployee_salary());
            preparedStatement.setString(5, employee.getEmployee_phone());
            preparedStatement.setString(6, employee.getEmployee_email());
            preparedStatement.setString(7, employee.getEmployee_address());
            preparedStatement.setInt(8,employee.getPosition_id());
            preparedStatement.setInt(9,employee.getEducation_degree_id());
            preparedStatement.setInt(10,employee.getDivision_id());
            preparedStatement.setString(11, employee.getUsername());
            preparedStatement.setInt(12,employee.getEmployee_id());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Employee> searchCustomer(String idSearch, String nameSearch) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_KEYWORD);
            preparedStatement.setString(1, "%" + idSearch + "%");
            preparedStatement.setString(2, "%" + nameSearch + "%");
            System.out.println(SEARCH_BY_KEYWORD);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employee_id = resultSet.getInt("employee_id");
                String employee_name = resultSet.getString("employee_name");
                String employee_birthday = resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                double employee_salary = resultSet.getDouble("employee_salary");
                String employee_phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                String employee_address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                Employee employee = new Employee(employee_id,
                        employee_name,
                        employee_birthday,
                        employee_id_card,
                        employee_salary,
                        employee_phone,
                        employee_email,
                        employee_address,
                        position_id,
                        education_degree_id,
                        division_id,
                        username);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }
}
