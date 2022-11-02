package com.enseirb.myapp.myapp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;



@Component
public class TruckRepository {
    private Map<Long, Truck> trucks = new HashMap<>();

    TruckRepository() {
        trucks.put(1L, new Truck(1000, "10-09-2022", 4000));
        trucks.put(2L, new Truck(1011, "10-09-2020", 4000));
        trucks.put(3L, new Truck(1022, "10-08-2010", 4000));
        trucks.put(4L, new Truck(1033, "07-07-2022", 4000));
    }

    @GetMapping("/{id}")
    public Truck getById(Long id){
        if (id <= 0 || id > 4) {
            throw new IllegalArgumentException("Truck not exists");
        }
        return trucks.get(id);
    }
}

