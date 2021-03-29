package net.technologyrediscovery.unitconverter.ui.components.footer;

import javax.swing.*;
import java.awt.*;

public class FooterPanel extends JPanel
{

    public FooterPanel() {
        setMinimumSize(new Dimension(925, 75));
        JLabel text = new JLabel();
        text.setText(" * Please select a unit type, a unit type to compare too, and the amount of the unit you'd like to calculate.");
        add(text);
    }

}
