package view;

import controller.AddPointController;
import controller.CompletePolygonController;
import controller.ResetController;
import model.Model;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Application extends JFrame{

    private JPanel contentPane;
    private JMenu menu_Polygon;
    private JMenu menu_Edit;
    private JMenuItem item_Reset;
    private JMenuItem item_RemoveLast;
    private JMenuBar menuBar;
    private Model model;

    /**
     * Main Application Class
     * @param m input model
     */
    public Application(Model m) {
        super();
        this.model = m;

        setTitle("Polygon Drawing Application");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100,100,450,300);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menu_Polygon = new JMenu("Polygon");
        menuBar.add(menu_Polygon);

        item_Reset = new JMenuItem("Reset");
        item_Reset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        menu_Polygon.add(item_Reset);
        item_Reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ResetController(Application.this, model).reset();
            }

        });

        menu_Edit = new JMenu("Edit");
        menuBar.add(menu_Edit);

        item_RemoveLast = new JMenuItem("Remove Last");
        item_RemoveLast.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
        menu_Edit.add(item_RemoveLast);

        contentPane = new PolygonDrawer(model);

        contentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(SwingUtilities.isRightMouseButton(e)) {
                    new CompletePolygonController(Application.this, model).complete();
                }else {
                    new AddPointController(Application.this, model).addPoint(e.getPoint());
                }
            }
        });

        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        Color purple = new Color(130,0,220);
        contentPane.setBackground(purple);
        contentPane.getColorModel();
        setContentPane(contentPane);
    }

    /**
     * Application class for Window Builder
     */
    public Application(){
        this(new Model());
    }

    /**
     * Gets the undo item
     * @return undo item
     */
    public JMenuItem getUndoMenuItem() {return item_RemoveLast;}

    /**
     * Gets the reset item
     * @return reset item
     */
    public JMenuItem getResetMenuItem() {return item_Reset;}

    /**
     * Gets the Polygon Drawer
     * @return The Polygon Drawer, named Content Pane
     */
    public JPanel getPolygonDrawer() {return contentPane;}
}
