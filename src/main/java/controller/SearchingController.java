package controller;

import model.Dish;
import model.DishDatabase;

import java.util.List;
import java.util.Objects;

/**
 * @author artrayme
 * 12/7/21
 */
public class SearchingController {
    private final DishDatabase database;

    public SearchingController(DishDatabase database) {
        this.database = database;
    }

    public List<Dish> getByType(String type) {
        return database.getDishes().stream().filter(e -> Objects.equals(e.getType(), type)).toList();
    }

    public List<Dish> getByCousin(String cousin) {
        return database.getDishes().stream().filter(e -> Objects.equals(e.getCuisine(), cousin)).toList();
    }

    public DishDatabase getDatabase() {
        return database;
    }
}
