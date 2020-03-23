package ua.nure.chernykh.Practice9;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/practice9/hello")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // (1)
        String name = request.getParameter("name");

        // (2)
        String result = "Hello, " + name;

        // (3)
//		response.getWriter().println("<html><body>" + result + "</body></html>");
        request.setAttribute("result", result);

        request.getRequestDispatcher("/hello.jsp").forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
