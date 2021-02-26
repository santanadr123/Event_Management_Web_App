
/*
    Document   : EventsDAO
    Author     : Adam Santana
*/

package com.eventplanner.DAO;

import com.eventplanner.model.Event;
import com.eventplanner.util.ConnectToDB;
import com.eventplanner.util.MetaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;


public class EventsDAO {
    
    public static List<Event> getAllEvents(){
        
       
        PreparedStatement preparedStatement = null;
        List<Event> events = new ArrayList<>();
        
        try(Connection connection = ConnectToDB.connect();) {
            
            MetaModel metaModel = new MetaModel();
            preparedStatement = connection.prepareStatement(metaModel.getAllEventsSQL());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String customerID = rs.getString(1);
                String customerName = rs.getString(2);
                String phoneNumber = rs.getString(3);
                String event = rs.getString(4);
                String numberOfPeople = rs.getString(5);
                String date = rs.getString(6);
                String startTime = rs.getString(7);
                String endTime = rs.getString(8);
                String notes = rs.getString(9);
        
                Event myEvent = new Event(customerID, customerName, event, phoneNumber,
                numberOfPeople, date, startTime, endTime, notes);
                events.add(myEvent);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
              
                preparedStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(EventsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return events;
    }
    
}
