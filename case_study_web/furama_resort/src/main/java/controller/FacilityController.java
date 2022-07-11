package controller;

import model.*;
import service.FacilityService;
import service.FacilityTypeService;
import service.RentTypeService;
import service.impl.FacilityServiceImpl;
import service.impl.FacilityTypeServiceImpl;
import service.impl.RentTypeServiceImpl;

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

@WebServlet(name = "FacilityController", urlPatterns = "/facility")
public class FacilityController extends HttpServlet {
    private final FacilityService facilityService = new FacilityServiceImpl();
    private final RentTypeService rentTypeService = new RentTypeServiceImpl();
    private final FacilityTypeService facilityTypeService = new FacilityTypeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                try {
                    insertFacility(request, response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateFacility(request, response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteFacility(request, response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                break;
            default:
                facilityList(request, response);
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
                facilityList(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentType> rentTypeList = rentTypeService.selectAllRentType();
        request.setAttribute("rentTypeList", rentTypeList);

        List<FacilityType> facilityTypeList = facilityTypeService.selectAllFacilityType();
        request.setAttribute("facilityTypeList", facilityTypeList);

        int id = Integer.parseInt(request.getParameter("id"));
        Facility facility = facilityService.selectFacility(id);
        request.setAttribute("facility", facility);
        RequestDispatcher dispatcher;
        if (facility instanceof Villa) {
            Villa villa = (Villa) facilityService.selectFacility(id);
            dispatcher = request.getRequestDispatcher("view/facility/edit.jsp");
            request.setAttribute("villa", villa);
            dispatcher.forward(request, response);
        } else if (facility instanceof House){
            House house = (House) facilityService.selectFacility(id);
            dispatcher = request.getRequestDispatcher("view/facility/edit.jsp");
            request.setAttribute("house", house);
            dispatcher.forward(request, response);
        } else {
            Room room = (Room) facilityService.selectFacility(id);
            dispatcher = request.getRequestDispatcher("view/facility/edit.jsp");
            request.setAttribute("room", room);
            dispatcher.forward(request, response);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentType> rentTypeList = rentTypeService.selectAllRentType();
        request.setAttribute("rentTypeList", rentTypeList);

        List<FacilityType> facilityTypeList = facilityTypeService.selectAllFacilityType();
        request.setAttribute("facilityTypeList", facilityTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/facility/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertFacility(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Facility> facilityList = facilityService.selectAll();
        List<RentType> rentTypeList = rentTypeService.selectAllRentType();
        request.setAttribute("rentTypeList", rentTypeList);

        List<FacilityType> facilityTypeList = facilityTypeService.selectAllFacilityType();
        request.setAttribute("facilityTypeList", facilityTypeList);

        int max = 0;
        if (facilityList.size() == 0) {
            max = 1;
        } else {
            for (Facility item : facilityList) {
                if (max < item.getId()) {
                    max = item.getId();
                }
            }
        }

        int id = max + 1;
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int facilityTypeId = Integer.parseInt(request.getParameter("facilityTypeId"));

        String standardRoom;
        String otherDescription;
        double poolArea;
        int numberFloor;

        String facilityFree;

        if (facilityTypeId == 1) {
            standardRoom = request.getParameter("standardRoom");
            otherDescription = request.getParameter("otherDescription");
            poolArea = Double.parseDouble(request.getParameter("poolArea"));
            numberFloor = Integer.parseInt(request.getParameter("numberFloor"));

            Villa villa = new Villa(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, otherDescription, poolArea, numberFloor);

            Map<String, String> error = facilityService.insertVilla(villa);

            if (error.isEmpty()) {
                request.setAttribute("message", "Thêm mới thành công");
            } else {
                request.setAttribute("message", "Thêm mới không thành công");
                request.setAttribute("error", error);
            }

            request.getRequestDispatcher("view/facility/create.jsp").forward(request, response);
        } else if (facilityTypeId == 2) {
            standardRoom = request.getParameter("standardRoom");
            otherDescription = request.getParameter("otherDescription");
            numberFloor = Integer.parseInt(request.getParameter("numberFloor"));

            House house = new House(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, otherDescription, numberFloor);

            Map<String, String> error = facilityService.insertHouse(house);

            if (error.isEmpty()) {
                request.setAttribute("message", "Thêm mới thành công");
            } else {
                request.setAttribute("message", "Thêm mới không thành công");
                request.setAttribute("error", error);
            }

            request.getRequestDispatcher("view/facility/create.jsp").forward(request, response);
        } else {
            facilityFree = request.getParameter("facilityFree");

            Room room = new Room(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, facilityFree);

            Map<String, String> error = facilityService.insertRoom(room);

            if (error.isEmpty()) {
                request.setAttribute("message", "Thêm mới thành công");
            } else {
                request.setAttribute("message", "Thêm mới không thành công");
                request.setAttribute("error", error);
            }

            request.getRequestDispatcher("view/facility/create.jsp").forward(request, response);
        }
    }

    private void updateFacility(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<RentType> rentTypeList = rentTypeService.selectAllRentType();
        List<FacilityType> facilityTypeList = facilityTypeService.selectAllFacilityType();
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("facilityTypeList", facilityTypeList);

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int facilityTypeId = Integer.parseInt(request.getParameter("facilityTypeId"));

        String standardRoom;
        String otherDescription;
        double poolArea;
        int numberFloor;

        String facilityFree;

        RequestDispatcher dispatcher;

        if (facilityTypeId == 1) {
            standardRoom = request.getParameter("standardRoom");
            otherDescription = request.getParameter("otherDescription");
            poolArea = Double.parseDouble(request.getParameter("poolArea"));
            numberFloor = Integer.parseInt(request.getParameter("numberFloor"));

            Villa villa = new Villa(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, otherDescription, poolArea, numberFloor);

            Map<String, String> error = facilityService.updateVilla(villa);

            if (error.isEmpty()) {
                request.setAttribute("message", "Cập nhật thành công");
            } else {
                request.setAttribute("message", "Cập nhật không thành công");
                request.setAttribute("error", error);
            }

            request.setAttribute("villa", villa);
            dispatcher = request.getRequestDispatcher("view/facility/edit.jsp");
            dispatcher.forward(request, response);
        } else if (facilityTypeId == 2) {
            standardRoom = request.getParameter("standardRoom");
            otherDescription = request.getParameter("otherDescription");
            numberFloor = Integer.parseInt(request.getParameter("numberFloor"));

            House house = new House(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, otherDescription, numberFloor);

            Map<String, String> error = facilityService.updateHouse(house);

            if (error.isEmpty()) {
                request.setAttribute("message", "Cập nhật thành công");
            } else {
                request.setAttribute("message", "Cập nhật không thành công");
                request.setAttribute("error", error);
            }

            request.setAttribute("house", house);
            dispatcher = request.getRequestDispatcher("view/facility/edit.jsp");
            dispatcher.forward(request, response);
        } else {
            facilityFree = request.getParameter("facilityFree");

            Room room = new Room(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, facilityFree);

            Map<String, String> error = facilityService.updateRoom(room);

            if (error.isEmpty()) {
                request.setAttribute("message", "Cập nhật thành công");
            } else {
                request.setAttribute("message", "Cập nhật không thành công");
                request.setAttribute("error", error);
            }

            request.setAttribute("room", room);
            dispatcher = request.getRequestDispatcher("view/facility/edit.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void deleteFacility(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        facilityService.deleteFacility(id);

        //request.setAttribute("mess", "Đã xóa thành công");

        List<Facility> facilityList = facilityService.selectAllFacility();
        request.setAttribute("facilityList", facilityList);

        List<RentType> rentTypeList = rentTypeService.selectAllRentType();
        request.setAttribute("rentTypeList", rentTypeList);

        List<FacilityType> facilityTypeList = facilityTypeService.selectAllFacilityType();
        request.setAttribute("facilityTypeList", facilityTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/facility/list.jsp");
        dispatcher.forward(request, response);
    }

    private void facilityList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentType> rentTypeList = rentTypeService.selectAllRentType();
        request.setAttribute("rentTypeList", rentTypeList);

        List<FacilityType> facilityTypeList = facilityTypeService.selectAllFacilityType();
        request.setAttribute("facilityTypeList", facilityTypeList);

        List<Facility> facilityList = facilityService.selectAllFacility();
        request.setAttribute("facilityList", facilityList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/facility/list.jsp");
        dispatcher.forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keySearch = request.getParameter("keySearch");

        List<RentType> rentTypeList = rentTypeService.selectAllRentType();
        request.setAttribute("rentTypeList", rentTypeList);

        List<FacilityType> facilityTypeList = facilityTypeService.selectAllFacilityType();
        request.setAttribute("facilityTypeList", facilityTypeList);

        List<Facility> facilityList = facilityService.search(keySearch);
        request.setAttribute("facilityList", facilityList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/facility/list.jsp");
        dispatcher.forward(request, response);
    }
}
