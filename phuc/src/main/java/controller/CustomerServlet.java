package controller;

import model.customer.Customer;
import model.customer.CustomerType;
import service.customer.ICustomerService;
import service.customer.ICustomerTypeService;
import service.customer.impl.CustomerServiceImpl;
import service.customer.impl.CustomerTypeServiceImpl;

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

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerServiceImpl();
    private ICustomerTypeService customerTypeService = new CustomerTypeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                save(request,response);
                break;
            case "update":
                update(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "search":
                search(request,response);
                break;
            default:
                showCustomerList(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            case "update":
                showFormUpdate(request,response);
                break;
            case "delete":
                break;
            case "search":
                search(request,response);
                break;
            default:
                showCustomerList(request,response);
        }
    }

    private void showCustomerList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.selectAllCustomer();
        request.setAttribute("customerList",customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/customer_list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> typeList = customerTypeService.selectAll();
        request.setAttribute("typeList",typeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        response.sendRedirect("view/customer/create.jsp");
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        Customer existCustomer = customerService.selectCustomer(customerId);
        List<CustomerType> typeList = customerTypeService.selectAll();
        request.setAttribute("typeList",typeList);
        request.setAttribute("customer",existCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        String customerCode = request.getParameter("customerCode");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String customerName = request.getParameter("customerName");
        String customerBirth = request.getParameter("customerBirth");
        int customerGender = Integer.parseInt(request.getParameter("customerGender"));
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        Customer customer = new Customer(customerCode,
                customerTypeId,
                customerName,
                customerBirth,
                customerGender,
                customerIdCard,
                customerPhone,
                customerEmail,
                customerAddress);
        Map<String, String> validate = customerService.save(customer);
        if (validate.isEmpty()){

            request.setAttribute("message","Thêm mới thành công");
        }else {
            request.setAttribute("message","Thêm mới không thành công");
            request.setAttribute("error",validate);
            request.setAttribute("customer",customer);
        }
        List<CustomerType> typeList = customerTypeService.selectAll();
        request.setAttribute("typeList",typeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("idCustomerToDelete"));
        try {
            boolean check = customerService.deleteCustomer(id);
            String mess = "Xóa không thành công";
            if (check){
                mess = "Xóa thành công";
            }
            request.setAttribute("mess", mess);
            showCustomerList(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String idSearch = request.getParameter("idSearch");
        String nameSearch = request.getParameter("nameSearch");
        List<Customer> customerList = customerService.searchCustomer(idSearch,nameSearch);
        request.setAttribute("customerList",customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/customer_list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String customerCode = request.getParameter("customerCode");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String customerName = request.getParameter("customerName");
        String customerBirth = request.getParameter("customerBirth");
        int customerGender = Integer.parseInt(request.getParameter("customerGender"));
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
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
        Map<String, String> validate = customerService.updateCustomer(customer);
        if (validate.isEmpty()){
            request.setAttribute("message","Cập nhật thành công");
        }else {
            request.setAttribute("message","Cập nhật không thành công");
            request.setAttribute("error",validate);
            request.setAttribute("customer",customer);
        }
        List<CustomerType> typeList = customerTypeService.selectAll();
        request.setAttribute("typeList",typeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
