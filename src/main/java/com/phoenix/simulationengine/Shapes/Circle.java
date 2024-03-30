package com.phoenix.simulationengine.Shapes;

import com.phoenix.simulationengine.util.Vector;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Circle extends JComponent {

    public double r;
    public Color c;

    int i = 0;
    int in = 0;
    double speed = 2;
    public Vector position;
    public Vector velocity[] = new Vector[2000];

    public Circle(Vector position, double r, Color c) {
        Random random = new Random();

        for (int i = 0; i < 400; i++) {
            velocity[i] = new Vector((random.nextInt(3) - 1) * speed, (random.nextInt(3) - 1) * speed);
        }
        this.r = r;
        this.c = c;
        this.position = position;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(c);
        g.fillOval((int) position.x, (int) position.y, (int) r * 2, (int) r * 2);
    }

    public void update() {
        position.add(velocity[i]);
        if (in == 30) {
            if (i != 399) {
                i++;
            }
            in = 0;
        }
        in++;
        repaint();
    }

}
