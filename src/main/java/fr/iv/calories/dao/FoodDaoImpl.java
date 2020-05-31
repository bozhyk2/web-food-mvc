package fr.iv.calories.dao;

import fr.iv.calories.entity.Food;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;

import java.util.List;

@Repository
public class FoodDaoImpl implements FoodDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Food> getFoods() {
        Session session = sessionFactory.getCurrentSession();
        List <Food> foods = session
                            .createQuery(
                       "FROM Food f "
                               +"ORDER BY f.type,"
                                       +" f.name",
                                    Food.class)
                            .getResultList();
     return foods;
    }

    @Override
    public List<String> getExistFoodTypes() {

        Session session = sessionFactory.getCurrentSession();

        String sqlQuery = "SELECT DISTINCT f.type " +
                          "FROM Food f " +
                          "ORDER BY f.type";

        Query<String> typeOfFood = session.createQuery(sqlQuery, String.class);

        List<String> types = typeOfFood.getResultList();

        return types;
    }
}
