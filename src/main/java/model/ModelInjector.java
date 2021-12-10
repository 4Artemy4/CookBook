package model;

/**
 * @author artrayme
 * 12/5/21
 */
public class ModelInjector {
    private static DishDatabase dishDatabase = new DishDatabase();

    public static DishDatabase getDishDatabase() {
        return dishDatabase;
    }

}
