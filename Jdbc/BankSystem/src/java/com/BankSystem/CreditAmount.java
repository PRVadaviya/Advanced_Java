package com.BankSystem;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class CreditAmount extends HttpServlet {

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
            long C_account_No = Long.parseLong(req.getParameter("C_account_no"));
            long D_account_No = Long.parseLong(req.getParameter("D_account_no"));
            int Credit_Amount = Integer.parseInt(req.getParameter("c_amount"));
            int Security_pin = Integer.parseInt(req.getParameter("S_pin"));

            try (java.sql.Connection con = DriverManager.getConnection(url, user, pass)) {
                if (isValidAccount(C_account_No, Security_pin, con)) {
                    out.println("<center><h1>Request Sucessfully Sent to Account No :" + D_account_No + " </center></h1> <br><br>");
                } else {
                    out.println("<center><h1>Pleese.... Enter Valid Account_No and Pin  </center></h1> <br><br>");

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isValidAccount(long a_no, int s_pin, java.sql.Connection con) {
        String q = "select * from accounts where account_number = ?";

        try (PreparedStatement pstmt = con.prepareStatement(q)) {
            pstmt.setLong(1, a_no);
            ResultSet Rset = pstmt.executeQuery();

            if (Rset.next()) {
                long u_account_no = Rset.getLong("account_number");
                int u_security_pin = Rset.getInt("Security_Pin");

                if ((u_security_pin == s_pin) && (u_account_no == a_no)) {
                    return true;
                }
            }
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
