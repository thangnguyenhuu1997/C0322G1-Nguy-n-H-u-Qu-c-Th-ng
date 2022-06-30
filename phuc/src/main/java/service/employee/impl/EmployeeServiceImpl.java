package service.employee.impl;

import model.employee.Employee;
import model.employee.User;
import repository.employee.IEmployeeRepository;
import repository.employee.IUserRepository;
import repository.employee.impl.EmployeeRepositoryImpl;
import repository.employee.impl.UserRepositoryImpl;
import service.employee.IEmployeeService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class EmployeeServiceImpl implements IEmployeeService {
    private IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    private IUserRepository userRepository = new UserRepositoryImpl();
    public static final String REGEX_NAME = "^[\\p{Lu}\\p{Ll}\\s]+$";
    public static final String REGEX_ID_CARD = "^[0-9]+$";
    public static final String REGEX_POSITIVE_NUMBER = "^[1-9]\\d$";
    public static final String REGEX_PHONE =   "^(84|0[3|5|7|8|9])+([0-9]{8})$";
    public static final String REGEX_EMAIL = "^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    @Override
    public List<Employee> selectAllEmployee() {
        return employeeRepository.selectAllEmployee();
    }

    @Override
    public Employee selectEmployee(int id) {
        return employeeRepository.selectEmployee(id);
    }

    @Override
    public Map<String, String> save(Employee employee) {
        Map<String, String> map = new HashMap<>();
        boolean flag = true;
        if (!Pattern.matches(REGEX_NAME,employee.getEmployeeName())){
            flag = false;
            map.put("name","Tên phải viết hoa chữ cái đầu");
        }
        if (employee.getEmployeeSalary() < 0){
            flag = false;
            map.put("number","Số nhỏ hơn 0, vui lòng nhập số dương");
        }
        if (!Pattern.matches(REGEX_PHONE,employee.getEmployeePhone())){
            flag = false;
            map.put("phone","Số điện thoại có định dạng (84)+90xxxxxxx hoặc (84)+91xxxxxxx");
        }
        if (!Pattern.matches(REGEX_EMAIL,employee.getEmployeeEmail())){
            flag = false;
            map.put("email","Email phải có định dạng abcxyz@gmail.com");
        }
        if (!Pattern.matches(REGEX_ID_CARD,employee.getEmployeeIdCard())){
            flag = false;
            map.put("idCard","Chứng minh thư phải có định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (x = 0-9)");
        }
        if (flag){
            try {
                String password = "123";
                User user = new User (employee.getEmployeeEmail(), password);
                userRepository.insertUser(user);
                employeeRepository.insertEmployee(employee);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return map;
    }

    @Override
    public Map<String, String> updateEmployee(Employee employee){
        Map<String, String> map = new HashMap<>();
        boolean flag = true;
        if (!Pattern.matches(REGEX_NAME,employee.getEmployeeName())){
            flag = false;
            map.put("name","Tên phải viết hoa chữ cái đầu");
        }
        if (!Pattern.matches(REGEX_PHONE,employee.getEmployeePhone())){
            flag = false;
            map.put("phone","Số điện thoại có định dạng (84)+90xxxxxxx hoặc (84)+91xxxxxxx");
        }
        if (!Pattern.matches(REGEX_EMAIL,employee.getEmployeeEmail())){
            flag = false;
            map.put("email","Email phải có định dạng abcxyz@gmail.com");
        }
        if (!Pattern.matches(REGEX_ID_CARD,employee.getEmployeeIdCard())){
            flag = false;
            map.put("idCard","Chứng minh thư phải có định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (x = 0-9)");
        }
        if (flag){
            try {
                employeeRepository.updateEmployee(employee);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return map;    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> searchEmployee(String keyword) {
        return null;
    }
}
