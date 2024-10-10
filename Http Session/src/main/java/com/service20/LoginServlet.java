
package com.service20;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        String hardcodedUsername = "Monu";
        String hardcodedPassword = "pass";

        if (username.equals(hardcodedUsername) && password.equals(hardcodedPassword)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            
            RequestDispatcher dispatcher = request.getRequestDispatcher("ServletProfile");
            dispatcher.forward(request, response);
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<h1>This is Login Servlet</h1><br>");

            response.getWriter().println("<h3>Invalid username or password</h3>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Link.html");
            dispatcher.include(request, response);

           

        }
    }
}
//package com.service;
//
//import java.io.IOException;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//public class ServletLogin extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("Username");
//        String password = request.getParameter("Password");
//
//        String hardcodedUsername = "Monu";
//        String hardcodedPassword = "pass";
//
//        if (username.equals(hardcodedUsername) && password.equals(hardcodedPassword)) {
//            HttpSession session = request.getSession();
//            session.setAttribute("username", username);
//            response.sendRedirect("ServletProfile");
//        } else {
//            response.setContentType("text/html");
//            response.getWriter().println("Invalid username or password");
//        }
//    }
//}
