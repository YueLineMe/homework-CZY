package contro;

import dao.Productdao;
import dao.util;
import entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

@WebServlet(name="Myservlet")
public class MyServlet extends HttpServlet {
    PrintWriter out=null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        Productdao dao = new Productdao();
        if (action == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else if (action.equals("selectId")) {

            int Id = Integer.parseInt(request.getParameter("Id"));
            request.setAttribute("product_info", dao.findById(Id));
            request.getRequestDispatcher("info.jsp").forward(request, response);

        } else if (action.equals("prepare_add")) {
            request.getRequestDispatcher("add.jsp").forward(request, response);
        } else if (action.equals("add")) {
            int Id = Integer.parseInt(request.getParameter("Id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String press = request.getParameter("press");
            String description = request.getParameter("description");
            dao.add(new Product(Id, name, description,price));
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (action.equals("del")) {
            int Id = Integer.parseInt(request.getParameter("Id"));
            dao.del(Id);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (action.equals("update")) {
            response.setContentType("application/json;charset=utf-8");
            int Id = Integer.parseInt(request.getParameter("Id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            boolean bool=dao.update(new Product(Id, name,description, price));
            String msg="更新成功";
            if(!bool)
                msg="更新失败";
            response.getWriter().print("{\"msg\":\""+msg+"\",\"Product\":\""+util.toJson(new Product(Id, name,description, price))+"\"}");
        } else if (action.equals("selectId")) {
            int Id = Integer.parseInt(request.getParameter("Id"));
            Collection<Product> products = null;
            if (Id == 0){
                products = dao.getAllProducts();
                request.setAttribute("products", products);
            }
            else{
                Product product = dao.findById(Id);
                request.setAttribute("products", product);
            }

            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else if(action.equals("chageing")){
            String temp = request.getParameter("Id");
            int Id = 0;
            if (temp != null) {
                Id = Integer.parseInt(temp);
            }
            Product products = dao.findById(Id);
            request.setAttribute("products", products);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
