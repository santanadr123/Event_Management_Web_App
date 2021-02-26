/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.contoller;

import com.eventplanner.DAO.CreateAccountDAO;
import com.eventplanner.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/createAccount")
public class CreateAccountController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        register(request, response);
        
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        
        User newUser = new User(username, password, firstName, lastName, email);
        CreateAccountDAO.createUser(newUser);
        response.sendRedirect("index.html");
    }


}
