package view;

import controller.DishViewController;
import controller.EditDishController;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.List;

/**
 * @author artrayme
 * 12/5/21
 */
public class DishView extends JPanel {
    private final DishViewController controller;
    private final JPanel dishInfo;
    private final JPanel instrumentationPanel;

    public DishView(DishViewController controller) {
        this.controller = controller;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        dishInfo = new JPanel();
        dishInfo.setLayout(new BoxLayout(dishInfo, BoxLayout.Y_AXIS));
        add(dishInfo);
        instrumentationPanel = new JPanel(new GridLayout(1, 2));
        instrumentationPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(instrumentationPanel);
        initComponents();
    }

    private void initComponents() {

        JButton editDish = new JButton("Редактировать блюдо");
        editDish.addActionListener(e -> {
            JDialog frame = new JDialog();
            frame.setTitle(controller.getDishName());
            frame.getContentPane().add(new EditDishView(new EditDishController(controller.getDish())));
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        JButton removeDish = new JButton("Удалить блюдо");
        removeDish.addActionListener(e -> {
            controller.removeDish();
            JDialog topFrame = (JDialog) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
        });
        dishInfo.add(editDish);
        dishInfo.add(removeDish);

        dishInfo.add(new Label("Общая Информация: " + controller.getCommonInformation()));
        dishInfo.add(new Label("Принадлженость к типу блюда: " + controller.getType()));
        dishInfo.add(new Label("Принадлженость к кухне: " + controller.getCuisine()));
        dishInfo.add(new Label("Время приготовления: " + controller.getCookingTime()));

        JPanel recipePanel = new JPanel();
        recipePanel.setLayout(new BoxLayout(recipePanel, BoxLayout.Y_AXIS));
        recipePanel.add(new JLabel("Рецепт"));
        recipePanel.add(new JLabel("Список ингридиентов"));
        List<String> ingredients = controller.getIngredients();
        for (int i = 0; i < ingredients.size(); i++) {
            String ingredient = ingredients.get(i);
            recipePanel.add(new JLabel(i + 1 + ") " + ingredient));
        }
        recipePanel.add(new JLabel("Шаги приготовления:"));
        List<String> instruction = controller.getInstruction();
        for (int i = 0; i < instruction.size(); i++) {
            String intsr = instruction.get(i);
            recipePanel.add(new JLabel(i + 1 + ") " + intsr));
        }
        instrumentationPanel.add(recipePanel);
        stopWatchSetting();

    }

    public void stopWatchSetting() {
        StopWatchPanel watchPanel = new StopWatchPanel();
        watchPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        instrumentationPanel.add(watchPanel);
    }




}
