package com.phoenix.simulationengine.Shapes;

import com.phoenix.simulationengine.util.Vector;

import javax.swing.*;
import java.awt.*;

public class Vehical extends JComponent {

    Vector pos;
    Vector acc = new Vector(0, 0);
    Vector vel = new Vector(0, 0);
    Vector steering;

    public Vehical(Vector position) {
        this.pos = position;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[] x = {(int) pos.x, (int) pos.x + 30, (int) (pos.x + 30 / 2)};
        int[] y = {(int) pos.y, (int) pos.y, (int) (pos.y - 30)};

        g.fillPolygon(x, y, 3);
    }

    public void update(Point p) {

        vel.add(acc);
        pos.add(vel);
        acc.set(0, 0);

        Vector friction = steering.copy();
        friction.mult(-0.3);
        applyForce(friction);

        repaint();
    }

    public void seek(int x, int y) {
        Vector target = new Vector(x, y);
        Vector desired = Vector.sub(target, pos);
        desired.setMag(4);
        steering = Vector.sub(desired, vel);
        steering.limit(0.2);
        applyForce(steering);

    }

    public void applyForce(Vector v) {
        acc.add(v);
    }
}
