package controller;

import model.*;
import service.CustomerService;
import service.CustomerTypeService;
import service.impl.CustomerServiceImpl;
import service.impl.CustomerTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerController", urlPatterns = "/customer")
public class CustomerController extends HttpServlet {
    private final CustomerService customerService = new CustomerServiceImpl();
    private final CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                try {
                    insertCustomer(request, response);
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateCustomer(request, response);
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteCustomer(request, response);
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                break;
            default:
                customerList(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "deleteAll":
                try {
                    deleteCustomer(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "search":
                search(request, response);
                break;
            default:
                customerList(request, response);
                break;
        }
    }

    private void customerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);

        List<Customer> customerList = customerService.selectAllCustomer();
        request.setAttribute("customerList", customerList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);

        int id = Integer.parseInt(request.getParameter("id"));

        Customer customer = customerService.selectCustomer(id);
        request.setAttribute("customer", customer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Customer> customerList = customerService.selectAll();

        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);

        int max = 0;
        if (customerList.size() == 0) {
            max = 1;
        } else {
            for (Customer item : customerList) {
                if (max < item.getId()) {
                    max = item.getId();
                }
            }
        }

        int id = max + 1;
        Integer customerTypeID = null;
        if (!String.valueOf(customerTypeID).equals("")) {
            customerTypeID = Integer.parseInt(request.getParameter("customerTypeID"));
        } else {
            customerTypeID = null;
        }

        String name = request.getParameter("name");

        String birthDay = request.getParameter("birthDay");
        int gender = Integer.parseInt(request.getParameter("gender"));

        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");

        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id, customerTypeID, name, birthDay, gender, idCard, phone, email, address);

        Map<String, String> error = customerService.insertCustomer(customer);
        if (error.isEmpty()) {
            request.setAttribute("message", "Thêm mới thành công");
        } else {
            request.setAttribute("message", "Thêm mới thất bại");
            request.setAttribute("error", error);
        }

        request.getRequestDispatcher("view/customer/create.jsp").forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);

        int id = Integer.parseInt(request.getParameter("id"));

        int customerTypeID = Integer.parseInt(request.getParameter("customerTypeID"));
        String name = request.getParameter("name");

        String birthDay = request.getParameter("birthDay");
        int gender = Integer.parseInt(request.getParameter("gender"));

        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");

        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id, customerTypeID, name, birthDay, gender, idCard, phone, email, address);
        Map<String, String> error = customerService.updateCustomer(customer);

        request.setAttribute("customer", customer);

        if (error.isEmpty()) {
            request.setAttribute("message", "Cập nhật thành công");
        } else {
            request.setAttribute("message", "Cập nhật thất bại");
            request.setAttribute("error", error);
        }

        request.getRequestDispatcher("view/customer/edit.jsp").forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        customerService.deleteCustomer(id);

        //request.setAttribute("mess", "Đã xóa thành công");

        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);

        List<Customer> customerList = customerService.selectAllCustomer();
        request.setAttribute("customerList", customerList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keySearch = request.getParameter("keySearch");

        List<Customer> customerList = customerService.search(keySearch);
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();

        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        dispatcher.forward(request, response);
    }
}
