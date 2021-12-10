package view;

import controller.DishViewController;
import controller.SearchingController;
import model.Dish;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.TextField;
import java.util.List;

/**
 * @author artrayme
 * 12/7/21
 */
public class SearchingView extends JPanel {
    private final SearchingController controller;

    private final JPanel infoPanel = new JPanel();
    private final JPanel checkboxesPanel = new JPanel();
    private final JPanel dataPanel = new JPanel();

    private final TextField dishType = new TextField();
    private final TextField cousin = new TextField();


    public SearchingView(SearchingController controller) {
        this.controller = controller;

        this.setLayout(new BorderLayout());
        infoPanel.setLayout(new SpringLayout());
        add(infoPanel, BorderLayout.CENTER);
        add(new JLabel("По какому критерию вы хотет отфильтровать список?"), BorderLayout.NORTH);

        checkboxesPanel.setLayout(new BoxLayout(checkboxesPanel, BoxLayout.Y_AXIS));
        checkboxesPanel.add(new Checkbox("Любимые блюда"));
        checkboxesPanel.add(new Checkbox("Авторские блюда"));
        infoPanel.add(checkboxesPanel);

        JLabel dishTypeLabel = new JLabel("По типу блюда");
        JLabel dishCousinLabel = new JLabel("Относится к кухне");

        dishTypeLabel.setLabelFor(dishType);
        dishCousinLabel.setLabelFor(cousin);

        dataPanel.setLayout(new SpringLayout());

        dataPanel.add(dishTypeLabel);
        dataPanel.add(dishType);

        dataPanel.add(dishCousinLabel);
        dataPanel.add(cousin);

        infoPanel.add(dataPanel);

        JButton getResultsButton = new JButton("Показать результаты");
        getResultsButton.addActionListener(e -> {
            JList<Dish> dishesList = new JList<>();
            DefaultListModel<Dish> model = new DefaultListModel<>();
            if (!cousin.getText().isEmpty()) {
                model.addAll(filterByCousin());
            }
            if (!dishType.getText().isEmpty()) {
                model.addAll(filterByType());
            }
            dishesList.addListSelectionListener(k -> {
                JDialog frame = new JDialog();
                var source = ((JList<Dish>) k.getSource()).getSelectedValue();
                frame.setTitle(source.toString());
                frame.getContentPane().add(new DishView(new DishViewController(source)));
                frame.setSize(800, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            });
            dishesList.setModel(model);
            JDialog dialog = new JDialog();
            dialog.add(dishesList);
            dialog.setSize(new Dimension(300, 600));
            dialog.setVisible(true);
        });
        add(getResultsButton, BorderLayout.SOUTH);

        SpringUtilities.makeCompactGrid(infoPanel,
                2, 1,
                3, 3,  //initX, initY
                3, 3); //xPad, yPad
        SpringUtilities.makeCompactGrid(dataPanel,
                2, 2,
                3, 3,  //initX, initY
                3, 3); //xPad, yPad
    }

    public List<Dish> filterByCousin(){
        return controller.getByCousin(cousin.getText());
    }

    public List<Dish> filterByType(){
        return controller.getByType(dishType.getText());
    }

    public List<Dish> displayFavoriteDishes(){
        return null;
    }

    public List<Dish> displayUsersDishes(){
        return null;
    }

}
