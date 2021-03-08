package net.technologyrediscovery.week5.math;

/**
 * @author Jacob Rhiel <jacob.rhiel@gmail.com>
 * @created Mar 08, 2021
 */
public enum MathEquations implements IMathProblem
{

    SIMPLE {
        @Override
        public String problem() {
            return "(100 / 5) * 2";
        }

        @Override
        public int solution() {
            return 40;
        }

        @Override
        public String displaySteps() {
            return "100 divided by 5 = 20. 20 times 2 = 40.";
        }
    },

    ACCELERATED {
        @Override
        public String problem() {
            return "Solve for x. -3 + 2x = 11";
        }

        @Override
        public int solution() {
            return 7;
        }

        @Override
        public String displaySteps() {
            return """
                    -3 + 2x = 11
                    +3 + 2x = 14
                         2x = 14
                      (/)2x = 14 / 2
                          x = 7
                    """;
        }

    },

    ADVANCED {
        @Override
        public String problem() {
            return "x² + y² + 4x - 2y = -1. What is the radius of the circle?";
        }

        @Override
        public int solution() {
            return 2;
        }

        @Override
        public String displaySteps() {
            return """
                    Formula: Standard form of the equation of a circle: (x-h)²+(y-k)²=r²2
                             Where (h,k) is the center of the circle and r=radius.
                    
                    x² + y² + 4x - 2y = -1
                    This problem is not in the standard form of the equation of a circle.
                    We need to rewrite the equation to find the radius.
                    To begin, we need to complete the square twice, once for x and once for y.
                    
                    (Rewritten for x) - x² + 4x + y² - 2y = -1
                    (Rewritten for y) (x+2)² - 4 + (y-1)² - 1 = -1
                    
                    As you can see, we halved the absolute value of the x and y coefficients to find 
                    the constant to complete the square, then subtracted the squared constants to keep
                    the equation the same. Now we need to move our constants to the other side by adding
                    and we'll have our equation in standard form.
                    
                    (x + 2)² + (y - 1)² = -1 + 1 + 4
                    (x + 2)² + (y - 1)² = 4
                    
                    We now see that r² = 4, so the radius is the √4
                    r = 2.
                    """;
        }
    }

}
