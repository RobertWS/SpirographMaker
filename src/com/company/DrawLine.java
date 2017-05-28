package com.company;

public class DrawLine{

    public static void main(String[] args) {
        CreateGUI gui = new CreateGUI();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                gui.createAndShowGUI();
            }
        });
    }
}
