/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.mightWeBeFriends.questions;

/**
 * Boiler plate class of @see AbstractQuestion.
 * @author jacob
 */
public class ThirdQuestion extends AbstractQuestion {
    
    public ThirdQuestion(boolean stopOnDisagree) {
        super(stopOnDisagree);
    }
    
    @Override
    public int identifier() {
        return 3;
    }

    @Override
    public String askQuestion() {
        return "How about video games? Please enter 0 for true and 1 for false. (0 - yes, 1 - no)";
    }

    @Override
    public String agreeResponse() {
        return "Awesome, any of the following?";
    }

    @Override
    public String disagreeResponse() {
        return "Not so fun are we?";
    }

    @Override
    public int compatabilityWeight() {
        return 25;
    }
    
}
