import model.Model;
import view.Application;

import java.awt.EventQueue;
public class Main {
    public static void main(String[] args) {
        Model m = new Model();

        Application frame = new Application();
        frame.setVisible(true);
    }
}