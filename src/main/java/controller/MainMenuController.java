package controller;

import model.DishDatabase;

/**
 * @author artrayme
 * 12/5/21
 */
public class MainMenuController {
    private final DishDatabase database;

    public MainMenuController(DishDatabase database) {
        this.database = database;
    }


    public DishDatabase getDatabase() {
        return database;
    }
}
