package com.lte.woods_resort.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lte.woods_resort.models.Hotels;
import com.lte.woods_resort.repository.HotelsRepository;

public class HotelsService implements IHotelsService {

    private Hotels hotels;

    @Autowired
    private HotelsRepository hotelsRepository;

    @Override
    public List<Hotels> listHoteles() {
        return hotelsRepository.findAll();
    }

    @Override
    public Hotels searchHotels(Long idHotel){
        this.hotels = hotelsRepository.findById(idHotel).orElse(null);
        return this.hotels;
    }

    @Override
    public Hotels saveHotels(Hotels hotel) {
        return hotelsRepository.save(hotel);
    }

    @Override
    public void removeHotels(Hotels hotel) {
        hotelsRepository.delete(hotel);
    }
}
