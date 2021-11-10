package net.technologyrediscovery.example;

import javax.swing.*;
import java.awt.*;

public class ExampleMain
{

    public static void main(String[] args)
    {

        JFrame frame = new JFrame("Example Program");

        frame.setMinimumSize(new Dimension(500, 500));
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        frame.add(new ImageDisplayPanel(), BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
