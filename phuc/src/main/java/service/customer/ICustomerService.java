package service.customer;

import model.customer.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICustomerService {

    public List<Customer> selectAllCustomer();

    public Customer selectCustomer(int id);

    public Map<String, String> save(Customer customer);

    public Map<String, String> updateCustomer(Customer customer);

    public boolean deleteCustomer(int id) throws SQLException;

    public List<Customer> searchCustomer(String idSearch, String nameSearch);

}
