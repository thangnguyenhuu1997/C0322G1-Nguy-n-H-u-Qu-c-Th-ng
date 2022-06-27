import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountCalculatorServlet", urlPatterns = "/calculator")
public class DiscountCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        double discount_percent = Double.parseDouble(request.getParameter("discount"));
        double discount_amonunt = price * discount_percent * 0.01;
        double total = price - discount_amonunt;

        request.setAttribute("description",description);
        request.setAttribute("price",price);
        request.setAttribute("discount_percent",discount_percent);
        request.setAttribute("discount_amonunt",discount_amonunt);
        request.setAttribute("total",total);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("results.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
