package fr.iv.calories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;

@Repository
public class FoodDaoImpl implements FoodDao{

    @Autowired
    private SessionFactory sessionFactory;
}
