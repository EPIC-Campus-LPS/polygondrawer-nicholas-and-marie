package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Application extends JFrame{

    private JPanel contentPane;
    private JMenu Polygon;
    private JMenu Edit;
    private JMenuItem Reset;
    private JMenuItem Undo;
    private JMenuBar menuBar;

    public Application() {
        setTitle("Polygon Drawing Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,300);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnPolygon = new JMenu("Polygon");
        menuBar.add(mnPolygon);

        JMenuItem mniReset = new JMenuItem("Reset");
        mnPolygon.add(mniReset);

        JMenu mnEdit = new JMenu("Edit");
        menuBar.add(mnEdit);

        JMenuItem mniUndo = new JMenuItem("Remove Last");
        mnEdit.add(mniUndo);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);
    }
}
