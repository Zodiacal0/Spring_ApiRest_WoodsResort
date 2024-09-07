package com.lte.woods_resort.services;

import java.util.List;

import com.lte.woods_resort.models.Hotels;

public interface IHotelsService {
     public List<Hotels> listHoteles();
     public Hotels searchHotels(Long idHotel);
     public Hotels saveHotels(Hotels hotel);
     public void removeHotels(Hotels hotel);
}
