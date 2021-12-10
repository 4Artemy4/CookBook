package controller;

import model.Dish;
import model.DishDatabase;

import java.util.List;

/**
 * @author artrayme
 * 12/5/21
 */
public class DishesListController {
    private final DishDatabase database;


    public DishesListController(DishDatabase database) {
        this.database = database;
    }

    public boolean addDish(Dish dish) {
        return database.addDish(dish);
    }

    public boolean removeDish(Dish dish) {
        return database.removeDish(dish);
    }

    public List<Dish> getAllDishes() {
        return database.getDishes();
    }
}
