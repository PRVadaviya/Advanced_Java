
package com.BankSystem;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.* ;

public class DebitAmount extends HttpServlet
{
    int i_Row ;
    private int current_balance = 0 ;
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
            long C_account_No = Long.parseLong(req.getParameter("C_account_no"));
            long D_account_No = Long.parseLong(req.getParameter("D_account_no"));
            int Debit_Amount = Integer.parseInt(req.getParameter("d_amount"));
            int Security_pin = Integer.parseInt(req.getParameter("S_pin"));
         

            try (java.sql.Connection con = DriverManager.getConnection(url, user, pass)) 
            {
                if(isValidAccount(D_account_No , Security_pin , con)){
                    
                    if(isValidCreditAccount(C_account_No , con))
                    {
                        int row = do_Debit_Amount(D_account_No ,C_account_No , Debit_Amount , con );
                        
                        if(row == 1)
                        {
                             out.println("<center><h1> "+ Debit_Amount + "  Debit From Account No "+D_account_No+"  </center></h1> <br>");
                             out.println("<center><h1>   And Transfer To Account No "+C_account_No+"  </center></h1> <br><br>");
                        }
                        else if(row == 2)
                        {
                            out.println("<center><h1> Sorry....! Transcation Denied , Not Sufficient Balance in your Account  </center></h1> <br><br>");
                        }
                        else if(row == 0 )
                        {
                            out.println("<center><h1>Something went wrong.....!  </center></h1> <br><br>");
                        }
                    }else
                    {
                             out.println("<center><h1>Credit Account_No Is Not Exist.....!  </center></h1> <br><br>");
                    }
                }
                else{
                          out.println("<center><h1>Please.. Enter Correct Account_No Or Pin  </center></h1> <br><br>");
                }
                        
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
     public boolean isValidAccount(long a_no , int s_pin , java.sql.Connection con )
    {
        String q = "select * from accounts where account_number = ?" ;
        
        try(PreparedStatement pstmt = con.prepareStatement(q))
        {
            pstmt.setLong(1, a_no);
            ResultSet Rset = pstmt.executeQuery();
            
            if(Rset.next())
            {
                long u_account_no = Rset.getLong("account_number");
                int u_security_pin = Rset.getInt("Security_Pin");
                current_balance = Rset.getInt("balance");
                if((u_security_pin == s_pin) && (u_account_no == a_no))
                    return true ;
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false ;
    }
   
     
     public int do_Debit_Amount(Long d_a_no ,long c_a_no , int amount ,  java.sql.Connection con ) throws SQLException
     {
         
         
         if(amount >= current_balance)
         {
             i_Row = 2 ;
             return i_Row ;
         }
         else
         {
            String q1 = "UPDATE accounts SET balance = balance - ? where account_number = ? " ;
            String q2 = "UPDATE accounts SET balance = balance + ? where account_number = ? " ;

           try(PreparedStatement pstmt1 = con.prepareStatement(q1) )
           {   PreparedStatement pstmt2 = con.prepareStatement(q2); 
                
                con.setAutoCommit(false);
      
               pstmt1.setLong(1, amount);
               pstmt1.setLong(2, d_a_no);
               pstmt2.setLong(1, amount);
               pstmt2.setLong(2, c_a_no);

                pstmt1.execute();
                pstmt2.execute();
               con.commit();
             
               return i_Row=1 ;
           }
           catch(SQLException e)
           {
               con.rollback();
           }
           
         }
        
        return i_Row=0 ;
     }
    
    
     public boolean isValidCreditAccount(long C_A_No , java.sql.Connection con)
     {

        String q = "select * from accounts where account_number = ? ";

        try (PreparedStatement pstmt = con.prepareStatement(q)) {
            
            pstmt.setLong(1, C_A_No);
                        
            ResultSet Rset = pstmt.executeQuery();
        
            if(Rset.next()) 
            {
                return true;
            }

            return false;
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




/* String q1 = "UPDATE accounts SET balance = balance - ? where account_number = ? " ;
            String q2 = "UPDATE accounts SET balance = balance + ? where account_number = ? " ;

            Statement stmt = con.createStatement() ;
           try(PreparedStatement pstmt1 = con.prepareStatement(q1) )
           {   PreparedStatement pstmt2 = con.prepareStatement(q2); 

               con.setAutoCommit(false);

               pstmt1.setLong(1, d_a_no);
               pstmt2.setLong(1, c_a_no);

               stmt.addBatch(q1);
               stmt.addBatch(q2);

               i_Row = stmt.executeBatch();
               con.commit();

               return i_Row ;
           }
           catch(SQLException e)
           {
               System.out.print("Sql query");
               con.rollback();
           }
           finally{
                  con.close();
                  stmt.close();
           }
         }*/
