package fr.iv.calories.service;

import fr.iv.calories.entity.Food;

import java.util.List;

public interface FoodService {
    List<Food> getFoods();

    List<String> getExistFoodTypes();

    void saveFood(Food theFood);

    Food getFood(int foodId);

    void deleteFood(int foodId);
}
