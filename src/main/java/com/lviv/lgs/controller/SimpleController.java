package com.lviv.lgs.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class SimpleController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("request ct: " + req.getContentType());

        System.out.println("resp ct: " + resp.getContentType());

        resp.setContentType("text/html");
        System.out.println("resp ct after set: " + resp.getContentType());

        resp.getWriter().write("<h2>Hello from Servlet</h2>");
    }
}
