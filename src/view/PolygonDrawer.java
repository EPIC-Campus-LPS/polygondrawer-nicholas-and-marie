package view;

import javax.swing.*;
import model.Model;

import java.awt.*;
import java.util.Iterator;

public class PolygonDrawer extends JPanel {
    public static final int Radius = 2;
    private Model model;

    /**
     * The actual application which draws apps
     * @param m input model
     */
    public PolygonDrawer(Model m) {
        this.model = m;
    }

    /**
     * Draws the circles around points and lines between points
     * @param g Input graphics, which only goes into super()
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Iterator<Polygon> it = model.iterator();
        while (it.hasNext()){
            Polygon poly = it.next();

            g.setColor(new Color(229,63,113));
            if (model.isSelected(poly)) {
                g.setColor(new Color(248,159,91));
            }

            if(poly.npoints >= 3){
                for (int i = 0; i < poly.npoints-1; i++){
                    g.drawLine(poly.xpoints[i], poly.ypoints[i], poly.xpoints[i+1], poly.ypoints[i+1]);
                }
                g.drawLine(poly.xpoints[poly.npoints-1], poly.ypoints[poly.npoints-1], poly.xpoints[0], poly.ypoints[0]);
            } else {
                for (int i = 0; i < poly.npoints; i++){
                    g.drawOval(poly.xpoints[i]-Radius, poly.ypoints[i]-Radius, 2*Radius, 2* Radius);
                }
            }
        }
    }
}
