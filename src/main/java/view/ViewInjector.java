package view;

import controller.ControllerInjector;

/**
 * @author artrayme
 * 12/7/21
 */
public class ViewInjector {
    private static final MainMenu menu = new MainMenu(ControllerInjector.getMainMenuController());

    public static MainMenu getMainMenu() {
        return menu;
    }
}
