package controller;

import model.Model;
import view.Application;

import java.awt.*;
import java.util.Iterator;
import java.util.Optional;

/**
 * Controller for the Undo Function
 */
public class UndoController {
    final Model model;
    final Application app;
    public UndoController(Application app, Model m){
        this.app = app;
        this.model = m;
    }

    /**
     * Removes the point that was most recently made on the display
     */
    public void removeLastPoint(){
        Optional<Polygon> selected = model.getSelected();
        if(selected.isPresent()){
            Polygon poly = selected.get();
            if(poly.npoints > 0){
                poly.npoints--;
            }
        }else{
            Iterator<Polygon> it = model.iterator();
            while (it.hasNext()){
                it.next();
                if(!it.hasNext()){
                    it.remove();
                    break;
                }
            }
        }

        UpdateMenu.updateMenu(app, model);
        app.repaint();
    }
}
