<%@page import="com.abc.modelEx.ModelEx"%> <%@page contentType="text/html"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Change Password JSP Page</title>
    <style>
      body {
        background-image: url("home.jpg");
        background-size: cover;
        background-repeat: no-repeat;
      }
      div{
          color: green;
          font-size: 40px;
      }
      
    </style>
  </head>
  <body>
    <% String saccno = String.valueOf(session.getAttribute("accno"));
    int accno= Integer.parseInt(saccno); 
    String npwd = request.getParameter("npwd");
    ModelEx m = new ModelEx(); 
    m.setAccno(accno); 
    m.setPwd(npwd);
    m.changePassword();
    
    out.println("<div>");
    out.println("<h1>Password changed successfully!!!</h1>");
    out.println("</div>");
   
    %>
  </body>
</html>
