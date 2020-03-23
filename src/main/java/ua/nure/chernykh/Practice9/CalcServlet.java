package ua.nure.chernykh.Practice9;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/practice9/calc")
public class CalcServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // (1)
        int x = Integer.parseInt(request.getParameter("x"));
        int y = Integer.parseInt(request.getParameter("y"));

        String op = request.getParameter("op");

        // (2)
        int calc = calc(x, y, op);

        // (3)
        request.setAttribute("calc", calc);

        request.getRequestDispatcher("/calc.jsp").forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private int calc(int x, int y, String operation) {
        switch (operation) {
            case "minus":
                return x - y;
            case "plus":
                return x + y;
            case "multiply":
                return x * y;
            case "divide":
                return x / y;
            default: return 0;
        }
    }
}