<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <style>
      body {
        background-image: url("home.jpg");
        background-repeat: no-repeat;
        background-size: cover;
      }
      div{
          color: red;
          font-size: 40px;
      }
      
    </style>
    <title>Loan Success</title>
  </head>
  <body>
    
     <% 
         out.println("<div>");
            session = request.getSession();
            out.println("Dear,"+session.getAttribute("name")+"Thank you for your intrest in ABC Bank on loan");
                out.println("<br>");
            out.println("Our executive will contact you soon on your email address mentioned below");
                out.println("<br>");
            out.println(session.getAttribute("email"));
            out.println("</div>");
        %>
  </body>
</html>
