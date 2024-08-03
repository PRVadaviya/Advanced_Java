<%-- 
    Document   : Check_Balance
    Created on : 04-Aug-2024, 1:34:29 am
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="Check_Balance.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>check balance</title>
    </head>
    <body>
         <div class="login-container">
        
        <form action="C_Balance" method="post">
            
            <label for="Account_N">Account Number</label>
            <input type="number" id="Account_N" name="Account_N" placeholder="Enter Account Number" required>
            
            <label for="S_pin">Security Pin</label>
            <input type="number" id="S_pin" name="S_Pin" placeholder="Enter 4 digit pin" required>
           
            <button type="submit" class="login-btn">Submit</button>
           
        </form>
    </div>
       
    </body>
</html>
