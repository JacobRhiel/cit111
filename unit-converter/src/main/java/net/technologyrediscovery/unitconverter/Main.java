package net.technologyrediscovery.unitconverter;

import net.technologyrediscovery.unitconverter.ui.RootPanel;
import net.technologyrediscovery.unitconverter.ui.components.footer.FooterPanel;

import javax.swing.*;
import java.awt.*;

public class Main
{

    private static final JFrame FRAME = new JFrame("Technology Rediscovery");

    private static final RootPanel ROOT_PANEL = new RootPanel();

    private static final FooterPanel FOOTER_PANEL = new FooterPanel();

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = FRAME;
            frame.setLayout(new BorderLayout());
            frame.add(ROOT_PANEL, BorderLayout.NORTH);
            frame.add(FOOTER_PANEL, BorderLayout.SOUTH);
            frame.setMinimumSize(new Dimension(950, 290));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

    }

}
