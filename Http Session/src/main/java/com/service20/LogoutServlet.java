package com.service20;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServletLogout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        response.setContentType("text/html");
        response.getWriter().println("<h1>This is Logout Servlet</h1><br>");

        response.getWriter().println("<h3>Logged out successfully.</h3>");// <a href=\"UI.html\">Home Page</a>");//
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Link.html");
        dispatcher.include(request, response);
    }
}
