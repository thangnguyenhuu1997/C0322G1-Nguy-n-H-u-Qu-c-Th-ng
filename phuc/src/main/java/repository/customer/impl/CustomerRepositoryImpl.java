package repository.customer.impl;

import model.customer.Customer;
import repository.BaseRepository;
import repository.customer.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    private final String SELECT_ALL_CUSTOMER = "SELECT * FROM customer";
    private final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM customer where customer_id = ?;";
    private final String INSERT_NEW_CUSTOMER = "insert into customer (customer_code,customer_type_id, customer_name, customer_birth, customer_gender, customer_id_card, customer_phone, customer_email, customer_address)\n" +
                                                "values (?,?,?,?,?,?,?,?,?);";
    private final String DELETE_CUSTOMER = "delete from customer where customer_id = ?;";
    private final String SEARCH_BY_KEYWORD = "select * from customer where customer_id like ? and customer_name like ?;";
    private final String UPDATE_CUSTOMER = "update customer set customer_code = ?," +
                                            " customer_type_id = ?," +
                                            " customer_name = ?," +
                                            " customer_birth = ?," +
                                            " customer_gender = ?," +
                                            " customer_id_card = ?," +
                                            " customer_phone = ?," +
                                            " customer_email = ?," +
                                            " customer_address = ?" +
                                            " where customer_id = ?;";

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int customerId = resultSet.getInt("customer_id");
                String customerCode = resultSet.getString("customer_code");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirth = resultSet.getString("customer_birth");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                Customer customer = new Customer(customerId,
                        customerCode,
                        customerTypeId,
                        customerName,
                        customerBirth,
                        customerGender,
                        customerIdCard,
                        customerPhone,
                        customerEmail,
                        customerAddress);
                customerList.add(customer);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            ps.setInt(1, id);
            System.out.println(ps);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int customerId = resultSet.getInt("customer_id");
                String customerCode = resultSet.getString("customer_code");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirth = resultSet.getString("customer_birth");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                customer = new Customer(customerId,
                        customerCode,
                        customerTypeId,
                        customerName,
                        customerBirth,
                        customerGender,
                        customerIdCard,
                        customerPhone,
                        customerEmail,
                        customerAddress);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        System.out.println(INSERT_NEW_CUSTOMER);
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_NEW_CUSTOMER);
            ps.setString(1,customer.getCustomerCode());
            ps.setInt(2, customer.getCustomerTypeId());
            ps.setString(3, customer.getCustomerName());
            ps.setDate(4, Date.valueOf(customer.getCustomerBirth()));
            ps.setInt(5, customer.getCustomerGender());
            ps.setString(6, customer.getCustomerIdCard());
            ps.setString(7, customer.getCustomerPhone());
            ps.setString(8, customer.getCustomerEmail());
            ps.setString(9, customer.getCustomerAddress());
            System.out.println(ps);
            ps.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_CUSTOMER);
            ps.setString(1,customer.getCustomerCode());
            ps.setInt(2, customer.getCustomerTypeId());
            ps.setString(3, customer.getCustomerName());
            ps.setDate(4, Date.valueOf(customer.getCustomerBirth()));
            ps.setInt(5, customer.getCustomerGender());
            ps.setString(6, customer.getCustomerIdCard());
            ps.setString(7, customer.getCustomerPhone());
            ps.setString(8, customer.getCustomerEmail());
            ps.setString(9, customer.getCustomerAddress());
            ps.setInt(10, customer.getCustomerId());
            return ps.executeUpdate()>0;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_CUSTOMER);
            ps.setInt(1, id);
            return ps.executeUpdate()>0;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Customer> searchCustomer(String idSearch, String nameSearch) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SEARCH_BY_KEYWORD);
            ps.setString(1, "%" + idSearch + "%");
            ps.setString(2, "%" + nameSearch + "%");
            System.out.println(SEARCH_BY_KEYWORD);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int customerId = resultSet.getInt("customer_id");
                String customerCode = resultSet.getString("customer_code");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirth = resultSet.getString("customer_birth");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                Customer customer = new Customer(customerId,
                        customerCode,
                        customerTypeId,
                        customerName,
                        customerBirth,
                        customerGender,
                        customerIdCard,
                        customerPhone,
                        customerEmail,
                        customerAddress);
                customerList.add(customer);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return customerList;
    }
}
