package com.example.authapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authapi.DataAccessLayer.DataAccessService;
import com.example.authapi.model.User;

@Service
public class UserService {

    DataAccessService db;
    @Autowired
    public UserService(DataAccessService db) {
        this.db = db;
    } 

    public String addUser(User newUser) {

        Optional<User> result = db.findByEmail(newUser.getEmail());

        if (result.isPresent()) {
            return "Unable to add user";
        }

        


        return "User Succesfully added";

    }

    public String getUsers() {

        List<User> users = db.getUsers();
        String outputString = "";

        if (users.size() == 0) {
            return "No users in the database";
        }

        for (int i  = 0; i < users.size(); i++) {
            outputString += users.get(i).toString();
            outputString += "\n";
        }

        return outputString;

    }

}
