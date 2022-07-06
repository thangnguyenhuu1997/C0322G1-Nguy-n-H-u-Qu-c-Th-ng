package controller;

import model.employee.*;
import service.employee.*;
import service.employee.impl.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeService();
    private IDivisionService divisionService = new DivisionService();
    private IEducationDegreeService educationDegreeService = new EducationDegreeService();
    private IPositionService positionService = new PositionService();
    private IUserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                save(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                showEmployeeList(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "update":
                showFormUpdate(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                showEmployeeList(request, response);
        }
    }

    private void showEmployeeList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        List<Division> divisionList = divisionService.selectAllDivision();
        request.setAttribute("divisionList", divisionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
        request.setAttribute("educationDegreeList", educationDegreeList);
        List<Position> positionList = positionService.selectAllPosition();
        request.setAttribute("positionList", positionList);
        List<User> userList = userService.selectAllUser();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/employee_list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Division> divisionList = divisionService.selectAllDivision();
        request.setAttribute("divisionList", divisionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
        request.setAttribute("educationDegreeList", educationDegreeList);
        List<Position> positionList = positionService.selectAllPosition();
        request.setAttribute("positionList", positionList);
        List<User> userList = userService.selectAllUser();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        String employee_name = request.getParameter("employee_name");
        String employee_birthday = request.getParameter("employee_birthday");
        String employee_id_card = request.getParameter("employee_id_card");
        double employee_salary = Double.parseDouble(request.getParameter("employee_salary"));
        String employee_phone = request.getParameter("employee_phone");
        String employee_email = request.getParameter("employee_email");
        String employee_address = request.getParameter("employee_address");
        int position_id = Integer.parseInt(request.getParameter("position_id"));
        int education_degree_id = Integer.parseInt(request.getParameter("education_degree_id"));
        int division_id = Integer.parseInt(request.getParameter("division_id"));
        String username = request.getParameter("username");
        Employee employee = new Employee(employee_name,
                employee_birthday,
                employee_id_card,
                employee_salary,
                employee_phone,
                employee_email,
                employee_address,
                position_id,
                education_degree_id,
                division_id,
                username);
        try {
            employeeService.insertEmployee(employee);
            response.sendRedirect("/employee");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }
}
