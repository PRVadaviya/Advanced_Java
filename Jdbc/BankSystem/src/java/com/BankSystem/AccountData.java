package com.BankSystem;

import com.sun.jdi.connect.spi.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class AccountData extends HttpServlet {

    private String full_name = "";
    private String url = "jdbc:mysql://localhost:3306/Banking_System";
    private String user = "root";
    private String pass = "pratik";

    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");

        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }
              
        try (PrintWriter out = res.getWriter()) {
            String email = req.getParameter("Email");
            String password = req.getParameter("Password");
            int Initial_Amount = Integer.parseInt(req.getParameter("I_amount"));
            int Security_pin = Integer.parseInt(req.getParameter("S_pin"));
            int Confirm_Pin = Integer.parseInt(req.getParameter("C_pin"));

            try (java.sql.Connection con = DriverManager.getConnection(url, user, pass)) {

                if (isValidUser(email, password, con)) {
                    if (not_Have_Account(email, con)) {

                        if (Security_pin == Confirm_Pin) {
                            long act = generate_Act_No(con);
                            boolean b = moveData(act, email, Initial_Amount, Security_pin, con);

                            if (b) {
                                out.println("<center><h1> SucessFully Account Created </center></h1> <br>");
                            }
                            else{
                                out.println("<center><h1>Ooops...! Somethings went wrong  </center></h1> <br>");
                            }
                        } else {
                            out.println("<center><h1>Sorry...! Security Pin not match </center></h1> <br>");
                        }
                    } else {
                        out.println("<center><h1>Sorry...! You have already One Account here </center></h1> <br>");
                    }
                } else {
                    out.println("<center><h1>Sorry...! Email Id Not Register</center></h1> <br>");
                    out.println("<center><h1>Please First you should login Email Id</center></h1>");
                }

            } catch (Exception e) {
                out.println("Database error");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean isValidUser(String u_email, String u_password, java.sql.Connection con) {

        String q = "select * from user where email = ? AND password = ?";

        try (PreparedStatement pstmt = con.prepareStatement(q)) {
            
            pstmt.setString(1, u_email);
            pstmt.setString(2, u_password);
            
            ResultSet Rset = pstmt.executeQuery();
        
            while (Rset.next()) {
                String s2 = Rset.getString("password");
                String s1 = Rset.getString("email");
                this.full_name = Rset.getString("full_name");
                System.out.println(s1 + " " + full_name + "  " + s2);
                return true;
            }

            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean not_Have_Account(String u_email, java.sql.Connection con) {
        String q = "select email from accounts where email = ? ";

        try (PreparedStatement pstmt = con.prepareStatement(q)) {

            pstmt.setString(1, u_email);
            ResultSet Rset = pstmt.executeQuery();

            while (Rset.next()) {
                return false;
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;

    }

    public long generate_Act_No(java.sql.Connection con) {
        String q = "select account_number from accounts ORDER BY account_number DESC LIMIT 1     ";

        try (PreparedStatement pstmt = con.prepareStatement(q)) {

            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                long last_act_no = rset.getLong("account_number");
                return last_act_no + 1;
            } else {
                return 10000100;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 10000100;
    }

    public boolean moveData(long act_no, String u_email, int amt, int sPin, java.sql.Connection con) {

        String q = "insert into accounts(account_number , full_name , email , balance , security_pin) values (?,?,?,?,?)";

        try (PreparedStatement pstmt = con.prepareStatement(q)) {

            pstmt.setLong(1, act_no);
            pstmt.setString(2, full_name);
            pstmt.setString(3, u_email);
            pstmt.setInt(4, amt);
            pstmt.setInt(5, sPin);

            pstmt.executeUpdate();
            System.out.println("SucessFully Data Inserted");
            return true;
        } catch (SQLException e) {
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
