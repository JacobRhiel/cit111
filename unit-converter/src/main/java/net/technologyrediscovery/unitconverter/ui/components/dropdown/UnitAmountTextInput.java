package net.technologyrediscovery.unitconverter.ui.components.dropdown;

import net.technologyrediscovery.unitconverter.ui.components.error.IComponentError;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;

public class UnitAmountTextInput extends JTextField implements ActionListener, FocusListener, DocumentListener, IComponentError
{

    private final String rootText;

    public UnitAmountTextInput() {
        super("Enter an amount to convert", 16);
        this.rootText = getText();
        addActionListener(this);
        addFocusListener(this);
        getDocument().addDocumentListener(this);
    }

    /**
     * Checks if this contains the default text.
     * @return If it is the default text.
     */
    public boolean isDefault() {
        return getText().equals(rootText);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(getText().isEmpty())
            setText(rootText);
        else ((UnitConversionPanel)getParent()).triggerUpdateResult();
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(getText().equals(rootText) && !getText().isEmpty())
            setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(getText().equals(rootText))
            return;
        if(getText().isEmpty())
            setText(rootText);
        else ((UnitConversionPanel)getParent()).triggerUpdateResult();
    }

    @Override
    public boolean hasError() {
        if(getText().equals(rootText)
                || getText().isEmpty()
                || getText() == null)
            return false;
        else return !getText().matches("\\d+");
    }

    private void updateWithKeyInput() {
        boolean text = getText().matches("\\d+");
        if(text)
            ((UnitConversionPanel)getParent()).triggerUpdateResult();
        else ((UnitConversionPanel)getParent()).triggerResetResult();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateWithKeyInput();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateWithKeyInput();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateWithKeyInput();
    }
}
