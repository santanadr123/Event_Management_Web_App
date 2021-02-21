
/*
    Document   : DeleteEvent
    Author     : Adam Santana
*/

package com.eventplanner.DAO;

import com.eventplanner.util.ConnectToDB;
import com.eventplanner.util.MetaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEvent {
    
    public void deleteEvent(String event){
    
        MetaModel metaModel = new MetaModel();
        
        try(Connection connection = ConnectToDB.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(metaModel.deleteEventSQL());){
            preparedStatement.setString(1, event);
            preparedStatement.executeUpdate();
        }catch(SQLException ex){}
                
           
    }
    
}
