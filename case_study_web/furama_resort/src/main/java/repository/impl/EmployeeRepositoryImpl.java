package repository.impl;

import model.Employee;
import repository.BaseRepository;
import repository.EmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final String INSERT_EMPLOYEE_SQL = "insert into employee (employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id = ?;";
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee where flag = 0";
    private static final String SELECT_ALL= "select * from employee";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set employee_name = ?, employee_birthday = ?, employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?,  employee_address = ?, position_id = ?, education_degree_id = ?, division_id = ?, username = ? where employee_id = ?;";
    private static final String DELETE_EMPLOYEE_SQL = "update employee set flag = 1 where employee_id = ?;";
    private static final String SEARCH_SQL = "select * from customer where employee_name like ? or employee_birthday like ? or employee_id_card like ? or employee_phone like ? or employee_email like ? or employee_address like ? or username like ?;";

    @Override
    public List<Employee> selectAll() {
        List<Employee> employeeList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("employee_id"));
                String name = rs.getString("employee_name");

                String birthDay = rs.getString("employee_birthday");
                String idCard = rs.getString("employee_id_card");

                double salary = Double.parseDouble(rs.getString("employee_salary"));
                String phone = rs.getString("employee_phone");

                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");

                int positionId = Integer.parseInt(rs.getString("position_id"));
                int educationDegreeId = Integer.parseInt(rs.getString("education_degree_id"));

                int divisionId = Integer.parseInt(rs.getString("division_id"));
                String username = rs.getString("username");

                employeeList.add(new Employee(id, name, birthDay, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, username));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employeeList;
    }

    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("employee_id"));
                String name = rs.getString("employee_name");

                String birthDay = rs.getString("employee_birthday");
                String idCard = rs.getString("employee_id_card");

                double salary = Double.parseDouble(rs.getString("employee_salary"));
                String phone = rs.getString("employee_phone");

                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");

                int positionId = Integer.parseInt(rs.getString("position_id"));
                int educationDegreeId = Integer.parseInt(rs.getString("education_degree_id"));

                int divisionId = Integer.parseInt(rs.getString("division_id"));
                String username = rs.getString("username");

                employeeList.add(new Employee(id, name, birthDay, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, username));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employeeList;
    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null;

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("employee_name");

                String birthDay = rs.getString("employee_birthday");
                String idCard = rs.getString("employee_id_card");

                double salary = Double.parseDouble(rs.getString("employee_salary"));
                String phone = rs.getString("employee_phone");

                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");

                int positionId = Integer.parseInt(rs.getString("position_id"));
                int educationDegreeId = Integer.parseInt(rs.getString("education_degree_id"));

                int divisionId = Integer.parseInt(rs.getString("division_id"));
                String username = rs.getString("username");

                employee = new Employee(id, name, birthDay, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, username);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {

            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());

            statement.setDate(3, Date.valueOf(employee.getBirthDay()));
            statement.setString(4, employee.getIdCard());

            statement.setDouble(5, employee.getSalary());
            statement.setString(6, employee.getPhone());

            statement.setString(7, employee.getEmail());
            statement.setString(8, employee.getAddress());

            statement.setInt(9, employee.getPositionId());
            statement.setInt(10, employee.getEducationDegreeId());

            statement.setInt(11, employee.getDivisionId());
            statement.setString(12, employee.getUsername());

            statement.executeUpdate();
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {

            statement.setString(1, employee.getName());
            statement.setDate(2, Date.valueOf(employee.getBirthDay()));

            statement.setString(3, employee.getIdCard());
            statement.setDouble(4, employee.getSalary());

            statement.setString(5, employee.getPhone());
            statement.setString(6, employee.getEmail());

            statement.setString(7, employee.getAddress());
            statement.setInt(8, employee.getPositionId());

            statement.setInt(9, employee.getEducationDegreeId());
            statement.setInt(10, employee.getDivisionId());

            statement.setString(11, employee.getUsername());
            statement.setInt(12, employee.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<Employee> search(String keySearch) {
        List<Employee> employeeList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SQL)) {

            preparedStatement.setString(1, "%" + keySearch + "%");
            preparedStatement.setString(2, "%" + keySearch + "%");
            preparedStatement.setString(3, "%" + keySearch + "%");
            preparedStatement.setString(4, "%" + keySearch + "%");
            preparedStatement.setString(5, "%" + keySearch + "%");
            preparedStatement.setString(6, "%" + keySearch + "%");
            preparedStatement.setString(7, "%" + keySearch + "%");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("employee_id"));
                String name = rs.getString("employee_name");

                String birthDay = rs.getString("employee_birthday");
                String idCard = rs.getString("employee_id_card");

                double salary = Double.parseDouble(rs.getString("employee_salary"));
                String phone = rs.getString("employee_phone");

                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");

                int positionId = Integer.parseInt(rs.getString("position_id"));
                int educationDegreeId = Integer.parseInt(rs.getString("education_degree_id"));

                int divisionId = Integer.parseInt(rs.getString("division_id"));
                String username = rs.getString("username");

                employeeList.add(new Employee(id, name, birthDay, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, username));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return employeeList;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
