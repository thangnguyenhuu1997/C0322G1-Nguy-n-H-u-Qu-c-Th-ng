package controller;

import model.*;
import service.*;
import service.impl.*;

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

@WebServlet(name = "EmployeeController", urlPatterns = "/employee")
public class EmployeeController extends HttpServlet {
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    private final PositionService positionService = new PositionServiceImpl();
    private final EducationDegreeService educationDegreeService = new EducationDegreeServiceImpl();
    private final DivisionService divisionService = new DivisionServiceImpl();
    private final UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                try {
                    insertEmployee(request, response);
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateEmployee(request, response);
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteEmployee(request, response);
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                break;
            default:
                employeeList(request, response);
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
            case "search":
                search(request, response);
                break;
            default:
                employeeList(request, response);
                break;
        }
    }

    private void employeeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Position> positionList = positionService.selectAllPosition();
        request.setAttribute("positionList", positionList);

        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
        request.setAttribute("educationDegreeList", educationDegreeList);

        List<Division> divisionList = divisionService.selectAllDivision();
        request.setAttribute("divisionList", divisionList);

        List<User> userList = userService.selectAllUser();
        request.setAttribute("userList", userList);

        List<Employee> employeeList = employeeService.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Position> positionList = positionService.selectAllPosition();
        request.setAttribute("positionList", positionList);

        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
        request.setAttribute("educationDegreeList", educationDegreeList);

        List<Division> divisionList = divisionService.selectAllDivision();
        request.setAttribute("divisionList", divisionList);

        List<User> userList = userService.selectAllUser();
        request.setAttribute("userList", userList);

        int id = Integer.parseInt(request.getParameter("id"));

        Employee employee = employeeService.selectEmployee(id);
        request.setAttribute("employee", employee);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Position> positionList = positionService.selectAllPosition();
        request.setAttribute("positionList", positionList);

        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
        request.setAttribute("educationDegreeList", educationDegreeList);

        List<Division> divisionList = divisionService.selectAllDivision();
        request.setAttribute("divisionList", divisionList);

        List<User> userList = userService.selectAllUser();
        request.setAttribute("userList", userList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Employee> employeeListAll = employeeService.selectAll();

        List<Position> positionList = positionService.selectAllPosition();
        request.setAttribute("positionList", positionList);

        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
        request.setAttribute("educationDegreeList", educationDegreeList);

        List<Division> divisionList = divisionService.selectAllDivision();
        request.setAttribute("divisionList", divisionList);

        List<User> userList = userService.selectAllUser();
        request.setAttribute("userList", userList);

        int max = 0;
        if (employeeListAll.size() == 0) {
            max = 1;
        } else {
            for (Employee item : employeeListAll) {
                if (max < item.getId()) {
                    max = item.getId();
                }
            }
        }

        int id = max + 1;
        String name = request.getParameter("name");

        String birthDay = request.getParameter("birthDay");
        String idCard = request.getParameter("idCard");

        double salary = Double.parseDouble(request.getParameter("salary"));
        if (String.valueOf(salary).equals("") ) {
            salary = 0;
        }

        String phone = request.getParameter("phone");

        String email = request.getParameter("email");
        String address = request.getParameter("address");

        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));

        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String username = request.getParameter("username");

        Employee employee = new Employee(id, name, birthDay, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, username);

        Map<String, String> error = employeeService.insertEmployee(employee);
        if (error.isEmpty()) {
            request.setAttribute("message", "Thêm mới thành công");
        } else {
            request.setAttribute("message", "Thêm mới thất bại");
            request.setAttribute("error", error);
        }

        request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Position> positionList = positionService.selectAllPosition();
        request.setAttribute("positionList", positionList);

        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
        request.setAttribute("educationDegreeList", educationDegreeList);

        List<Division> divisionList = divisionService.selectAllDivision();
        request.setAttribute("divisionList", divisionList);

        List<User> userList = userService.selectAllUser();
        request.setAttribute("userList", userList);

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        String birthDay = request.getParameter("birthDay");
        String idCard = request.getParameter("idCard");

        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");

        String email = request.getParameter("email");
        String address = request.getParameter("address");

        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));

        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String username = request.getParameter("username");

        Employee employee = new Employee(id, name, birthDay, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, username);
        Map<String, String> error = employeeService.updateEmployee(employee);

        request.setAttribute("employee", employee);

        if (error.isEmpty()) {
            request.setAttribute("message", "Cập nhật thành công");
        } else {
            request.setAttribute("message", "Cập nhật thất bại");
            request.setAttribute("error", error);
        }

        request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        employeeService.deleteEmployee(id);

        //request.setAttribute("mess", "Đã xóa thành công");

        List<Position> positionList = positionService.selectAllPosition();
        request.setAttribute("positionList", positionList);

        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
        request.setAttribute("educationDegreeList", educationDegreeList);

        List<Division> divisionList = divisionService.selectAllDivision();
        request.setAttribute("divisionList", divisionList);

        List<User> userList = userService.selectAllUser();
        request.setAttribute("userList", userList);

        List<Employee> employeeList = employeeService.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keySearch = request.getParameter("keySearch");

        List<Position> positionList = positionService.selectAllPosition();
        request.setAttribute("positionList", positionList);

        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
        request.setAttribute("educationDegreeList", educationDegreeList);

        List<Division> divisionList = divisionService.selectAllDivision();
        request.setAttribute("divisionList", divisionList);

        List<User> userList = userService.selectAllUser();
        request.setAttribute("userList", userList);

        List<Employee> employeeList = employeeService.search(keySearch);
        request.setAttribute("employeeList", employeeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        dispatcher.forward(request, response);
    }
}
