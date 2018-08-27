package contro;

import dao.Productdao;
import dao.util;
import entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Myservlet")
public class MyServlet extends HttpServlet {
    PrintWriter out=null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        out = response.getWriter();
        Productdao dao = new Productdao();
        String action = request.getParameter("action");
        if (action.equals("SelectAll")) {
            out.print(util.toJson(dao.getAllProducts()));
        } else if (action.equals("SelectById")) {
            String Id = request.getParameter("Id");
            out.print(util.toJson(dao.findById(Id)));
        } else if (action.equals("add")) {
            String Id = request.getParameter("Id");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            float price = Float.parseFloat(request.getParameter("price"));
            int code = 0;
            if (dao.add(new Product(Id, name, description, price))) {
                code = 1;
            }
            out.print("\"code\":\"" + code + "\"");
        } else if (action.equals("update")) {
            String Id = request.getParameter("Id");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            float price = Float.parseFloat(request.getParameter("price"));
            int code = 0;
            if (dao.update(new Product(Id, name, description, price))) {
                code = 1;
            }
            out.print("\"code\":\"" + code + "\"");
        } else if (action.equals("del")) {
            String Id = request.getParameter("Id");
            int code = 0;
            if (dao.del(Id)) {
                code = 1;
            }
            out.print("\"code\":\"" + code + "\"");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
