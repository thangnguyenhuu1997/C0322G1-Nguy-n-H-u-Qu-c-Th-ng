package repository.customer.impl;

import model.customer.Customer;
import repository.BaseRepository;
import repository.customer.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final String SELECT_ALL_CUSTOMER = "SELECT * FROM customer";
    private final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM customer where customer_id = ?;";
    private final String INSERT_NEW_CUSTOMER = "insert into customer (customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address) values (?,?,?,?,?,?,?,?);";
    private final String DELETE_CUSTOMER = "delete from customer where customer_id = ?;";
    private final String SEARCH_BY_KEYWORD = "select * from customer where customer_id like ? and customer_name like ?;";
    private final String UPDATE_CUSTOMER = "update customer set customer_type_id =?, customer_name =?, customer_birthday=?, customer_gender=?, customer_id_card=?, customer_phone=?, customer_email=?, customer_address=? where customer_id = ?;";

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                int customer_gender = resultSet.getInt("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                Customer customer = new Customer(customer_id,
                        customer_type_id,
                        customer_name,
                        customer_birthday,
                        customer_gender,
                        customer_id_card,
                        customer_phone,
                        customer_email,
                        customer_address);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                int customer_gender = resultSet.getInt("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                customer = new Customer(customer_id,
                        customer_type_id,
                        customer_name,
                        customer_birthday,
                        customer_gender,
                        customer_id_card,
                        customer_phone,
                        customer_email,
                        customer_address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public void insertCustomer(Customer customer)  {
        System.out.println(INSERT_NEW_CUSTOMER);
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_NEW_CUSTOMER);
            preparedStatement.setInt(1, customer.getCustomer_type_id());
            preparedStatement.setString(2, customer.getCustomer_name());
            preparedStatement.setDate(3, Date.valueOf(customer.getCustomer_birthday()));
            preparedStatement.setInt(4, customer.getCustomer_gender());
            preparedStatement.setString(5, customer.getCustomer_id_card());
            preparedStatement.setString(    6, customer.getCustomer_phone());
            preparedStatement.setString(7, customer.getCustomer_email());
            preparedStatement.setString(8, customer.getCustomer_address());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setInt(1, customer.getCustomer_type_id());
            preparedStatement.setString(2, customer.getCustomer_name());
            preparedStatement.setDate(3, Date.valueOf(customer.getCustomer_birthday()));
            preparedStatement.setInt(4, customer.getCustomer_gender());
            preparedStatement.setString(5, customer.getCustomer_id_card());
            preparedStatement.setString(6, customer.getCustomer_phone());
            preparedStatement.setString(7, customer.getCustomer_email());
            preparedStatement.setString(8, customer.getCustomer_address());
            preparedStatement.setInt(9, customer.getCustomer_id());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Customer> searchCustomer(String idSearch, String nameSearch) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_KEYWORD);
            preparedStatement.setString(1, "%" + idSearch + "%");
            preparedStatement.setString(2, "%" + nameSearch + "%");
            System.out.println(SEARCH_BY_KEYWORD);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                int customer_gender = resultSet.getInt("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                Customer customer = new Customer(customer_id,
                        customer_type_id,
                        customer_name,
                        customer_birthday,
                        customer_gender,
                        customer_id_card,
                        customer_phone,
                        customer_email,
                        customer_address);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
}