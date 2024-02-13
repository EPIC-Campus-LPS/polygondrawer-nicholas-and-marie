package controller;

import model.Model;
import view.Application;
import controller.UpdateMenu;

public class CompletePolygonController {
    final Model model;
    final Application app;

    public CompletePolygonController(Application app, Model m){
        this.app = app;
        this.model = m;
    }

    public void complete() {
        model.unselectPolygon();
        UpdateMenu.updateMenu(app, model);
        app.repaint();
    }
}
