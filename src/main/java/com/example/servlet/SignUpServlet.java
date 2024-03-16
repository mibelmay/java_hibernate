package com.example.servlet;

import com.example.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.channels.AcceptPendingException;
import java.util.Dictionary;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        if (login.isEmpty() || password.isEmpty() || email.isEmpty()) {
            resp.getWriter().write("Invalid input");
            return;
        }

        if(AccountService.getUserByLogin(login) != null) {
            resp.getWriter().write("User with login" + login + " already exists");
            return;
        }

        File dir = new File("D:\\filemanager\\" + login);
        if(!dir.mkdir()) {
            resp.getWriter().write("Cannot create directory with name " + login);
            return;
        }
        AccountService.register(login, password, email);

        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("password", password);

        resp.sendRedirect("listing?path=D:/filemanager/" + login);
    }
}
