package controller;

import model.facility.Facility;
import model.facility.RentType;
import model.facility.ServiceType;
import service.facility.IFacilityService;
import service.facility.IRentTypeService;
import service.facility.IServiceTypeService;
import service.facility.impl.FacilityServiceImpl;
import service.facility.impl.RentTypeServiceImpl;
import service.facility.impl.ServiceTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FacilityServlet", urlPatterns = "/facility")
public class FacilityServlet extends HttpServlet {
    private IFacilityService facilityService = new FacilityServiceImpl();
    private IRentTypeService rentTypeService = new RentTypeServiceImpl();
    private IServiceTypeService serviceTypeService = new ServiceTypeServiceImpl();

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
//                update(request,response);
                break;
            case "delete":
//                delete(request,response);
                break;
            case "search":
                break;
            default:
                showFacilityList(request,response);
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
//                showFormUpdate(request,response);
                break;
            case "delete":
                break;
            case "search":
//                search(request,response);
                break;
            default:
                showFacilityList(request,response);
        }
    }

    private void showFacilityList(HttpServletRequest request, HttpServletResponse response) {
        List<Facility> facilityList = facilityService.selectAllFacility();
        Map<Integer, String> mapRentType = rentTypeService.selectRentType();
        Map<Integer, String> mapServiceType = serviceTypeService.selectServiceType();
        request.setAttribute("facilityList",facilityList);
        request.setAttribute("mapRentType",mapRentType);
        request.setAttribute("mapServiceType",mapServiceType);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/facility/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentTypeList = rentTypeService.selectAll();
        List<ServiceType> serviceTypeList = serviceTypeService.selectAll();
        request.setAttribute("rentTypeList",rentTypeList);
        request.setAttribute("serviceTypeList",serviceTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/facility/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void save(HttpServletRequest request, HttpServletResponse response) {
        String serviceName = request.getParameter("serviceName");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloor = Integer.parseInt(request.getParameter("numberOfFloor"));
        Facility facility = new Facility(serviceName,
                serviceArea,
                serviceCost,
                serviceMaxPeople,
                rentTypeId,
                serviceTypeId,
                standardRoom,
                description,
                poolArea,
                numberOfFloor);
        Map<String, String> validate = facilityService.save(facility);
        if (validate.isEmpty()){
            request.setAttribute("message","Thêm mới thành công");
        }else {
            request.setAttribute("message","Thêm mới không thành công");
            request.setAttribute("error",validate);
            request.setAttribute("facility",facility);
        }
        showFormCreate(request,response);
    }
}
