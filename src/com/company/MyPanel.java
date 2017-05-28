package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by robert on 11/03/2017.
 */
class MyPanel extends JPanel {

    private double R0 = 0;
    private double R1 = 0;
    private double Offset = 0;

    public void setR0(double r0) {
        R0 = r0;
    }

    public void setR1(double r1) {
        R1 = r1;
    }

    public void setOffset(double offset) {
        Offset = offset;
    }

    public MyPanel() {
    }

    public Dimension getPreferredSize() {
        return new Dimension(300,300);
    }

    public void paint(Graphics graphics) {
        super.paintComponent(graphics);
        setBackground(Color.WHITE);
        setOpaque(true);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        for (int i = 1; i <= 360; i++) {
            double x1 = (R0 + R1) * Math.cos(i) - (R1 + Offset) * Math.cos(((R0 + R1) / R1) * i) + 150;
            double y1 = (R0 + R1) * Math.sin(i) - (R1 + Offset) * Math.sin(((R0 + R1) / R1) * i) + 150;
            double x2 = (R0 + R1) * Math.cos(i + 1) - (R1 + Offset) * Math.cos(((R0 + R1) / R1) * i + 1) + 150;
            double y2 = (R0 + R1) * Math.sin(i + 1) - (R1 + Offset) * Math.sin(((R0 + R1) / R1) * i + 1) + 150;

            Line2D line2D = new Line2D.Double(x1, y1, x2, y2);
            graphics2D.setColor(Color.RED);
            graphics2D.draw(line2D);
        }
    }
}
