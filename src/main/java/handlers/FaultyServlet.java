package handlers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("serial")
public class FaultyServlet extends HttpServlet
{
    private static double errorRate = 0.5;

    @Override
    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response ) throws ServletException,
            IOException
    {
        Double rand = Math.random();
        try {
            errorRate = Double.parseDouble(request.getParameter("errorRate"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(rand > errorRate) {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<h1>Everything went ok</h1>");

        } else {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("<h1>Everything went bad</h1>");

        }
    }
}

