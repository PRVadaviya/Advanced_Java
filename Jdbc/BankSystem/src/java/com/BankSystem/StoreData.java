package com.BankSystem;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;



public class StoreData extends HttpServlet {
        
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {
        res.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = res.getWriter()) 
        {
            String name = req.getParameter("Full Name");
            String email = req.getParameter("Email");
            String password = req.getParameter("Password");

             String url = "jdbc:mysql://localhost:3306/Banking_System";
             String user = "root";
            String pass = "pratik";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }

            try ( Connection con = DriverManager.getConnection(url, user, pass)) 
            {  
                    if(!user_exist(email , con ))
                    {
                         // store data into user table
                        String q = "insert into user (full_name , email , password) VALUES (?, ?, ?)";

                        try (PreparedStatement pstmt = con.prepareStatement(q)) 
                        {
                            pstmt.setString(1, name);
                            pstmt.setString(2, email);
                            pstmt.setString(3, password);

                            pstmt.executeUpdate();
                            out.println("<center><h1>Registration successful...</h1></center>");
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }    
                    }
                    else
                    {
                        out.println("<center><h1>Sorry...! Email already exist</center></h1> <br>");
                        out.println("<center><h1>Please Try Another Email Id</center></h1>");
                    }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
                
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    
    public boolean user_exist(String email , Connection c)
    {
        String query = "SELECT * FROM user WHERE email = ?";
        try{
            PreparedStatement preparedStatement = c.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
            else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    
    
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
