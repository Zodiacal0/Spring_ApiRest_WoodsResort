package com.lte.woods_resort.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lte.woods_resort.models.Users;
import com.lte.woods_resort.repository.UserRepository;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<Users> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users chooseUsers(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Users saveUsers(Users users) {
        return userRepository.save(users);
    }


    @Override
    public void deleteUsers(Users users) {
        userRepository.delete(users);
    }

    
}
