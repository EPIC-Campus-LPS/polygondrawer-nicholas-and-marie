package controller;

import model.Model;
import view.Application;

/**
 * Controls the Reset Function
 */
public class ResetController {

    final Model model;
    final Application app;

    public ResetController(Application app, Model m) {

        this.app = app;
        this.model = m;

    }

    /**
     * Resets the display
     */
    public void reset() {

        model.removeAll();

        UpdateMenu.updateMenu(app, model);
        app.repaint();

    }

}
