package fr.iv.calories.dao;

import fr.iv.calories.entity.Food;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;

import java.util.List;

@Repository
public class FoodDaoImpl implements FoodDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Food> getFoods() {
        Session session = sessionFactory.getCurrentSession();
        String sqlQuery = "FROM Food f " +
                "ORDER BY f.type, f.name";
        List<Food> foods = session.createQuery(sqlQuery, Food.class).getResultList();

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

    @Override
    public void saveFood(Food theFood) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(theFood);
    }

    @Override
    public Food getFood(int foodId) {
        Session session = sessionFactory.getCurrentSession();
        Food theFood = session.get(Food.class, foodId);

        return theFood;
    }

    @Override
    public void deleteFood(int foodId) {
        Session session = sessionFactory.getCurrentSession();
        Food foodForDelete = session.get(Food.class, foodId);
        if (foodForDelete != null) {
            session.delete(foodForDelete);
        }
    }

    @Override
    public List<Food> searchFoods(String partFoodName) {
        if (partFoodName.trim() == null ||
                partFoodName.trim().length() == 0) {

            return getFoods();
        }
        String sqlQuery = "FROM Food f " +
                          "WHERE LOWER(f.name) LIKE :theName " +
                          "OR LOWER(f.type) LIKE :theName " +
                          "ORDER BY f.type, f.name";
        Session session = sessionFactory.getCurrentSession();
        Query<Food> theQuery = session.createQuery(sqlQuery, Food.class);
        theQuery.setParameter("theName", "%" + partFoodName.trim().toLowerCase() + "%");
        List<Food> searchFoods = theQuery.getResultList();

        return searchFoods;
    }

}
