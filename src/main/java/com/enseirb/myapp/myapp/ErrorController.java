package com.enseirb.myapp.myapp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @GetMapping("/error")
    public String sendError(){
        return "Error 404";
    }
    
}
