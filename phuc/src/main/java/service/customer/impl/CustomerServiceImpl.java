package service.customer.impl;

import model.customer.Customer;
import repository.customer.ICustomerRepository;
import repository.customer.impl.CustomerRepositoryImpl;
import service.customer.ICustomerService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class CustomerServiceImpl implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepositoryImpl();
    public static final String REGEX_NAME = "^[\\p{Lu}\\p{Ll}\\s]+$";
    //public static final String REGEX_DATE = "^((((19|[2-9]\\d)\\d{2})\\-(0[13578]|1[02])\\-(0[1-9]|[12]\\d|3[01]))|(((19|[2-9]\\d)\\d{2})\\-(0[13456789]|1[012])\\-(0[1-9]|[12]\\d|30))|(((19|[2-9]\\d)\\d{2})\\-02\\-(0[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))\\-02\\-29))$";
    public static final String REGEX_NUMBER = "^[0-9]+$";
    public static final String REGEX_PHONE =   "^(84|0[3|5|7|8|9])+([0-9]{8})$"; //"^((\\(84\\)(\\+))|0)(90|91)+([0-9]{7})$";
    public static final String REGEX_EMAIL = "^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String REGEX_CODE_CUSTOMER ="^KH(\\-)[0-9]{4}$";

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.selectAllCustomer();
    }

    @Override
    public Customer selectCustomer(int id) {
        return customerRepository.selectCustomer(id);
    }

    @Override
    public Map<String, String> save(Customer customer) {
        Map<String, String> map = new HashMap<>();
        boolean flag = true;
//        if (!Pattern.matches(REGEX_CODE_CUSTOMER,customer.getCustomerIdCard())){
//            flag = false;
//            map.put("code","Mã khách hàng phải có định dạng KH-XXXX (KH-0001)");
//        }
        if (!Pattern.matches(REGEX_NAME,customer.getCustomerName())){
            flag = false;
            map.put("name","Tên phải viết hoa chữ cái đầu");
        }
        if (!Pattern.matches(REGEX_NUMBER,customer.getCustomerIdCard())){
            flag = false;
            map.put("idCard","Chứng minh thư phải có định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (x = 0-9)");
        }
        if (!Pattern.matches(REGEX_PHONE,customer.getCustomerPhone())){
            flag = false;
            map.put("phone","Số điện thoại có định dạng (84)+90xxxxxxx hoặc (84)+91xxxxxxx");
        }
        if (!Pattern.matches(REGEX_EMAIL,customer.getCustomerEmail())){
            flag = false;
            map.put("email","Email phải có định dạng abcxyz@gmail.com");
        }
        if (flag){
            try {
                customerRepository.insertCustomer(customer);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return map;
    }

    @Override
    public Map<String, String> updateCustomer(Customer customer){
        Map<String, String> map = new HashMap<>();
        boolean flag = true;
        if (!Pattern.matches(REGEX_NAME,customer.getCustomerName())){
            flag = false;
            map.put("name","Tên phải viết hoa chữ cái đầu");
        }
        if (!Pattern.matches(REGEX_NUMBER,customer.getCustomerIdCard())){
            flag = false;
            map.put("idCard","Chứng minh thư phải có định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (x = 0-9)");
        }
        if (!Pattern.matches(REGEX_PHONE,customer.getCustomerPhone())){
            flag = false;
            map.put("phone","Số điện thoại có định dạng (84)+90xxxxxxx hoặc (84)+91xxxxxxx");
        }
        if (!Pattern.matches(REGEX_EMAIL,customer.getCustomerEmail())){
            flag = false;
            map.put("email","Email phải có định dạng abcxyz@gmail.com");
        }
        if (flag){
            try {
                customerRepository.updateCustomer(customer);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return map;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return  customerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> searchCustomer(String idSearch, String nameSearch) {
        return customerRepository.searchCustomer(idSearch, nameSearch);
    }
}
