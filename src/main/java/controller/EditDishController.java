package controller;

import model.Dish;

/**
 * @author artrayme
 * 12/7/21
 */
public class EditDishController {
    private final Dish currentDish;

    public EditDishController(Dish currentDish) {
        this.currentDish = currentDish;
    }

    public Dish getCurrentDish() {
        return currentDish;
    }
}
