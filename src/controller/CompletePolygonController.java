package controller;

import model.Model;
import view.Application;
import controller.UpdateMenu;

/**
 * Controller for assigning a polygon as complete
 */
public class CompletePolygonController {
    final Model model;
    final Application app;

    public CompletePolygonController(Application app, Model m){
        this.app = app;
        this.model = m;
    }

    /**
     * Marks a polygon as complete and unselects it
     */
    public void complete() {
        model.unselectPolygon();
        UpdateMenu.updateMenu(app, model);
        app.repaint();
    }
}
