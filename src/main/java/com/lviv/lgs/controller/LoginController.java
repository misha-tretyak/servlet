package com.lviv.lgs.controller;

import com.lviv.lgs.entity.User;
import com.lviv.lgs.servise.UserServise;
import com.lviv.lgs.servise.serviseImpl.UserServiseImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private UserServise userServise;

    public LoginController() {
        this.userServise = UserServiseImpl.getInstance();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        Optional<User> optionalUser = userServise.findByEmail(email);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            if (user.getPassword().equals(password)) {
                req.setAttribute("userEmail", email);
                req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
