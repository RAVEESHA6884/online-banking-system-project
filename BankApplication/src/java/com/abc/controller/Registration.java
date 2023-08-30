package com.abc.controller;





import com.abc.modelEx.ModelEx;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Registration extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException
    {
       String name = request.getParameter("name");
       String custid = request.getParameter("custid");
       String saccno = request.getParameter("accno");
       int accno = Integer.parseInt(saccno);
       String pwd = request.getParameter("pwd");
       String sbal = request.getParameter("bal");
       int bal = Integer.parseInt(sbal);
       String email = request.getParameter("email");
       
       try
       {
          ModelEx m = new ModelEx();
          m.setName(name);
          m.setCustid(custid);
          m.setAccno(accno);
          m.setPwd(pwd);
          m.setBal(bal);
          m.setEmail(email);
          System.out.println(custid);
          
          boolean b = m.register();
          if(b==true)
          {
              response.sendRedirect("successReg.html");
              
          }
          else
          {
              response.sendRedirect("failure.html");
          }
       }
       catch(Exception e){
       e.printStackTrace();
       }
       
    
    }
}