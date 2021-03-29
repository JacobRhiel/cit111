package net.technologyrediscovery.unitconverter.ui.components.dropdown;

import javax.swing.*;

public class UnitResultLabel extends JLabel
{

    private final String rootText = "Result: ";

    public UnitResultLabel() {
        setText(rootText + "n/a");
    }

    /**
     * Update the result label.
     * @param result The result.
     * @param unitType The unit type converted too.
     */
    public void updateResult(String result, UnitType unitType) {
        setText(rootText + result + " " + unitType.name().toLowerCase());
    }

    public void resetResult() {
        setText(rootText + "n/a");
    }

}
