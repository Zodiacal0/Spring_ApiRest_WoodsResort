package com.lte.woods_resort.services;

import java.util.List;

import com.lte.woods_resort.models.Users;

public interface IUserService {
    public  List<Users> listUsers();

    public Users chooUsers(String iduser);

    public void saveUsers(Users users);

    public void deleteUsers(Users users);
}
