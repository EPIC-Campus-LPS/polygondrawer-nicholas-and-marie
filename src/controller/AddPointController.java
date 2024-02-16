package controller;

import model.Model;
import view.Application;
import controller.UpdateMenu;

import java.awt.*;
import java.util.Optional;

/**
 * Controller for adding points
 */
public class AddPointController {
    final Model model;
    final Application app;
    public AddPointController(Application app, Model m){
        this.app = app;
        this.model = m;
    }

    /**
     * Adds a point to the display
     * @param p data for the point, including position
     */
    public void addPoint(Point p){
        Optional<Polygon> selected = model.getSelected();
        if(!selected.isPresent()){
            Polygon poly = new Polygon();
            poly.addPoint(p.x, p.y);

            model.addPolygon(poly);
            model.makeCurrent(poly);
        }else {
            selected.get().addPoint(p.x, p.y);
        }

        UpdateMenu.updateMenu(app, model);
        app.repaint();
    }
}
