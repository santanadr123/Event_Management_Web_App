/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectToDB {
    
    public static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-03.cleardb.com:3306/heroku_b474a30c1436448?useSSL-true", "bdd1b3f9484dd9", "082c16d8");
            return connection;
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConnectToDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
