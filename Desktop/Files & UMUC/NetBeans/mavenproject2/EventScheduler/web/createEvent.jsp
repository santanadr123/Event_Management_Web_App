<%-- 
    Document   : Create Event
    Created on : Feb 17, 2021
    Author     : Adam Santana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="CSS/event-manager-home-style.css">
        <title>Create Event</title>
    </head>
    <body>
        <!--------------------------SIDE NAV---------------------------------------->
        <jsp:include page="sideNav.jsp"></jsp:include>
        <!--------------------------SIDE NAV---------------------------------------->
        
        <!------------ONLY USERS WITH CREDENTIALS CAN ACCESS PAGE------------------->
         <%
            if(session.getAttribute("user")==null){
                response.sendRedirect("index.html");
            }
        %>
        <div class="mainWrapper">
            <h1>Create Event</h1>
            <form id="createEventFormID" action="CreateEvent" class="createEventForm" method="post" onsubmit="accountCreatedPopup()">
                <label>Customer Name:</label><input type="text" name="customerName" required/><br/>
                <label>Phone Number:</label><input type="tel" name="phoneNumber" required/><br/>
                <label>Event:</label>
                <select name="events">
                    <option value="wedding">Wedding</option>
                    <option value="babyshower">Baby shower</option>
                    <option value="birthday">Birthday</option>
                </select><br/>
                <label>Number of People:</label><input type="number" name="numberOfPeople" required/><br/>
                <label>Date:</label><input type="date" name="date" required/><br/>
                <label>From:</label><input type="time" name="startTime" required/><br/>
                <label>To:</label><input type="time" name="endTime" required/><br/>
                <label style="display: block; margin-left: 150px;">Notes: (Optional)</label><textarea style="margin: auto; display: block; resize: none" maxlength="200" rows="10" cols="70" name="notes" ></textarea>
                <p><b>NOTE: </b>200 Character limit.</p>
                <button type="submit" style="background-color: #cfc">Create Event</button>
                <span id="eventCreatedPopup"></span>
                <button type="reset">Clear</button>
            </form>
        </div>    
    </body>
    
    
    <!-------------SCRIPT FOR POPUP CONFIRMATION--------->
    <script>
        var form = document.getElementById("createEventFormID");  
        var check = true;
        
        function accountCreatedPopup(){
            event.preventDefault();
            if(check){
                check = false;
                swal({ 
                    title: "Event Added",
                    text: "",
                    icon: "success" 
                }).then(() => {
                    form.submit();
                });
            }
        };
    </script>
</html>
