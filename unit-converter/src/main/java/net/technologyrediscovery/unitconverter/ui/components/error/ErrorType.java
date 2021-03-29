package net.technologyrediscovery.unitconverter.ui.components.error;

public enum ErrorType
{

    /**
     * Invalid format (regex of \\d+) [0-9] numeric only.
     */
    INVALID_FORMAT_NUMERIC,

    /**
     * Invalid combination type of @see UnitType
     */
    INVALID_COMBINATION,

    /**
     * Invalid combination and format.
     */
    INVALID_COMBINATION_AND_NUMERIC_INPUT

}
