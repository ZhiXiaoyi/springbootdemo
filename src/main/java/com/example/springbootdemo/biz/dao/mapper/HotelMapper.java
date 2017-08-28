package com.example.springbootdemo.biz.dao.mapper;

import com.example.springbootdemo.biz.entity.Hotel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HotelMapper {

     List<Hotel> findByCountry(String country);

     Boolean  saveHotel (Hotel hotel);
}
