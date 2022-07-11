package repository.impl;

import model.*;
import repository.BaseRepository;
import repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String INSERT_CUSTOMER_SQL = "insert into customer (customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address) values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id = ?;";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer where flag = 0";
    private static final String SELECT_ALL= "select * from customer";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_type_id = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, customer_phone = ?,  customer_email = ?, customer_address = ? where customer_id = ?;";
    private static final String DELETE_CUSTOMER_SQL = "update customer set flag = 1 where customer_id = ?;";
    private static final String SEARCH_SQL = "select * from customer where customer_name like ? or customer_birthday like ? or customer_id_card like ? or customer_phone like ? or customer_email like ? or customer_address like ?;";

    @Override
    public List<Customer> selectAll() {
        List<Customer> customerList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("customer_id"));

                int customerTypeID = Integer.parseInt(rs.getString("customer_type_id"));
                String name = rs.getString("customer_name");

                String birthDay = rs.getString("customer_birthday");
                int gender = Integer.parseInt(rs.getString("customer_gender"));

                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");

                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");

                customerList.add(new Customer(id, customerTypeID, name, birthDay, gender, idCard, phone, email, address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerList;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("customer_id"));

                int customerTypeID = Integer.parseInt(rs.getString("customer_type_id"));
                String name = rs.getString("customer_name");

                String birthDay = rs.getString("customer_birthday");
                int gender = Integer.parseInt(rs.getString("customer_gender"));

                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");

                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");

                customerList.add(new Customer(id, customerTypeID, name, birthDay, gender, idCard, phone, email, address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerList;
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int customerTypeID = Integer.parseInt(rs.getString("customer_type_id"));
                String name = rs.getString("customer_name");

                String birthDay = rs.getString("customer_birthday");
                int gender = Integer.parseInt(rs.getString("customer_gender"));

                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");

                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");

                customer = new Customer(id, customerTypeID, name, birthDay, gender, idCard, phone, email, address);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return customer;
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {

            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setInt(2, customer.getCustomerTypeID());

            preparedStatement.setString(3, customer.getName());
            preparedStatement.setDate(4, Date.valueOf(customer.getBirthDay()));

            preparedStatement.setInt(5, customer.getGender());
            preparedStatement.setString(6, customer.getIdCard());

            preparedStatement.setString(7, customer.getPhone());
            preparedStatement.setString(8, customer.getEmail());

            preparedStatement.setString(9, customer.getAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)) {

            statement.setInt(1, customer.getCustomerTypeID());
            statement.setString(2, customer.getName());

            statement.setDate(3, Date.valueOf(customer.getBirthDay()));
            statement.setInt(4, customer.getGender());

            statement.setString(5, customer.getIdCard());
            statement.setString(6, customer.getPhone());

            statement.setString(7, customer.getEmail());
            statement.setString(8, customer.getAddress());

            statement.setInt(9, customer.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }

        return rowUpdated;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<Customer> search(String keySearch) {
        List<Customer> customerList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SQL)) {

            preparedStatement.setString(1, "%" + keySearch + "%");
            preparedStatement.setString(2, "%" + keySearch + "%");
            preparedStatement.setString(3, "%" + keySearch + "%");
            preparedStatement.setString(4, "%" + keySearch + "%");
            preparedStatement.setString(5, "%" + keySearch + "%");
            preparedStatement.setString(6, "%" + keySearch + "%");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("customer_id"));

                int customerTypeID = Integer.parseInt(rs.getString("customer_type_id"));
                String name = rs.getString("customer_name");

                String birthDay = rs.getString("customer_birthday");
                int gender = Integer.parseInt(rs.getString("customer_gender"));

                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");

                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");

                customerList.add(new Customer(id, customerTypeID, name, birthDay, gender, idCard, phone, email, address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return customerList;
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
