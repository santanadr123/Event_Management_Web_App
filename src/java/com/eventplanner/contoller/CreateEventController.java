/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.contoller;

import com.eventplanner.DAO.CreateEventDAO;
import com.eventplanner.model.Event;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CreateEvent")
public class CreateEventController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        createEvent(request, response);
    }

    private void createEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
      
        String customerName = request.getParameter("customerName");
        String phoneNumber = request.getParameter("phoneNumber");
        String event = request.getParameter("events");
        String numberOfPeople = request.getParameter("numberOfPeople");
        String date = request.getParameter("date");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String notes = request.getParameter("notes");
        
        Event createEvent = new Event(customerName, phoneNumber, event,
        numberOfPeople, date, startTime, endTime, notes);
        
        CreateEventDAO.createEvent(createEvent);
        response.sendRedirect("createEvent.jsp");
        
    }


}
