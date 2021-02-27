<%-- 
    Document   : allEvents
    Created on : Feb 17, 2021
    Author     : santa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="CSS/event-manager-home-style.css">
        <title>All Events</title>
    </head>
    <body>
        
        <!-----------------------CLASSES IMPORTS------------------------------------>
        <%@page import="com.eventplanner.DAO.EventsDAO" %>
        <%@page import="com.eventplanner.model.Event" %>
        <%@page import="java.util.List" %>
        
        <!--------------------------SIDE NAV---------------------------------------->
        <jsp:include page="sideNav.jsp"></jsp:include>
        <!--------------------------SIDE NAV---------------------------------------->
        
        <div class="allEventsWrapper">
            
        <!------------ONLY USERS WITH CREDENTIALS CAN ACCESS PAGE------------------->
            <%
               if(session.getAttribute("user")==null){
                   response.sendRedirect("index.html");
               }
           %>
         
        <!--------------------TABLE WITH DATA (EVENTS)------------------------------>
           
            <h1>All Events</h1>
            <table class="table table-striped table-hover">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Event</th>
                        <th scope="col">Phone Number</th>
                        <th scope="col"># Guess</th>
                        <th scope="col">Date</th>
                        <th scope="col">Start</th>
                        <th scope="col">End</th>
                        <th scope="col">Notes</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
        <!--------------GET ALL EVENTS AND ADD THEM TO TABLE----------------------->
                <%  
                    List<Event> events = EventsDAO.getAllEvents();
                    int i = 1;
                    for(Event event :  events) {   
                        String customerID = event.getCustomerID();
                %>
         
                        <tr>                          
                            <th scope="row"><%=i%></th>      
                            <td><%=customerID%></td>
                            <td><%=event.getCustomerName()%></td>
                            <td><%=event.getPhoneNumber()%></td>
                            <td><%=event.getEvent()%></td>
                            <td><%=event.getNumberOfPeople()%></td>
                            <td><%=event.getDate()%></td>
                            <td><%=event.getStartTime()%></td>
                            <td><%=event.getEndTime()%></td>
                            <td><%=event.getNotes()%></td> 
                            <td>
                                 <form action="deleteEvent" method="post">
                                     <button name="customerID" value="<%=customerID%>" type="submit" class="btn btn-danger">DELETE</button>
                                 </form>
                            </td>                     
                        </tr>
                <!-------------------INCREMENT ROW INDEX--------------------------->
                <%
                    i++;
                    }
                %>
        
                </tbody>
            </table>
        </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    </body>
</html>
