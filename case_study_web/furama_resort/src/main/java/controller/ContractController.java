package controller;

import dto.ContractFacility;
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

@WebServlet(name = "ContractController", urlPatterns = "/contract")
public class ContractController extends HttpServlet {
    private final ContractService contractService = new ContractServiceImpl();
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    private final CustomerService customerService = new CustomerServiceImpl();
    private final FacilityService facilityService = new FacilityServiceImpl();
    private final ContractDetailService contractDetailService = new ContractDetailServiceImpl();
    private final AttachFacilityService attachFacilityService = new AttachFacilityServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                try {
                    insertContract(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "createContractDetail":
                try {
                    insertContractDetail(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                contractList(request, response);
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
            default:
                contractList(request, response);
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);

        List<Customer> customerList = customerService.selectAllCustomer();
        request.setAttribute("customerList", customerList);

        List<Facility> facilityList = facilityService.selectAllFacility();
        request.setAttribute("facilityList", facilityList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void contractList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contractList = contractService.selectAllContract();
        request.setAttribute("contractList", contractList);

        List<AttachFacility> attachFacilityListContract = attachFacilityService.selectAllAttachFacilityContract();
        request.setAttribute("attachFacilityListContract", attachFacilityListContract);

        List<Employee> employeeList = employeeService.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);

        List<Customer> customerList = customerService.selectAllCustomer();
        request.setAttribute("customerList", customerList);

        List<Facility> facilityList = facilityService.selectAllFacility();
        request.setAttribute("facilityList", facilityList);

        List<ContractDetail> contractDetailList = contractDetailService.selectAllContractDetail();
        request.setAttribute("contractDetailList", contractDetailList);

        List<AttachFacility> attachFacilityList = attachFacilityService.selectAllAttachFacility();
        request.setAttribute("attachFacilityList", attachFacilityList);

        List<ContractFacility> contractFacilityList = contractDetailService.selectAllAttachFacilityContract();
        request.setAttribute("contractFacilityList", contractFacilityList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void insertContract(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Contract> contractList = contractService.selectAll();

        List<Employee> employeeList = employeeService.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);

        List<Customer> customerList = customerService.selectAllCustomer();
        request.setAttribute("customerList", customerList);

        List<Facility> facilityList = facilityService.selectAllFacility();
        request.setAttribute("facilityList", facilityList);

        int max = 0;
        if (contractList.size() == 0) {
            max = 1;
        } else {
            for (Contract item : contractList) {
                if (max < item.getId()) {
                    max = item.getId();
                }
            }
        }

        int id = max + 1;

        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        int employeeId = Integer.parseInt(request.getParameter("positionId"));
        int customerId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int facilityId = Integer.parseInt(request.getParameter("divisionId"));

        Contract contract = new Contract(id, startDate, endDate, deposit, employeeId, customerId, facilityId);
        contractService.insertContract(contract);

        contractList(request, response);
    }

    private void insertContractDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<ContractDetail> contractDetailList = contractDetailService.selectAllContractDetail();

        int max = 0;
        if (contractDetailList.size() == 0) {
            max = 1;
        } else {
            for (ContractDetail item : contractDetailList) {
                if (max < item.getId()) {
                    max = item.getId();
                }
            }
        }

        int id = max + 1;

        int contractId = Integer.parseInt(request.getParameter("contractId"));
        int attachFacilityId = Integer.parseInt(request.getParameter("attachFacilityId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ContractDetail contractDetail = new ContractDetail(id, contractId, attachFacilityId, quantity);
        contractDetailService.insertContractDetail(contractDetail);

        response.sendRedirect("/contract");
    }
}
