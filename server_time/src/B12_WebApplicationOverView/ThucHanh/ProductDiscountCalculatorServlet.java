package B12_WebApplicationOverView.ThucHanh;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscountCalculatorServlet", urlPatterns = "/calculateDiscount")
public class ProductDiscountCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("ProductDescription");
        float rate = Float.parseFloat(request.getParameter("DiscountPercent"));
        float price  = Float.parseFloat(request.getParameter("ListPrice"));

        double amount = rate*price*0.01;
        double discountPrice = price - amount;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product: " + description+ "</h1>");
        writer.println("<h1>Discount Amount: " + amount+ "</h1>");
        writer.println("<h1>Discount Price: " + discountPrice+ "</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
