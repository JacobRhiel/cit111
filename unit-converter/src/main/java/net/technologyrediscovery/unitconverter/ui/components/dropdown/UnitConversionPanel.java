package net.technologyrediscovery.unitconverter.ui.components.dropdown;

import net.technologyrediscovery.unitconverter.ui.components.error.ErrorInfoLabel;
import net.technologyrediscovery.unitconverter.ui.components.error.ErrorType;
import net.technologyrediscovery.unitconverter.ui.components.error.IComponentError;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class UnitConversionPanel extends JPanel implements IComponentError
{

    protected UnitDropdown firstUnit = new UnitDropdown(this);

    protected UnitDropdown secondUnit = new UnitDropdown(this);

    private final UnitResultLabel resultLabel = new UnitResultLabel();

    private final ErrorInfoLabel errorInfoLabel = new ErrorInfoLabel();

    private final UnitAmountTextInput unitInput = new UnitAmountTextInput();

    public UnitConversionPanel() {
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        setLayout(layout);
        errorInfoLabel.setVisible(false);
        JLabel unitLabel = new JLabel("Select a unit to convert: ");
        add(unitLabel);
        add(firstUnit);
        add(secondUnit);
        add(unitInput);
        add(resultLabel);
        add(errorInfoLabel);
    }

    /**
     * Triggers an update for the label calculation result.
     */
    public void triggerUpdateResult() {
        if(hasError())
        {
            displayError();
            return;
        } else {
            if(errorInfoLabel.isVisible())
                errorInfoLabel.setVisible(false);
        }
        UnitType first = (UnitType) this.firstUnit.getSelectedItem();
        UnitType second = (UnitType) this.secondUnit.getSelectedItem();
        if(unitInput.isDefault())
            return;
        double resultValue = Objects.requireNonNull(first).calculate(Integer.parseInt(unitInput.getText()), second);
        double roundedResult = Math.round(resultValue * 100.0) / 100.0;
        resultLabel.updateResult("" + roundedResult, Objects.requireNonNull(second));
    }

    /**
     * Trigger result reset.
     */
    public void triggerResetResult() {
        if(hasError())
            displayError();
        resultLabel.resetResult();
    }

    /**
     * Displays an error.
     */
    public void displayError() {
        if (!errorInfoLabel.isVisible())
            errorInfoLabel.setVisible(true);
    }

    /**
     * Sets the error internally.
     * @param error The error.
     */
    public void setError(String error) {
        errorInfoLabel.setError(error);
    }

    @Override
    public boolean hasError() {
        boolean inputError = unitInput.hasError();
        String errorText = null;
        if(inputError)
            errorText = ErrorType.INVALID_FORMAT_NUMERIC.name();
        if(errorInfoLabel.needsUpdated(errorText))
            setError(errorText);
        return errorText != null;
    }

}
