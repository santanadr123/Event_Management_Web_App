
/*
    Document   : CreateEventDAO
    Author     : Adam Santana
*/

package com.eventplanner.DAO;

import com.eventplanner.model.Event;
import com.eventplanner.util.ConnectToDB;
import com.eventplanner.util.MetaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateEventDAO {
    
    public static void createEvent(Event event){
        
        Connection connection = ConnectToDB.connect();
        PreparedStatement preparedStatement = null;
        MetaModel metaModel = new MetaModel();
        
        try{
            preparedStatement = connection.prepareStatement(metaModel.createEventSQL());
            preparedStatement.setString(1, event.getCustomerName());
            preparedStatement.setString(2, event.getPhoneNumber());
            preparedStatement.setString(3, event.getEvent());
            preparedStatement.setString(4, event.getNumberOfPeople());
            preparedStatement.setString(5, event.getDate());
            preparedStatement.setString(6, event.getStartTime());
            preparedStatement.setString(7, event.getEndTime());
            preparedStatement.setString(8, event.getNotes());
            preparedStatement.executeUpdate();
        }catch(SQLException ex){
        }finally{
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(CreateEventDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
