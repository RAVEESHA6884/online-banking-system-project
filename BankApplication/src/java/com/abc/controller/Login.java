package com.abc.controller;

import com.abc.modelEx.ModelEx;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

    private HttpSession session = null;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        session = request.getSession();
        String custid = request.getParameter("custid");
        String pwd = request.getParameter("pwd");
        System.out.println(custid);

        try {
            ModelEx m = new ModelEx();
            m.setCustid(custid);
            m.setPwd(pwd);
            boolean b = m.login();
            if (b == true) {
                session.setAttribute("accno", m.getAccno());
                response.sendRedirect("home.html");
            } else {
                response.sendRedirect("Error.html");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
