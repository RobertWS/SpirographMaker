package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateGUI {

    public void createAndShowGUI() {

        JFrame frame = new JFrame("Spirograph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,350);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public static void addComponentsToPane(Container pane) {
        pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);

        JLabel outerLab = new JLabel("Outer Ring Size: ");
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5,5,5,0);
        pane.add(outerLab, c);

        JTextField outerTxt = new JTextField();
        c.anchor = GridBagConstraints.WEST;
        c.ipadx = 50;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5,0,5,10);
        pane.add(outerTxt, c);

        JLabel innerLab = new JLabel("Inner Ring Size: ");
        c.anchor = GridBagConstraints.EAST;
        c.ipadx = 0;
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(5,5,5,0);
        pane.add(innerLab, c);

        JTextField innerTxt = new JTextField();
        c.anchor = GridBagConstraints.WEST;
        c.ipadx = 50;
        c.gridx = 3;
        c.gridy = 0;
        c.insets = new Insets(5,0,5,10);
        pane.add(innerTxt, c);

        JLabel offsetLab = new JLabel("Offset: ");
        c.anchor = GridBagConstraints.EAST;
        c.ipadx = 0;
        c.gridx = 4;
        c.gridy = 0;
        c.insets = new Insets(5,5,5,0);
        pane.add(offsetLab, c);

        JTextField offsetTxt = new JTextField();
        c.anchor = GridBagConstraints.WEST;
        c.ipadx = 50;
        c.gridx = 5;
        c.gridy = 0;
        c.insets = new Insets(5,0,5,10);
        pane.add(offsetTxt, c);

        JButton drawBtn = new JButton("Draw");
        c.anchor = GridBagConstraints.EAST;
        c.ipadx = 0;
        c.gridx = 6;
        c.gridy = 0;
        c.insets = new Insets(5,5,5,5);
        pane.add(drawBtn, c);

        MyPanel drawPanel = new MyPanel();
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridwidth = 7;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10,0,5,0);
        pane.add(drawPanel, c);

        drawBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double outerSize = 0;
                double innerSize = 0;
                double offsetSize = 0;

                boolean errorFree = true;
                String message = "";

                try {
                    outerSize = Double.parseDouble(outerTxt.getText());
                    innerSize = Double.parseDouble(innerTxt.getText());
                    offsetSize = Double.parseDouble(offsetTxt.getText());
                } catch(NumberFormatException n) {
                    message += "Please use numbers in all the fields.\n";
                    errorFree = false;
                }

                if (outerSize < innerSize) {
                    message += "Outer size must be larger than Inner size.\n";
                    errorFree = false;
                }

                if (outerSize > 50) {
                    message += "Outer size must be less than 50.";
                    errorFree = false;
                }

                drawPanel.setR0(outerSize);
                drawPanel.setR1(innerSize);
                drawPanel.setOffset(offsetSize);

                if (errorFree == true) {
                    drawPanel.repaint();
                } else {
                    JOptionPane.showMessageDialog(pane,message,"Error Present", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
