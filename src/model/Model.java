package model;

import java.awt.Polygon;
import java.util.*;

public class Model {

    // Keep track of number of polygons
    ArrayList<Polygon> list = new ArrayList<>();

    // Currently selected polygon
    Polygon current = null;

    // Return polygons in the model
    public Iterator<Polygon> iterator() {
        return list.iterator();
    }

    // Returns total number of polygons
    public int size() {
        return list.size();
    }

    // Clear all polygons in a model
    public void removeAll() {
        list.clear();
        current = null;
    }

    // Add polygon
    public void addPolygon(Polygon poly) {
            list.add(poly);
    }

    // Select polygon to be current, if already exists
    public void makeCurrent(Polygon poly) {
        if (list.contains(poly)) {
            current = poly;
        }
    }

    // Unselect current polygon, if one had been selected
    public void unselectPolygon() {
        current = null;
    }

    // Return selected polygon
    public Optional<Polygon> getSelected() {
        Optional<Polygon> option = Optional.ofNullable(current);
        return option;
    }

    // Determine if polygon is the current one
    public boolean isSelected(Polygon poly) {
        return (poly != null && poly == current);
    }

}
