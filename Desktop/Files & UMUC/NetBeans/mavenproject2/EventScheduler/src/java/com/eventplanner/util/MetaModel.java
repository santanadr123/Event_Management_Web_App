/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.util;


public class MetaModel {
    
    public String loginSQL(){
        String loginSQL = "select * from users where username = ? and password = ?";
        return loginSQL;
    }
    
    public String createAccountSQL(){
        String createAccountSQL = "insert into users (username, password, firstName, lastName, email) values "
                + "(?, ?, ?, ?, ?)";
        return createAccountSQL;
    }
    
    public String createEventSQL(){
    
        String createEventSQL = "insert into my_events (customerName, phoneNumber, event, numberOfPeople, date, start_time, end_time, notes) values "
                + "(?, ?, ?, ?, ?, ?, ?, ?)";
        return createEventSQL;
    }
    
    public String getAllEventsSQL(){
    
        String eventsSQL = "select * from my_events";
        return eventsSQL;
    }
    
    public String deleteEventSQL(){
        
        String deleteEventSQL = "delete from my_events where customerid = ?";
        return deleteEventSQL;
    }
}
