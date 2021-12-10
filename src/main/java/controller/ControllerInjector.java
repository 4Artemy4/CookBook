package controller;

import model.ModelInjector;

/**
 * @author artrayme
 * 12/5/21
 */
public class ControllerInjector {
    private static final MainMenuController mainMenuController = new MainMenuController(ModelInjector.getDishDatabase());
    private static DishesListController dishesListController;

    public ControllerInjector() {
        dishesListController = new DishesListController(ModelInjector.getDishDatabase());
    }

    public static DishesListController getDishesListController() {
        return dishesListController;
    }

    public static MainMenuController getMainMenuController() {
        return mainMenuController;
    }

}
