
package com.BankSystem;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.* ;

public class DebitAmount 
{
    
    private String url = "jdbc:mysql://localhost:3306/Banking_System";
    private String user = "root";
    private String pass = "pratik";

    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {
        res.setContentType("text/html;charset=UTF-8");

        try 
        {
          Class.forName("com.mysql.cj.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
            return;
        }
              
        try (PrintWriter out = res.getWriter()) 
        {
            String password = req.getParameter("Password");
            int Debit_Amount = Integer.parseInt(req.getParameter("I_amount"));
            int Security_pin = Integer.parseInt(req.getParameter("S_pin"));
         

            try (java.sql.Connection con = DriverManager.getConnection(url, user, pass)) 
            {
                
                
                
                
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    
    
}
