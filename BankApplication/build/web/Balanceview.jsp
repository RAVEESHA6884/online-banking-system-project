<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Balance</title>
    <style>
      body {
        background-image: url("home.jpg");
        background-size: cover;
        background-repeat: no-repeat;
      }
      div{
          color: red;
          font-size: 40px;
      }
    </style>
  </head>
  <body>
    <% 
        out.println("<div>");
        session=request.getSession(); out.println(session.getAttribute("bal"));
         out.println("</div>");
    %>
  </body>
</html>
