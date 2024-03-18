package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.example.model.FileInfo;

@WebServlet("/listing")
public class MainServlet extends HttpServlet {
    private static final String ROOT_DIRECTORY = "D:\\filemanager";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getParameter("path");
        if (path == null || path.isEmpty()) {
            resp.sendRedirect("/");
        }
        ArrayList<FileInfo> files = new ArrayList<>();
        File directory = new File(path);
        if (directory.exists() && (directory.isDirectory())) {
            for(File item : directory.listFiles()){
                files.add(new FileInfo(item));
            }
        }
        String parentDirPath = new File(path).getParent();
        if (parentDirPath == null || parentDirPath.equals(ROOT_DIRECTORY)) {
            parentDirPath = path;
        }
        req.setAttribute("parentDirPath", parentDirPath);
        req.setAttribute("path", path);
        req.setAttribute("date", new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()));
        req.setAttribute("files", files);

        getServletContext().getRequestDispatcher("/listing.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("login");
        req.getSession().removeAttribute("password");

        getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
