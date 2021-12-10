import model.Dish;
import model.DishDatabase;
import model.ModelInjector;
import view.MainMenu;
import view.ViewInjector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.time.LocalTime;

/**
 * @author artrayme
 * 12/5/21
 */
public class Main {
    public static void main(String[] args) {
        Dish tempDish = new Dish("Kurt");

        tempDish.setAdditional("qwe");
        tempDish.addIngredients("first");
        tempDish.addIngredients("second");
        tempDish.addIngredients("abc");
        tempDish.setCookingTime(LocalTime.now());
        tempDish.setType("Cheese");
        tempDish.setCuisine("Uzbekistan");
        tempDish.setCommonInformation("Очень вкусно");


        Dish otherDish = new Dish("Borsch");
        otherDish.setCuisine("Slavs");
        otherDish.setType("Sup");
        otherDish.setCommonInformation("aaaa");
        otherDish.setCookingTime(LocalTime.now());

        DishDatabase database = ModelInjector.getDishDatabase();
        database.addDish(tempDish);
        database.addDish(otherDish);


        MainMenu dishView = ViewInjector.getMainMenu();
        JFrame f = new JFrame("Main");
        f.getContentPane().add(dishView);
        f.setSize(800, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.dispose();
        f.setVisible(true);

        JOptionPane.showMessageDialog(f,
                "Вы ввели неправильный логин или пароль",
                "Ошибка авторизации",
                JOptionPane.ERROR_MESSAGE);
    }
}
