package servlets;

import beans.ColorBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/ControllerServlet"})
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ColorBean myBean = new ColorBean();
        myBean.setForegroundColor(request.getParameter("foreColor"));
        myBean.setBackgroundColor(request.getParameter("backColor"));
        String borders = request.getParameter("borders");
        Boolean b = false;
        if(borders != null) {
            b=borders.equals("on");
        }
        myBean.setBorders(b);
        request.setAttribute("bean", myBean);
        List<String> members = new ArrayList<>();
        members.add("John Lennon");
        members.add("Paul McCartney");
        members.add("Ringo Starr");
        members.add("George Harrison");
        request.setAttribute("members", members);
        Calendar calDate = new GregorianCalendar();
        calDate.set(1965, Calendar.SEPTEMBER, 13);
        Date releaseDate = calDate.getTime();
        request.setAttribute("releaseDate", releaseDate);
        ServletContext ctx = this.getServletContext();
        RequestDispatcher dispatcher = ctx.getRequestDispatcher("/yesterday.jsp");
        dispatcher.forward(request, response);
    }
}
