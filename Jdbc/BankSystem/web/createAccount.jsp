<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="createaccount.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body>
        <div class="login-container">
        
        <form action="c_account" method="post">
            
           
            <label for="Email">Email</label>
            <input type="text" id="Email" name="Email" placeholder="Enter Valid Email" required>
            
            <label for="password">Password</label>
            <input type="password" id="Password" name="Password" placeholder="Enter Password" required>
            
            <label for="I_amount">Initial amount</label>
            <input type="number" id="I_amount" name="I_amount" placeholder="Enter Amount" required>
            
            <label for="S_pin">Security Pin</label>
            <input type="number" id="S_pin" name="S_pin" placeholder="Enter 4 digit pin" required>
            
            <label for="C_pin">Confirm Pin</label>
            <input type="number" id="C_pin" name="C_pin" placeholder="Re Enter 4 digit pin" required>
            
            <button type="submit" class="login-btn">Login</button>
           
        </form>
    </div>
    </body>
</html>
