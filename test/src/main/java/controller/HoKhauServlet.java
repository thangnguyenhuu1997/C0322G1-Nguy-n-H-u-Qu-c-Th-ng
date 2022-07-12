package controller;

import model.HoKhau;
import model.ThanhVien;
import service.IHoKhauService;
import service.IThanhVienService;
import service.impl.HoKhauService;
import service.impl.ThanhVienService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ThiServlet",urlPatterns ="/hokhau")
public class HoKhauServlet extends HttpServlet {
    private IHoKhauService hoKhauService = new HoKhauService();
    private IThanhVienService thanhVienService = new ThanhVienService();

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
            default:
                showHoKhauList(request, response);
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
            default:
                showHoKhauList(request, response);
        }
    }

    private void showHoKhauList(HttpServletRequest request, HttpServletResponse response) {
        List<HoKhau> hoKhauList = hoKhauService.selectAllHoKhau();
        request.setAttribute("hoKhauList", hoKhauList);
        List<ThanhVien> thanhVienList = thanhVienService.selectAllThanhVien();
        request.setAttribute("thanhVienList", thanhVienList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        String ma_ho_khau = request.getParameter("ma_ho_khau");
        String ten_chu_ho = request.getParameter("ten_chu_ho");
        int so_luong_thanh_vien = Integer.parseInt(request.getParameter("so_luong_thanh_vien"));
        String ngay_lap_ho_khau = request.getParameter("ngay_lap_ho_khau");
        String dia_chi = request.getParameter("dia_chi");
        HoKhau hoKhau = new HoKhau(ma_ho_khau,
                ten_chu_ho,
                so_luong_thanh_vien,
                ngay_lap_ho_khau,
                dia_chi);
        hoKhauService.insertHoKhau(hoKhau);
        try {
            response.sendRedirect("/hokhau");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<ThanhVien> thanhVienList = thanhVienService.selectAllThanhVien();
        request.setAttribute("thanhVienList", thanhVienList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
        int stt = Integer.parseInt(request.getParameter("stt"));
        HoKhau hoKhau = hoKhauService.selectHoKhau(stt);
        List<ThanhVien> thanhVienList = thanhVienService.selectAllThanhVien();
        request.setAttribute("thanhVienList", thanhVienList);
        request.setAttribute("hoKhau", hoKhau);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int stt = Integer.parseInt(request.getParameter("stt"));
        String ma_ho_khau = request.getParameter("ma_ho_khau");
        String ten_chu_ho = request.getParameter("ten_chu_ho");
        int so_luong_thanh_vien = Integer.parseInt(request.getParameter("so_luong_thanh_vien"));
        String ngay_lap_ho_khau = request.getParameter("ngay_lap_ho_khau");
        String dia_chi = request.getParameter("dia_chi");
        HoKhau hoKhau = new HoKhau(stt,
                ma_ho_khau,
                ten_chu_ho,
                so_luong_thanh_vien,
                ngay_lap_ho_khau,
                dia_chi);
        try {
            hoKhauService.updateHoKhau(hoKhau);
            response.sendRedirect("/hokhau");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
