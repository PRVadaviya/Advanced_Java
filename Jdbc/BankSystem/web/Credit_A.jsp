<%-- 
    Document   : Credit_A
    Created on : 06-Aug-2024, 2:20:22 am
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="Credit_A.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>credit Page</title>
    </head>
    <body>
        <div class="login-container">

            <form action="Creditamount" method="post">

                <label for="C_account_no">Credit Account No</label>
                <input type="number" id="C_account_no" name="C_account_no" placeholder="Enter Debit Account No" required>

                <label for="D_account_no">Debit Account No</label>
                <input type="number" id="D_account_no" name="D_account_no" placeholder="Enter Credit Account No" required>

                <label for="c_amount">Credit amount</label>
                <input type="number" id="c_amount" name="c_amount" placeholder="Enter Amount" required>

                <label for="S_pin">Security Pin</label>
                <input type="number" id="S_pin" name="S_pin" placeholder="Enter 4 digit pin" required>

                <button type="submit" class="login-btn">Confirm</button>

            </form>
        </div>

    </body>
</html>
