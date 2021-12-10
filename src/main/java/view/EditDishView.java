package view;

import controller.EditDishController;
import model.Dish;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import java.awt.BorderLayout;
import java.awt.TextField;
import java.time.LocalTime;

/**
 * @author artrayme
 * 12/7/21
 */
public class EditDishView extends JPanel {
    private final EditDishController controller;
    private final JPanel infoPanel = new JPanel();

    private final JLabel dishNameLabel = new JLabel("Введите название блюда: ");
    private final JLabel dishCommonInfoLabel = new JLabel("Введите общую информацию о блюдей");
    private final JLabel dishCousinLabel = new JLabel("Задайте принадлежност к той или иной кухне");
    private final JLabel dishTypeLabel = new JLabel("Задайте принадлежность к тому или иному блюду");
    private final JLabel dishCookingTimeLabel = new JLabel("Введите ориентировочное время приготовления");
    private final JLabel dishIngredientLabel = new JLabel("Введите список ингридиентов");
    private final JLabel dishStepsLabel = new JLabel("Введите шаги приготовления");
    private final JLabel dishAdditionalLabel = new JLabel("Введите дополнительные советы");

    private final TextField dishNameField = new TextField();
    private final TextField dishCommonInfoField = new TextField();
    private final TextField dishCousinField = new TextField();
    private final TextField dishTypeField = new TextField();
    private final TextField dishCookingTimeField = new TextField();
    private final TextField dishIngredientField = new TextField();
    private final TextField dishStepsField = new TextField();
    private final TextField dishAdditionalField = new TextField();

    private final JButton save = new JButton("Сохранить");

    public EditDishView(EditDishController controller) {
        this.controller = controller;
        Dish thisDish = controller.getCurrentDish();

        dishNameField.setText(thisDish.getName());

        if (thisDish.getCommonInformation() != null) {
            dishCommonInfoField.setText(thisDish.getCommonInformation());
        }

        if (thisDish.getCuisine() != null) {
            dishCousinField.setText(thisDish.getCuisine());
        }

        if (thisDish.getAdditional() != null) {
            dishAdditionalField.setText(thisDish.getAdditional());
        }

        if (thisDish.getType() != null) {
            dishTypeField.setText(thisDish.getType());
        }

        StringBuilder ingredients = new StringBuilder();
        for (String ingredient : thisDish.getIngredients()) {
            ingredients.append(ingredient).append(',');
        }

        dishIngredientField.setText(ingredients.toString());

        StringBuilder steps = new StringBuilder();
        for (String instruction : thisDish.getInstructions()) {
            steps.append(instruction).append(',');
        }
        dishStepsField.setText(steps.toString());

        dishCookingTimeField.setText(thisDish.getCookingTime().toString());

        this.setLayout(new BorderLayout());
        infoPanel.setLayout(new SpringLayout());
        add(infoPanel, BorderLayout.CENTER);

        infoPanel.add(dishNameLabel);
        dishNameLabel.setLabelFor(dishNameField);
        infoPanel.add(dishNameField);

        infoPanel.add(dishAdditionalLabel);
        dishAdditionalLabel.setLabelFor(dishAdditionalField);
        infoPanel.add(dishAdditionalField);

        infoPanel.add(dishStepsLabel);
        dishStepsLabel.setLabelFor(dishStepsField);
        infoPanel.add(dishStepsField);

        infoPanel.add(dishIngredientLabel);
        dishIngredientLabel.setLabelFor(dishIngredientField);
        infoPanel.add(dishIngredientField);

        infoPanel.add(dishCookingTimeLabel);
        dishCookingTimeLabel.setLabelFor(dishCookingTimeField);
        infoPanel.add(dishCookingTimeField);

        infoPanel.add(dishTypeLabel);
        dishTypeLabel.setLabelFor(dishTypeField);
        infoPanel.add(dishTypeField);

        infoPanel.add(dishCommonInfoLabel);
        dishCommonInfoLabel.setLabelFor(dishCommonInfoField);
        infoPanel.add(dishCommonInfoField);

        infoPanel.add(dishCousinLabel);
        dishCousinLabel.setLabelFor(dishCousinField);
        infoPanel.add(dishCousinField);

        save.addActionListener(e -> {
            changeAdditionalInfor(thisDish);
            changeCommonInfo(thisDish);
            changeCousin(thisDish);
            changeType(thisDish);
            changeName(thisDish);
            LocalTime time = LocalTime.parse(dishCookingTimeField.getText());
            changeCookingTime(thisDish, time);
            changeIngredients(thisDish);
            changeSteps(thisDish);
        });

        add(save, BorderLayout.SOUTH);

        SpringUtilities.makeCompactGrid(infoPanel,
                8, 2,
                3, 3,  //initX, initY
                3, 3); //xPad, yPad

    }

    public void changeSteps(Dish thisDish) {
        String[] stps = dishStepsField.getText().split(",");
        thisDish.getInstructions().clear();
        for (String stp : stps) {
            thisDish.addInstruction(stp);
        }
    }

    public void changeIngredients(Dish thisDish) {
        thisDish.getIngredients().clear();
        String[] ingr = dishIngredientField.getText().split(",");
        for (String s : ingr) {
            thisDish.addIngredients(s);
        }
    }

    public void changeCookingTime(Dish thisDish, LocalTime time) {
        thisDish.setCookingTime(time);
    }

    public void changeName(Dish thisDish) {
        thisDish.setName(dishNameField.getText());
    }

    public void changeType(Dish thisDish) {
        thisDish.setType(dishTypeField.getText());
    }

    public void changeCousin(Dish thisDish) {
        thisDish.setCuisine(dishCousinField.getText());
    }

    public void changeCommonInfo(Dish thisDish) {
        thisDish.setCommonInformation(dishCommonInfoField.getText());
    }

    public void changeAdditionalInfor(Dish thisDish) {
        thisDish.setAdditional(dishAdditionalField.getText());
    }
}
