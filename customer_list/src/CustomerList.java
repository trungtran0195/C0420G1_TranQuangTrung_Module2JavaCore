import Models.DanhSachKhachHang;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DisplayCustomerServlet", urlPatterns = "/index")
public class CustomerList extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<DanhSachKhachHang> listOfCustomer = new ArrayList<>();
        listOfCustomer.add(new DanhSachKhachHang("Mai Van Hoan","1983-08-20","Ha Noi"));
        listOfCustomer.add(new DanhSachKhachHang("Nguyễn Văn Nam","1983-08-21","Bắc Giang"));
        listOfCustomer.add(new DanhSachKhachHang("Nguyễn Thái Hòa","1983-08-22","Nam Định"));
        listOfCustomer.add(new DanhSachKhachHang("Trần Đăng Khoa","1983-08-17","Hà Tây"));
        listOfCustomer.add(new DanhSachKhachHang("Nguyễn Đình Thi","1983-08-19","Hà Nội"));
        request.setAttribute("customers", listOfCustomer);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
