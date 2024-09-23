package com.lte.woods_resort.services;

import java.util.List;

import com.lte.woods_resort.models.Rooms;

public interface IRoomsService {

    public List<Rooms> listRooms();

    public Rooms findRooms(Long id_rooms);

    public Rooms saveRooms(Rooms rooms);

    public void deleteRooms(Rooms rooms);

}
