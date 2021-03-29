package net.technologyrediscovery.unitconverter.ui.components.dropdown;

public enum UnitType
{

    LITERS {
        @Override
        public double calculate(int value, UnitType type) {
            double returnValue = -1;
            switch(type) {
                case MILLILITERS:
                    returnValue = value * 1000;
                    break;
                case GALLONS:
                    returnValue = (value / 3.785);
                    break;
                case QUARTS:
                    returnValue = value * 1.057;
                    break;
                default:
                    returnValue = value;
                    break;
            }
            return returnValue;
        }
    },

    MILLILITERS {
        @Override
        public double calculate(int value, UnitType type) {
            double returnValue = -1;
            switch(type) {
                case LITERS:
                    returnValue = (double)value / 1000;
                    break;
                case GALLONS:
                    returnValue = ((double)value / 3785);
                    break;
                case QUARTS:
                    returnValue = ((double)value / 946);
                    break;
                default:
                    returnValue = value;
                    break;
            }
            return returnValue;
        }
    },

    GALLONS {
        @Override
        public double calculate(int value, UnitType type) {
            double returnValue = -1;
            switch(type) {
                case LITERS:
                    returnValue = value * 3.785;
                    break;
                case MILLILITERS:
                    returnValue = value * 3785;
                    break;
                case QUARTS:
                    returnValue = value * 4;
                    break;
                default:
                    returnValue = value;
                    break;
            }
            return returnValue;
        }
    },

    QUARTS {
        @Override
        public double calculate(int value, UnitType type) {
            double returnValue = -1;
            switch(type) {
                case LITERS:
                    returnValue = value / 1.057;
                    break;
                case MILLILITERS:
                    returnValue = value * 946;
                    break;
                case GALLONS:
                    returnValue = (double)value / 4;
                    break;
                default:
                    returnValue = value;
                    break;
            }
            return returnValue;
        }
    };

    public double calculate(int value, UnitType type) {
        return -1;
    }

}

