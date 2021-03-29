package net.technologyrediscovery.unitconverter.ui.components.dropdown;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitDropdown extends JComboBox<UnitType> implements ActionListener {

    private final UnitConversionPanel parent;

    public UnitDropdown(UnitConversionPanel parent) {
        this.parent = parent;
        for (UnitType type : UnitType.values()) {
            addItem(type);
        }
        setSelectedIndex(0);
        setSelectedItem(UnitType.LITERS);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        parent.triggerUpdateResult();
    }
}
