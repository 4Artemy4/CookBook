package controller;

import model.Dish;
import model.ModelInjector;

import java.util.List;

/**
 * @author artrayme
 * 12/5/21
 */
public class DishViewController {
    protected Dish dish;

    public DishViewController(Dish dish) {
        this.dish = dish;
    }

    public Dish getDish() {
        return dish;
    }

    public String getCommonInformation() {
        return dish.getCommonInformation();
    }


    public String getCuisine() {
        return dish.getCuisine();
    }


    public String getType() {
        return dish.getType();
    }


    public String getCookingTime() {
        return dish.getCookingTime().toString();
    }


    public List<String> getIngredients() {
        return dish.getIngredients();
    }

    public List<String> getInstruction() {
        return dish.getInstructions();
    }

    public String getAdditional() {
        return dish.getAdditional();
    }

    public void removeDish() {
        ModelInjector.getDishDatabase().removeDish(dish);
    }

    public String getDishName() {
        return dish.getName();
    }

}
