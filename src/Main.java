import controller.QuitController;
import model.Model;
import view.Application;

import controller.UpdateMenu;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) {

        Model m = new Model();

        final Application frame = new Application();
        UpdateMenu.updateMenu(frame, m);

        // Disposing the window will complete the application
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (new QuitController().confirm(frame)) {
                    frame.dispose();
                }
            }
        });

        frame.setVisible(true);

    }

}