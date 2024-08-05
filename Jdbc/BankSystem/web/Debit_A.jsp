<%-- 
    Document   : Debit_A
    Created on : 05-Aug-2024, 11:09:31 pm
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Debit Amount</title>
    </head>
    <body>
        <div class="login-container">
        
        <form action="D_Account" method="post">
                      
            <label for="password">Debit Account No</label>
            <input type="number" id="account_no" name="D_account_no" placeholder="Enter Debit Account No" required>
            
            <label for="password">Credit Account No</label>
            <input type="number" id="C_account_no" name="C_account_no" placeholder="Enter Credit Account No" required>
            
            <label for="d_amount">Debit amount</label>
            <input type="number" id="d_amount" name="d_amount" placeholder="Enter Amount" required>
            
            <label for="S_pin">Security Pin</label>
            <input type="number" id="S_pin" name="S_pin" placeholder="Enter 4 digit pin" required>
            
            <button type="submit" class="login-btn">Confirm</button>
           
        </form>
    </div>
     
    </body>
</html>
