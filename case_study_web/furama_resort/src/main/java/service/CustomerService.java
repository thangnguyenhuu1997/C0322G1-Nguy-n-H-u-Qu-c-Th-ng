package service;

import model.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> selectAll();

    List<Customer> selectAllCustomer();

    Customer selectCustomer(int id);

    Map<String, String> insertCustomer(Customer customer) throws SQLException;

    Map<String, String> updateCustomer(Customer customer) throws SQLException;

    boolean deleteCustomer(int id) throws SQLException;

    List<Customer> search(String keySearch);
}
