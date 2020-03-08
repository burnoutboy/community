package com.ydsoft.community.controller;

import com.ydsoft.community.mapper.CityMapper;
import com.ydsoft.community.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class CityController {

    @Autowired
    CityMapper cityMapper;

    @GetMapping("/add")
    @ResponseBody
    public String add(@RequestParam("name")String name)
    {
        City city = new City();
        city.setName(name);
        city.setCountry(UUID.randomUUID().toString());
        city.setState("0");
        int s = cityMapper.insert(city);
        return s > 0 ? "success" : "fail";
    }
}
