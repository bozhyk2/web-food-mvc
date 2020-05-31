package fr.iv.calories.controller;

import fr.iv.calories.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/food")
public class ControllerFood {

    @Autowired
    private FoodService foodServiceImpl;

    @GetMapping("/home")
    public String home(){
        return "home-page";
    }
}
