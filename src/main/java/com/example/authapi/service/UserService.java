package com.example.authapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authapi.DataAccessLayer.DataAccessService;
import com.example.authapi.model.User;
import com.example.authapi.security.jwtService;

@Service
public class UserService {

    DataAccessService db;
    jwtService tokenService;

    @Autowired
    public UserService(DataAccessService db, jwtService tokenService) {
        this.db = db;
        this.tokenService = tokenService;
    } 


    public String addUser(User newUser) {

        Optional<User> result = db.findByEmail(newUser.getEmail());

        if (result.isPresent()) {
            return "Unable to add user";
        }

        db.addUser(newUser);

        String jwtToken = tokenService.generateToken(newUser);
        return "User Succesfully added\n + Your jwt token is: " + jwtToken;
        // return "User succesfully added";

    }

    public List<User> getUsers() {

        List<User> users = db.getUsers();
        String outputString = "";

        // if (users.size() == 0) {
        //     return "No users in the database";
        // }

        // for (int i  = 0; i < users.size(); i++) {
        //     outputString += users.get(i).toString();
        //     outputString += "\n";
        // }

        // return outputString;

        return users;

    }

}
