package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Application extends JFrame{

    private PolygonDrawer contentPane;
    private JMenu menu_Polygon;
    private JMenu menu_Edit;
    private JMenuItem item_Reset;
    private JMenuItem item_RemoveLast;
    private JMenuBar menuBar;
    private Model model;

    public Application() {
        setTitle("Polygon Drawing Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,300);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menu_Polygon = new JMenu("Polygon");
        menuBar.add(menu_Polygon);

        item_Reset = new JMenuItem("Reset");
        item_Reset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        menu_Polygon.add(item_Reset);

        menu_Edit = new JMenu("Edit");
        menuBar.add(menu_Edit);

        item_RemoveLast = new JMenuItem("Remove Last");
        item_RemoveLast.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0));
        menu_Edit.add(item_RemoveLast);

        contentPane = new PolygonDrawer();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);
    }

    public JMenuItem getUndoMenuItem() {return item_RemoveLast;}

    public JMenuItem getResetMenuItem() {return item_Reset;}

    public PolygonDrawer getPolygonDrawer() {return contentPane;}
}
