<%-- 
    Document   : Event Manager HomePage
    Created on : Feb 15, 2021
    Author     : Adam Santana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
        <title>Create Account</title>
        <link rel="stylesheet" href="CSS/event-manager-home-style.css">
        <link rel="stylesheet" href="CSS/index-createAccount-style.css"> 
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:wght@300&display=swap" rel="stylesheet">
    </head>
    <body>
        <section class="mainSection">
             
             
        <!----------ONLY USERS WITH CREDENTIALS CAN SEE SIDE NAV ON PAGE------------>
            <%
               if(session.getAttribute("user")!=null){     
               %> 
        <!--------------------------SIDE NAV---------------------------------------->
                   <jsp:include page="sideNav.jsp"></jsp:include>
                   
                   <style>
                       .cancel_button{
                           display: none;
                       }
                   </style>
        <!--------------------------SIDE NAV---------------------------------------->
               <%}
           %>
            <div class="formTitle">
                <h1>Create new account</h1>
            </div>
            <div class="createAccountForm">
                <form action="createAccount" method="post">
                    <label for="username">Username</label><input type="text" name="username" id="username" required><br/>
                    <label for="firstName">First Name</label><input type="text" name="firstName" id="name" required><br/>
                    <label for="lastName">Last Name </label><input type="text" name="lastName" id="lastname" required><br/>
                    <label for="email">E-mail</label><input type="email" name="email" id="email" required><br/>
                    <label for="password">Password</label><input type="password" name="password" id="password" required><br/>
                    <button type="submit" style="background-color: #cfc">Create Account</button>
                    <button type="reset">Clear</button>
                    <a href="index.html" class="cancel_button"><button type="button" style="background-color: #f33">Cancel</button></a>
                </form>
            </div>
           
        </section>
    </body>
</html>
