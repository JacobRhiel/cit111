package net.technologyrediscovery.unitconverter.ui.components.error;

import javax.swing.*;
import java.awt.*;

/**
 * Dynamic label for displaying errors.
 */
public class ErrorInfoLabel extends JLabel
{

    private final String defaultText = "Error: ";

    private String appendedText;

    public ErrorInfoLabel() {
        setForeground(Color.RED);
        setText(defaultText);
    }

    /**
     * Updates the label text.
     * @param text The text to append.
     */
    public void setError(String text) {
        String currentText = getText();
        if(currentText.equals(defaultText)
            || !currentText.equals(defaultText + text))
        {
            appendedText = text;
            setText(defaultText + appendedText);
        }
    }

    /**
     * Checks if the label needs repainted.
     * @param text The text to check appended against.
     * @return True of False.
     */
    public boolean needsUpdated(String text) {
        return !(defaultText + appendedText).equals(defaultText + text);
    }

}
