package com.example.authapi.DataAccessLayer;


import java.util.List;
import java.util.Optional;

// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.authapi.model.User;

@Repository
public class DataAccessService {

    @Autowired
    private UserRepository repository;

    public Optional<User> findUserById(Long id) {
        Optional<User> target = repository.findById(id);
        return target;
    }

    public Optional<User> findByEmail(String emailString) {
        Optional<User> user = repository.findByEmail(emailString);
        return user;

    }
    
    public int addUser(User newUser) {
        Optional<User> test = findByEmail(newUser.getEmail());
        if (test.isPresent()) {
            return 0;
        }
        repository.save(newUser);
        return 1;
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    
    // public User updateUserByEmail(String email, User newUser) {
    //     Optional<User> requiredUser = findByEmail(email);

    //     if (requiredUser.isPresent()) {
            
    //     }

    //     return newUser;

    // }

}
