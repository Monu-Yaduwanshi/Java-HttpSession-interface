
//
//package com.service;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@WebServlet("/ServletProfile")
//public class ServletProfile extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession(false);
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        if (session != null && session.getAttribute("username") != null) {
//            String username = (String) session.getAttribute("username");
//            out.println("Welcome, " + username);
//            out.print("<a href=\"UI.html\">Home</a>");
//            out.print("<a href=\"ServletLogout\">Logout</a>");  // Added Logout link
//        } else {
//            out.println("Please log in first.");
//        }
//        
//        out.close();
//    }
//}
//



























package com.service20;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            out.println("<h1>This is Profile Servlet</h1><br>");
            out.println("<h3>Welcome</h3> " + username);
//            out.print("<a href=\"UI.html\">Home</a>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Link.html");
            dispatcher.include(request, response);
            
           
            
            
        } else {
            out.println("<h1>This is Profile Servlet</h1><br>");

            out.println("<h3>Please log in first.</h3>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Link.html");
            dispatcher.include(request, response);
        }
        
        out.close();
    }
}
