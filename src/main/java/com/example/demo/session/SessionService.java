package com.example.demo.session;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionService {

    public static int setupSession(UserRepository userData, HttpServletRequest request, HttpServletResponse response) throws IOException {
        int status = 0;

        PrintWriter out = response.getWriter();
        if (userData.name != null && userData.password != null ) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userData.name);
            session.setMaxInactiveInterval(30 * 60);
            Cookie userName = new Cookie("user", userData.name);
            userName.setMaxAge(30 * 60);
            response.addCookie(userName);
            out.println("Welcome " + userData.name + "!");
            status = 1;
        } else {
            out.println("User name or password is wrong!");
        }
        return status;
    }
}
