package com.abc.modelEx;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelEx {
    private String name;
    private String custid;
    private int accno;
    private String pwd;
    private int bal;
    private String email;
    private Connection con;
    private PreparedStatement pstmt;
    private String cpwd;
    private String npwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public int getAccno() {
        return accno;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getBal() {
        return bal;
    }

    public void setBal(int bal) {
        this.bal = bal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public ModelEx() throws Exception 
    {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapplication", "root", "root");
        System.out.println("Loading the Driver and Establishing the Connection Completed");
    }
    public boolean register() throws SQLException
    {
        String s ="insert into abcbank values(?,?,?,?,?,?)";
        pstmt = con.prepareStatement(s);
        pstmt.setString(1, name);
        pstmt.setString(2, custid);
        pstmt.setInt(3, accno);
        pstmt.setString(4, pwd);
        pstmt.setInt(5, bal);
        pstmt.setString(6, email);
        
        int x = pstmt.executeUpdate();
        if(x>0)
        {
            return true;
        }
        else
        {
          return false;  
        }
        
        
    }
    public boolean login() throws SQLException{
        String s="select * from abcbank where custid=? and password=?";
        pstmt=con.prepareStatement(s);
        pstmt.setString(1,custid);
        pstmt.setString(2,pwd);
        ResultSet res=pstmt.executeQuery();
        boolean st=false;
        while(res.next()){
            accno=res.getInt("ACCNO");
            st=true;
        }
        if(st==true){
            return true;
        }else{
            System.out.println(accno);
            return false;
        }
    }
    public boolean checkBalance() throws SQLException
    {
       String s="select balance from abcbank where accno=?";
       pstmt=con.prepareStatement(s);
       pstmt.setInt(1,accno);
       ResultSet rs=pstmt.executeQuery();
       boolean st=false;
       while(rs.next())
       {
           bal=rs.getInt("BALANCE");
           System.out.println(bal);
           st=true;
       }
       if(st==true)
       {
           return true;
       }
       else
       {
           System.out.println(bal);
           return false;
                 
        }
    }
    
     public void changePassword() throws SQLException {
        try {
            Statement st1 = con.createStatement();
            int i = st1.executeUpdate("update abcbank set password='" + pwd + "' where accno='" + accno + "'");
            if (i > 0) {
                out.print("Password changed successfully");

            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
           try
           {
              con.close(); 
           }
           catch(Exception e)
           {
               System.out.println(e); 
           }
        }
     }
        public boolean applyLoan() throws SQLException {
        String s = "select * from abcbank where accno = ?";
        pstmt = con.prepareStatement(s);
        pstmt.setInt(1, accno);
        ResultSet res = pstmt.executeQuery();
        while (res.next() == true) {
            name = res.getString("NAME");
            email = res.getString("EMAIL");
            return true;
        }
        return false;
    }
}
