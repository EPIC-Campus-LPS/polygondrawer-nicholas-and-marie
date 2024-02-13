package controller;

import model.Model;
import view.Application;

public class UpdateMenu {

    /**
     * Updates the menu based on the state of the model
     *
     * @param app the view portion of M-V-C
     * @param model the model portion of M-V-C
     */
    public static void updateMenu(Application app, Model model) {

        if(model.size() == 0) {

            app.getResetMenuItem().setEnabled(false);
            app.getUndoMenuItem().setEnabled(false);
            app.getUndoMenuItem().setText("Remove");

        } else {

            app.getResetMenuItem().setEnabled(true);
            app.getUndoMenuItem().setEnabled(true);

            if (model.getSelected().isPresent()) {

                app.getUndoMenuItem().setText("Remove Last Point");

            } else {

                app.getUndoMenuItem().setText("Remove Last Polygon");

            }

        }

    }

}
