package com.phoenix.simulationengine.Sketch;

import com.phoenix.simulationengine.Shapes.Vehical;
import com.phoenix.simulationengine.util.Sketch;
import com.phoenix.simulationengine.util.Vector;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Steering implements Sketch {

    Vehical v;
    Point p = new Point(0, 0);

    @Override
    public void setup(JPanel frame) {
        v = new Vehical(new Vector(100, 100)); // Initialize the vehicle at position (100, 100)
        frame.add(v); // Add the vehicle to the frame
    }

    @Override
    public void update(JPanel frame) {
        v.seek((int) p.getX(), (int) p.getY());
        v.update(p);
    }

    // Set the mouse position
    public void setMousePosition(Point p) {
        this.p = p;
    }

}
