package com.lte.woods_resort.services;

import java.util.List;

import com.lte.woods_resort.models.Users;

public interface IUserService {
    public List <Users> listUsers();

    public Users chooseUsers(String iduser);

    public Users saveUsers(Users users);

    public void deleteUsers(Users users);
}
