package com.abc.controller;

import com.abc.modelEx.ModelEx;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Checkbalance extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int accno = (int) session.getAttribute("accno");
        try {
            ModelEx m = new ModelEx();
            m.setAccno(accno);
            boolean b = m.checkBalance();
            if (b == true) {
                session.setAttribute("bal", m.getBal());
                response.sendRedirect("Balanceview.jsp");
            } else {
                response.sendRedirect("BalanceFailure.html");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
