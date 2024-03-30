/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phoenix.simulationengine.Sketch;

import com.phoenix.simulationengine.Shapes.Circle;
import com.phoenix.simulationengine.util.Main;
import com.phoenix.simulationengine.util.Sketch;
import com.phoenix.simulationengine.util.Vector;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author BLACKBOX
 */
public class MoveCircle implements Sketch {

    Circle c;

    @Override
    public void setup(JPanel frame) {
        c = new Circle(new Vector((frame.getWidth() / 2)-20, frame.getHeight() - 40), 20, Color.CYAN);
        frame.add(c);
    }

    @Override
    public void update(JPanel frame) {

        c.update();
    }
}
