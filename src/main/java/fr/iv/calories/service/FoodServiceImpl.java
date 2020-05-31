package fr.iv.calories.service;

import fr.iv.calories.dao.FoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodDao foodDaoImpl;
}
