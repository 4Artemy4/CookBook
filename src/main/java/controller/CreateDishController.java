package controller;

import model.Dish;
import model.DishDatabase;

import java.time.LocalTime;

/**
 * @author artrayme
 * 12/7/21
 */
public class CreateDishController {
    private final DishDatabase database;

    public CreateDishController(DishDatabase database) {
        this.database = database;
    }

    public void createDish(String name, String commonInfo, String cousin, String type, LocalTime cookingTime, String[] ingredients, String[] steps, String additional) {
        Dish dish = new Dish(name);
        dish.setType(type);
        dish.setCuisine(cousin);
        dish.setCookingTime(cookingTime);
        dish.setAdditional(additional);
        dish.setCommonInformation(commonInfo);
        for (String step : steps) {
            dish.addInstruction(step);
        }
        for (String ingredient : ingredients) {
            dish.addIngredients(ingredient);
        }
        database.addDish(dish);
    }
}
