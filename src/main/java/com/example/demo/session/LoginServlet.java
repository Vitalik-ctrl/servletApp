package com.example.demo.session;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ServletContext context;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        UserRepository userData = UserRepository.userData(request.getParameter("user"), request.getParameter("pwd"));
        this.context.log(request.getRemoteAddr() + "::userData::{ name=" + userData.name + ", pwd=" + userData.password);
        SessionService.setupSession(userData, request, response);
    }
}
