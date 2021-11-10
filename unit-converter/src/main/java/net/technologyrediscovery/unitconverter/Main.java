package net.technologyrediscovery.unitconverter;

import net.technologyrediscovery.unitconverter.ui.RootFrame;
import net.technologyrediscovery.unitconverter.ui.RootPanel;
import net.technologyrediscovery.unitconverter.ui.components.footer.FooterPanel;

import javax.swing.*;
import java.awt.*;

public class Main
{

    private static JFrame FRAME = new RootFrame();

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
                FRAME = new RootFrame();
                FRAME.setVisible(true);
        });

    }

}
