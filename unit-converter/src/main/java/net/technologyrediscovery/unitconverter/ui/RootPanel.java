package net.technologyrediscovery.unitconverter.ui;

import net.technologyrediscovery.unitconverter.ui.components.dropdown.UnitConversionPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class RootPanel extends JPanel
{

    public RootPanel() {
        setBackground(Color.LIGHT_GRAY);
        setBorder(new LineBorder(Color.BLACK));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new UnitConversionPanel());
        add(new UnitConversionPanel());
        add(new UnitConversionPanel());
        add(new UnitConversionPanel());
        add(new UnitConversionPanel());
    }

}
