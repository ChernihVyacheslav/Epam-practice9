package ua.nure.chernykh.Practice9;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class ContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  {

    }

    public void contextInitialized(ServletContextEvent sce)  {
        String[] sports = sce.getServletContext().getInitParameter("list").split(" ");
        StringBuilder sb = new StringBuilder("<html>\n" +
                "<body>\n" +
                "<form action=\"/practice9/sportVote\">\n" +
                "<p>Please enter your name:</p>\n" +
                "    <input name=\"name\" required><br>\n" +
                "    <p>Please select your favorite sport:</p>\n");
        for(String sport : sports) {
            sb.append("<input type=\"radio\" name=\"sport\" value=\"" + sport.toLowerCase()
                    + "\" required> " + sport +"<br>\n");
        }
        sb.append("<input type=\"submit\" value=\"Submit\">");
        sb.append("</form>\n" +
                "</body>\n" +
                "</html>");
        try {
            File file = new File(sce.getServletContext().getRealPath("/sportVote.html"));
            if(file.exists()) {
                file.delete();
            }
            file.createNewFile();
            PrintWriter writer = new PrintWriter(file);
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
