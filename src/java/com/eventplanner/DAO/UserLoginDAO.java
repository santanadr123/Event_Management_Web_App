/*
    Document   : UserLoginDAO
    Author     : Adam Santana
*/

package com.eventplanner.DAO;

import com.eventplanner.util.ConnectToDB;
import com.eventplanner.model.User;
import com.eventplanner.util.MetaModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserLoginDAO {
    
    ResultSet resultSet;
    User user;   

    public boolean login(User user){
        
        boolean success = false;
        Connection connection = ConnectToDB.connect();
        PreparedStatement preparedStatement = null;
        try{
            
            MetaModel metaModel = new MetaModel();
            preparedStatement = connection.prepareStatement(metaModel.loginSQL());
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet executeQuery = preparedStatement.executeQuery();
            success = executeQuery.next();

        }catch(SQLException ex){
            System.out.println("Data base error: " + ex.getStackTrace());
        }finally{
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserLoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }      
        return success;      
    }
}