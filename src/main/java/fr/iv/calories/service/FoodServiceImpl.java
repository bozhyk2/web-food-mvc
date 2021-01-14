package fr.iv.calories.service;

import fr.iv.calories.dao.FoodDao;
import fr.iv.calories.entity.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodDao foodDaoImpl;

    @Override
    @Transactional
    public List <Food> getFoods() {
        List <Food> foods = foodDaoImpl.getFoods();

     return foods;
    }

    @Override
    @Transactional
    public List<String> getExistFoodTypes() {

        return foodDaoImpl.getExistFoodTypes();
    }

    @Override
    @Transactional
    public void saveFood(Food theFood) {
        foodDaoImpl.saveFood(theFood);
    }

    @Override
    @Transactional
    public Food getFood(int foodId) {

        return foodDaoImpl.getFood(foodId);
    }

    @Override
    @Transactional
    public void deleteFood(int foodId) {
        foodDaoImpl.deleteFood(foodId);
    }

    @Override
    @Transactional
    public List<Food> searchFoods(String partFoodName) {

        return foodDaoImpl.searchFoods(partFoodName);
    }

}
