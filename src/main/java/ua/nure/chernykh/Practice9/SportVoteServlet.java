package ua.nure.chernykh.Practice9;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/practice9/sportVote")
public class SportVoteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // (1)
        String sport = request.getParameter("sport");
        ServletContext sc = getServletContext();

        String name = request.getParameter("name");
        Map<String, String> nameVotes = (Map) sc.getAttribute("nameVotes");

        if(nameVotes == null) {
            nameVotes = new HashMap<>();
            sc.setAttribute("nameVotes", nameVotes);
        }

        if(!nameVotes.containsKey(name)) {
            nameVotes.put(name, sport);
            sc.setAttribute("nameVotes", nameVotes);
        } else {
            response.getWriter().println("Sorry, this name has been used in this vote already.");
            return;
        }

        Map<String, Integer> map = (Map) sc.getAttribute("voteMap");
        if(map == null) {
            map = new HashMap<>();
            sc.setAttribute("voteMap", map);
        }

        Integer n = map.get(sport);
        if(n == null) {
            n = 0;
        }
        map.put(sport, ++n);
        sc.setAttribute("voteMap", map);
        request.getRequestDispatcher("/sportVote.jsp").forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
