package controller;

import model.customers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    static List<customers> customerList = new ArrayList<>();
    static {
        customerList.add(new customers("Mai Văn Hoàn","1983-08-20","Hà Nội","https://imgresizer.eurosport.com/unsafe/1200x0/filters:format(webp):focal(1303x368:1305x366)/origin-imgresizer.eurosport.com/2021/12/05/3266643-66850128-2560-1440.jpg"));
        customerList.add(new customers("Nguyễn Văn Nam","1983-08-21","Bắc Giang","https://i.cbc.ca/1.6026315.1620958088!/fileImage/httpImage/image.jpg_gen/derivatives/16x9_780/1317353454.jpg"));
        customerList.add(new customers("Nguyễn Thái Hòa","1983-08-22","Nam Định","https://assets.goal.com/v3/assets/bltcc7a7ffd2fbf71f5/blt2391fa84028c6214/60db1e5696e07e0f6e52061b/3bf91b1a0a0eec865586b07fd005b03585ff6f86.jpg"));
        customerList.add(new customers("Trần Đăng Khoa","1983-08-17","Hà Tây","https://static.bongda24h.vn/medias/original/2020/9/1/cau-thu-timo-werner.jpg"));
        customerList.add(new customers("Nguyễn Đình Thi","1983-08-19","Hà Nội","https://photo-cms-sggp.zadn.vn/Uploaded/2022/evofzyresfj/2020_12_08/kepa-chelsea-va-cau-chuyen-ve-nhung-chu-chim-kim-oanh_xofa.jpg"));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
