package view;

import controller.CreateDishController;

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
public class CreateDishView extends JPanel {
    private final CreateDishController controller;
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

    private final JButton createButton = new JButton("Создать");

    public CreateDishView(CreateDishController controller) {
        this.controller = controller;
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

        createButton.addActionListener(e -> {
            controller.createDish(addName(),
                    addCommonInformation(),
                    addCousin(),
                    addType(),
                    addCookingTime(),
                    addIngredients(),
                    addSteps(),
                    addAdditionalInformation()
            );

        });

        add(createButton, BorderLayout.SOUTH);

        SpringUtilities.makeCompactGrid(infoPanel,
                8, 2,
                3, 3,  //initX, initY
                3, 3); //xPad, yPad

    }

    private String addName() {
        return dishNameField.getText();
    }

    private String addAdditionalInformation() {
        return dishAdditionalField.getText();
    }

    private String[] addSteps() {
        return dishStepsField.getText().split(",");
    }

    private String[] addIngredients() {
        return dishIngredientField.getText().split(",");
    }

    private LocalTime addCookingTime() {
        return LocalTime.parse(dishCookingTimeField.getText());
    }

    private String addType() {
        return dishTypeField.getText();
    }

    public String addCommonInformation(){
        return dishCommonInfoField.getText();
    }

    public String addCousin(){
        return dishCousinField.getText();
    }

}
