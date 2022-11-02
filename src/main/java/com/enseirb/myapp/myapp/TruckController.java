package com.enseirb.myapp.myapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/truck")
public class TruckController {

    @Autowired TruckRepository truckRepository;

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id){
        try {
            return truckRepository.getById(id).toString();
        } catch (IllegalArgumentException e) {
            return "Error 404";
        }
    }
}
