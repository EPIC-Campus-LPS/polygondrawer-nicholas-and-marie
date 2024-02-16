package controller;

import view.Application;

import javax.swing.*;

/**
 * Controller for options when quitting the Application
 */
public class QuitController {

    /**
     * Confirms if the user wants to close the app
     * @param app Application being exited out of
     * @return "Do you want to exit" dialog
     */
    public boolean confirm(Application app) {

        return JOptionPane.showConfirmDialog (app, "Do you wish to exit Application?") == JOptionPane.OK_OPTION;

    }

}
