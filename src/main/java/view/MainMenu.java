package view;

import controller.AuthenticationController;
import controller.CreateDishController;
import controller.DishViewController;
import controller.MainMenuController;
import controller.SearchingController;
import model.Dish;
import model.ModelInjector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Arrays;

/**
 * @author artrayme
 * 12/5/21
 */
public class MainMenu extends JPanel {
    private final MainMenuController controller;
    private final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    private final JList<Dish> dishesList = new JList<>();
    private final JPanel menus = new JPanel(new GridLayout(5, 1));
    boolean flag = false;

    public MainMenu(MainMenuController controller) {
        super(new BorderLayout());

        this.controller = controller;

        splitPane.setResizeWeight(0.5);
        splitPane.setOneTouchExpandable(true);
        splitPane.setContinuousLayout(true);

        JButton addDishButton = new JButton("Добавить блюдо");
        addDishButton.addActionListener(e -> {
            openDishCreatingWindow();
        });
        menus.add(addDishButton);
        //        menus.add(new JButton("Редактировать блюдо"));
        //        menus.add(new JButton("Удалить блюдо"));
        JButton filter = new JButton("Фильтры списка");
        filter.addActionListener(e -> {
            openFunctionsMenu();
        });
        menus.add(filter);

        JButton authButton = new JButton("Авторизация");
        authButton.addActionListener(e -> {
            openAuthWindow();
        });
        menus.add(authButton);

        DefaultListModel<Dish> model = new DefaultListModel<>();
        model.addAll(controller.getDatabase().getDishes());
        dishesList.setModel(model);
        JButton updateList = new JButton("Обновить");
        updateList.addActionListener(e -> {
            updateDishesList(controller, model);
        });
        menus.add(updateList);
        dishesList.addListSelectionListener(e -> {
            openDishView(e);
        });

        splitPane.add(menus);
        splitPane.add(dishesList);

        add(splitPane, BorderLayout.CENTER);
    }

    private void openDishCreatingWindow() {
        JDialog frame = new JDialog();
        frame.setTitle("Добавление блюда");
        frame.getContentPane().add(new CreateDishView(new CreateDishController(ModelInjector.getDishDatabase())));
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void openDishView(ListSelectionEvent e) {
        if (!flag) {
            JDialog frame = new JDialog();
            JList<Dish> source = (JList<Dish>) e.getSource();
            frame.setTitle(source.getSelectedValue().toString());
            frame.getContentPane().add(new DishView(new DishViewController(source.getSelectedValue())));
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }

    private void updateDishesList(MainMenuController controller, DefaultListModel<Dish> model) {
        flag = true;
        model.clear();
        model.addAll(controller.getDatabase().getDishes());
        System.out.println(Arrays.toString(model.toArray()));
        dishesList.updateUI();
        flag = false;
    }

    private void openAuthWindow() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        AuthorizationView authorizationView = new AuthorizationView(topFrame, new AuthenticationController());
        authorizationView.setVisible(true);
    }

    public void openFunctionsMenu() {
        JDialog frame = new JDialog();
        frame.setTitle("Фильтр списка блюд");
        frame.getContentPane().add(new SearchingView(new SearchingController(ModelInjector.getDishDatabase())));
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
