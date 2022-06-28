import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double num1 = Double.parseDouble(request.getParameter("first-operand"));
        Double num2 = Double.parseDouble(request.getParameter("second-operand"));
        String operator = request.getParameter("operator");
        String result = "";
        switch (operator){
            case "+":
                result = num1 + "+" + num2 + "=" + (num1+num2);
                break;
            case "-":
                result = num1 + "-" + num2 + "=" + (num1 - num2);
                break;
            case "*"  :
                result = num1 + "*" + num2 + "=" + (num1 * num2);
                break;
            case "/":
                result = num1 + "/" + num2 + "=" + (num1 / num2);
                break;
        }
        request.setAttribute("results",result);
        request.getRequestDispatcher("results.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
