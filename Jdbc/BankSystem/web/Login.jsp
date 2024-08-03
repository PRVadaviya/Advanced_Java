

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="login.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
       <div class="login-container">
        <h2>Login</h2>
        
        <form action="Login_A" method="post">
            
            <label for="Full Name">Full Name</label>
            <input type="text" id="Full Name" name="Full Name" placeholder="Enter Full Name" required>
            
            <label for="Email">Email</label>
            <input type="text" id="Email" name="Email" placeholder="Enter Valid Email" required>
            
            <label for="password">Password</label>
            <input type="password" id="Password" name="Password" placeholder="Enter Password" required>
     
            <div class="remember-me">
                <input type="checkbox" id="remember" name="remember">
                <label for="remember">Remember me</label>
            </div>
            
            <button type="submit" class="login-btn">Login</button>
            <a href="index.html"><button type="button" class="cancel-btn">Cancel</button></a>
            
            
        </form>
    </div>
        
        
    </body>
</html>
