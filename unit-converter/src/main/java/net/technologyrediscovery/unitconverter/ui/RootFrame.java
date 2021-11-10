package net.technologyrediscovery.unitconverter.ui;

import net.technologyrediscovery.unitconverter.ui.components.footer.FooterPanel;

import javax.swing.*;
import java.awt.*;

public class RootFrame extends JFrame
{

    private static final RootPanel ROOT_PANEL = new RootPanel();

    private static final FooterPanel FOOTER_PANEL = new FooterPanel();

    public RootFrame() {
        super("Technology Rediscovery");
        setLayout(new BorderLayout());
        setBackground(Color.ORANGE);
        setMinimumSize(new Dimension(950, 290));
        setPreferredSize(new Dimension(200, 200));
        setLocationRelativeTo(null);
        add(ROOT_PANEL, BorderLayout.NORTH);
        add(FOOTER_PANEL, BorderLayout.SOUTH);
        pack();
    }

}
