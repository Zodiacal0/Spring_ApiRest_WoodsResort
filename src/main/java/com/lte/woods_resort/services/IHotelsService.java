package com.lte.woods_resort.services;

import java.util.List;
public interface IHotelsService {
    
     public List<Hotels> lisHoteles();
     public Hotels searchHotels();
     public Hotels saveHotels();
     public void removeHotels();

}
