/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.contoller;

import com.eventplanner.DAO.UserLoginDAO;
import com.eventplanner.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santa
 */

@WebServlet("/login")
public class LoginController extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            validateUser(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void validateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
       
        UserLoginDAO loginUser = new UserLoginDAO();
        
        if(loginUser.login(user)){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("EventManagerHomePage.jsp");
        }else{
            response.sendRedirect("index.html");
        }    
    }
}
