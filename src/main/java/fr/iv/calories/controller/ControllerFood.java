package fr.iv.calories.controller;

import fr.iv.calories.entity.Food;
import fr.iv.calories.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/food")
public class ControllerFood {

    @Autowired
    private FoodService foodServiceImpl;

    @GetMapping("/home")
    public String home(){
        return "home-page";
    }

    @RequestMapping("/list")
    public String listFoods(Model theModel) {

        List<Food> foods;
        foods = foodServiceImpl.getFoods();

        theModel.addAttribute("foods", foods);
        return "list-foods";
    }
}
