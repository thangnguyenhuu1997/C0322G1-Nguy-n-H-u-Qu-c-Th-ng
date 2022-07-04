package service.customer;

import model.customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    public List<Customer> selectAllCustomer();

    public Customer selectCustomer(int id);

    public void insertCustomer(Customer customer) ;

    public boolean updateCustomer(Customer customer) ;

    public boolean deleteCustomer(int id);

    public List<Customer> searchCustomer(String idSearch, String nameSearch);
}
