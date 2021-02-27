
/*
    Document   : CreateAccountDAO
    Author     : Adam Santana
*/

package com.eventplanner.DAO;

import com.eventplanner.model.User;
import com.eventplanner.util.ConnectToDB;
import com.eventplanner.util.MetaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CreateAccountDAO {

    public static void createUser(User newUser) {
        
        Connection connection = ConnectToDB.connect();
        MetaModel metaModel = new MetaModel();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(metaModel.createAccountSQL());
            preparedStatement.setString(1, newUser.getUsername());
            preparedStatement.setString(2, newUser.getPassword());
            preparedStatement.setString(3, newUser.getFirstname());
            preparedStatement.setString(4, newUser.getLastName());
            preparedStatement.setString(5, newUser.getEmail());
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CreateAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(CreateAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
