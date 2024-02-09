package model;

import java.awt.Polygon;
import java.util.*;

/**
 *
 */
public class Model {

    // Keep track of number of polygons
    ArrayList<Polygon> list = new ArrayList<>();

    // Currently selected polygon
    Polygon current = null;

    /**
     * Returns polygons in the model
     *
     * @return next polygon
     */
    public Iterator<Polygon> iterator() {
        return list.iterator();
    }

    /**
     * Returns total number of polygons
     *
     * @return number of polygons
     */
    public int size() {
        return list.size();
    }

    /**
     * Clears all polygons
     */
    public void removeAll() {
        list.clear();
        current = null;
    }

    /**
     * Adds polygon
     *
     * @param poly polygon to add to arraylist
     */
    public void addPolygon(Polygon poly) {
            list.add(poly);
    }

    /**
     * Selects a polygon to be current
     *
     * @param poly to be current
     */
    public void makeCurrent(Polygon poly) {
        if (list.contains(poly)) {
            current = poly;
        }
    }

    /**
     * Unselects current polygon
     */
    public void unselectPolygon() {
        current = null;
    }

    /**
     * Returns selected polygon
     *
     * @return selected polygon
     */
    public Optional<Polygon> getSelected() {
        Optional<Polygon> option = Optional.ofNullable(current);
        return option;
    }

    /**
     * Determines if polygon is the current one
     *
     * @param poly to determine if current
     * @return true/false if polygon is current
     */
    public boolean isSelected(Polygon poly) {
        return (poly != null && poly == current);
    }

}
