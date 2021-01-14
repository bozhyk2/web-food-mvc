package fr.iv.calories.controller;

import fr.iv.calories.entity.Food;
import fr.iv.calories.service.FoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Food item = new Food();
        List<String> types = foodServiceImpl.getExistFoodTypes();
        theModel.addAttribute("food", item);
        theModel.addAttribute("foodTypes", types);

        return "food-form";
    }

    @PostMapping("/saveFood")
    public String saveFood(@ModelAttribute("food") Food theFood, Model theModel) {
        foodServiceImpl.saveFood(theFood);

        return listFoods(theModel);
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("foodId") int foodId, Model theModel) {
        Food item = foodServiceImpl.getFood(foodId);
        theModel.addAttribute("food", item);
        List <String> types = foodServiceImpl.getExistFoodTypes();
        theModel.addAttribute("foodTypes", types);

        return "food-form";
    }

    @GetMapping("/deleteFood")
    public String deleteFood(@RequestParam("foodId") int foodId, Model theModel) {
        foodServiceImpl.deleteFood(foodId);

        return listFoods(theModel);
    }

    @GetMapping("/searchFood")
    public String searchFoods(@RequestParam("theSearchFood") String partFoodName, Model theModel) {
        List <Food> foods = foodServiceImpl.searchFoods(partFoodName);
        theModel.addAttribute("foods", foods);

        return "list-foods";
    }

}
