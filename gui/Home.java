package org.rps.gui;

import javax.swing.*;

public class Home {
    JFrame jFrame;
    private JTextField textField1;

    public Home() {

        setJframe();
    }

    public void setJframe() {
        this.jFrame = new JFrame("Tas Kagit Makas");
        jFrame.setSize(900, 450);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);

        SwingUtilities.updateComponentTreeUI(jFrame);

        textField1.setVisible(true);
    }
}
