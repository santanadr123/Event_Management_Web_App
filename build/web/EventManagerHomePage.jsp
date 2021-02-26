<%-- 
    Document   : Event Manager HomePage
    Created on : Feb 15, 2021
    Author     : Adam Santana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Event Manager HomePage</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&family=Quicksand&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="CSS/event-manager-home-style.css">
    </head>
    <body>  
        
        <!------------ONLY USERS WITH CREDENTIALS CAN ACCESS PAGE------------------->

        <%
            response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); //HTTP 1.1
            
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0
            
            response.setHeader("Expires","0");  // Proxies
            
            if(session.getAttribute("user")==null){
                response.sendRedirect("index.html");
            }
        %>
        
        <!--------------------------SIDE NAV---------------------------------------->
        
        <jsp:include page="sideNav.jsp"></jsp:include>
        
        <!--------------------------SIDE NAV---------------------------------------->
        
        <section style="margin-left: 200px">
            <div class="homepage_wrapper">
                <h1>Welcome</h1>
                <div class="border"></div>
                <div class="homepage_instructions_title">
                    <h2>Instructions:</h2>
                    <div class="border_instruction"></div>
                </div>
                <div class="homepage_instructions_text">
                    <p><b>Create Event:</b> Use this link to navigate to the <i><q>Create Event</q></i> page.
                        This page allows users to add/save new events.</p>
                    <p><b>All events: </b> Page containing all the events that have been created by all users. Use this page to
                    browse or delete events.</p>
                    <p><b>Create Account:</b> To create a new account/user, use this link.</p>
                </div>
            </div>
        </section>
    </body>
</html>
