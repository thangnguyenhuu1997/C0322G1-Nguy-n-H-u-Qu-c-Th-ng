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
import java.util.Map;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeServiceImpl();
    private IPositionService positionService = new PositionServiceImpl();
    private IEducationDegreeService educationDegreeService = new EducationDegreeServiceImpl();
    private IDivisionService divisionService = new DivisionServiceImpl();

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
                break;
            default:
                showEmployeeList(request,response);
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
//                search(request,response);
                break;
            default:
                showEmployeeList(request,response);
        }
    }

    private void showEmployeeList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.selectAllEmployee();
        Map<Integer, String> mapPosition = positionService.selectPosition();
        Map<Integer, String> mapEducationDegree = educationDegreeService.selectEducationDegree();
        Map<Integer, String> mapDivision = divisionService.selectDivision();
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("mapPosition",mapPosition);
        request.setAttribute("mapEducationDegree",mapEducationDegree);
        request.setAttribute("mapDivision",mapDivision);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Position> listPosition = positionService.selectAll();
        List<EducationDegree> listDegree = educationDegreeService.selectAll();
        List<Division> listDivision = divisionService.selectAll();
        request.setAttribute("listPosition",listPosition);
        request.setAttribute("listDegree",listDegree);
        request.setAttribute("listDivision",listDivision);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee existEmployee = employeeService.selectEmployee(employeeId);
        List<Position> listPosition = positionService.selectAll();
        List<EducationDegree> listDegree = educationDegreeService.selectAll();
        List<Division> listDivision = divisionService.selectAll();
        request.setAttribute("employee",existEmployee);
        request.setAttribute("listPosition",listPosition);
        request.setAttribute("listDegree",listDegree);
        request.setAttribute("listDivision",listDivision);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        String employeeName = request.getParameter("employeeName");
        String employeeBirthday = request.getParameter("employeeBirthday");
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int  positionId = Integer.parseInt(request.getParameter("positionId"));
        int  educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int  divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String username = request.getParameter("employeeEmail");
        Employee employee = new Employee(employeeName,
                                        employeeBirthday,
                                        employeeIdCard,
                                        employeeSalary,
                                        employeePhone,
                                        employeeEmail,
                                        employeeAddress,
                                        positionId,
                                        educationDegreeId,
                                        divisionId,username);
        Map<String, String> validate = employeeService.save(employee);
        if (validate.isEmpty()){
            request.setAttribute("message","Thêm mới thành công");
        }else {
            request.setAttribute("message","Thêm mới không thành công");
            request.setAttribute("error",validate);
            request.setAttribute("employee", employee);
        }
        showFormCreate(request,response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String employeeName = request.getParameter("employeeName");
        String employeeBirth = request.getParameter("employeeBirth");
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String username = request.getParameter("username");
        Employee employee = new Employee(employeeId,
                                        employeeName,
                                        employeeBirth,
                                        employeeIdCard,
                                        employeeSalary,
                                        employeePhone,
                                        employeeEmail,
                                        employeeAddress,
                                        positionId,
                                        educationDegreeId,
                                        divisionId,username);
        Map<String, String> validate = employeeService.updateEmployee(employee);
        if (validate.isEmpty()){

            request.setAttribute("message","Cập nhật thành công");
        }else {
            request.setAttribute("message","Cập nhật không thành công");
            request.setAttribute("error",validate);
            request.setAttribute("employee", employee);
        }
        showFormUpdate(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("employeeId"));
        try {
            boolean check = employeeService.deleteEmployee(id);
            String mess = "Xóa không thành công";
            if (check){
                mess = "Xóa thành công";
            }
            request.setAttribute("mess", mess);
            showEmployeeList(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
