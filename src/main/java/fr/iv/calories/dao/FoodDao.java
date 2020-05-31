package fr.iv.calories.dao;

import fr.iv.calories.entity.Food;

import java.util.List;

public interface FoodDao {
    List<Food> getFoods();

    List<String> getExistFoodTypes();
}
