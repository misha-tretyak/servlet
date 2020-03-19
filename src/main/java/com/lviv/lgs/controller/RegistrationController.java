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

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

    private UserServise userServise;

    public RegistrationController(){this.userServise = UserServiseImpl.getInstance();}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        userServise.save(new User(firstName, lastName, email, password));
        resp.sendRedirect("login");
    }
}
