package service.impl;

import common.Validate;
import model.Employee;
import repository.EmployeeRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.EmployeeService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public List<Employee> selectAll() {
        return employeeRepository.selectAll();
    }

    @Override
    public List<Employee> selectAllEmployee() {
        return employeeRepository.selectAllEmployee();
    }

    @Override
    public Employee selectEmployee(int id) {
        return employeeRepository.selectEmployee(id);
    }

    @Override
    public Map<String, String> insertEmployee(Employee employee) throws SQLException {
        Map<String, String> error = new HashMap<>();

        if (employee.getName().equals("")) {
            error.put("name", "Tên không được để trống");
        } else if (!employee.getName().matches(Validate.NAME)) {
            error.put("name", "Tên nhân viên không hợp lệ");
        }

        if (employee.getIdCard().equals("")) {
            error.put("idCard", "ID Card không được để trống");
        } else if (!employee.getIdCard().matches(Validate.ID_CARD)) {
            error.put("idCard", "ID Card không hợp lệ");
        }

        if (employee.getPhone().equals("")) {
            error.put("phone", "Số điện thoại không được để trống");
        } else if (!employee.getPhone().matches(Validate.NUMBER_PHONE)) {
            error.put("phone", "Số điện thoại không hợp lệ");
        }

        if (employee.getEmail().equals("")) {
            error.put("email", "Email không được để trống");
        } else if (!employee.getEmail().matches(Validate.EMAIL)) {
            error.put("email", "Email không hợp lệ");
        }


        if (!String.valueOf(employee.getSalary()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("salary", "Salary không hợp lệ");
        }

        if (String.valueOf(employee.getAddress()).equals("")) {
            error.put("address", "*Địa chỉ không được để trống");
        }

        if (error.isEmpty()) {
            employeeRepository.insertEmployee(employee);
        }

        return error;
    }

    @Override
    public Map<String, String> updateEmployee(Employee employee) throws SQLException {
        Map<String, String> error = new HashMap<>();

        if (employee.getName().equals("")) {
            error.put("name", "Tên không được để trống");
        } else if (!employee.getName().matches(Validate.NAME)) {
            error.put("name", "Tên nhân viên hàng không hợp lệ");
        }

        if (employee.getIdCard().equals("")) {
            error.put("idCard", "ID Card không được để trống");
        } else if (!employee.getIdCard().matches(Validate.ID_CARD)) {
            error.put("idCard", "ID Card không hợp lệ");
        }

        if (employee.getPhone().equals("")) {
            error.put("phone", "Số điện thoại không được để trống");
        } else if (!employee.getPhone().matches(Validate.NUMBER_PHONE)) {
            error.put("phone", "Số điện thoại không hợp lệ");
        }

        if (employee.getEmail().equals("")) {
            error.put("email", "Email không được để trống");
        } else if (!employee.getEmail().matches(Validate.EMAIL)) {
            error.put("email", "Email không hợp lệ");
        }

        if (String.valueOf(employee.getAddress()).equals("")) {
            error.put("address", "*Địa chỉ không được để trống");
        }

        if (error.isEmpty()) {
            employeeRepository.updateEmployee(employee);
        }

        return error;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> search(String keySearch) {
        return employeeRepository.search(keySearch);
    }
}
