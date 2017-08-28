package com.example.springbootdemo.controller;

import com.example.springbootdemo.biz.dao.mapper.HotelMapper;
import com.example.springbootdemo.biz.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class HotelController {

    @Autowired
    private HotelMapper hotelMapper;

    @RequestMapping("/saveHotel")
    public String saveHotel(Hotel h){
        Hotel hotel =new Hotel();
        hotel.setId(UUID.randomUUID().toString());
        hotel.setCityName(h.getCityName());
        hotel.setHotelName(h.getHotelName());
        hotel.setAddress(h.getAddress());
        hotel.setCountry(h.getAddress());
        hotel.setState(h.getState());
        return hotelMapper.saveHotel(hotel).toString();
    }

    @RequestMapping("/findHotelByCityName")
    public String findHoletByCityName(String cityName){

        return hotelMapper.findByCountry(cityName).toString();
    }

}
