package com.lte.woods_resort.services;

import java.util.List;

import com.lte.woods_resort.models.Users;

public interface IUserService {
    public List<Users> listarTareas();

    public Users buscarTareaPorId(Integer iduser);

    public void guardarTarea(Users users);

    public void eliminarTarea(Users users);
}
