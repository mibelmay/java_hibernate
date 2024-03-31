package com.example.servlet;

import com.example.model.UserProfile;
import com.example.service.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class LogInServlet extends HttpServlet {

    DBService dbService = new DBService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("login");

        if (login == null) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        resp.sendRedirect("listing?path=D:/filemanager/" + login);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserProfile user = dbService.getUserByLogin(login);
        if (user == null) {
            resp.getWriter().write("No such user");
            return;
        }

        if(!password.equals(user.getPassword())) {
            resp.getWriter().write("Invalid password");
            return;
        }

        req.getSession().setAttribute("login", login);
        resp.sendRedirect("listing?path=D:/filemanager/" + login);
    }
}
