package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author artrayme
 * 12/5/21
 */
public class DishDatabase {
    private final List<Dish> dishes = new ArrayList<>();


    public List<Dish> getDishes() {
        return dishes;
    }

    public boolean addDish(Dish dish) {
        return dishes.add(dish);
    }

    public boolean removeDish(Dish dish) {
        return dishes.remove(dish);
    }

}
