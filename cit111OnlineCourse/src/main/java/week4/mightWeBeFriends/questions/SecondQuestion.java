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
public class SecondQuestion extends AbstractQuestion {

    @Override
    public int identifier() {
        return 2;
    }

    @Override
    public String askQuestion() {
        return "Do you enjoy weightlifting? Please enter 0 for true and 1 for false. (0 - yes, 1 - no)";
    }

    @Override
    public String agreeResponse() {
        return "Sweet, no pain no gainz!";
    }

    @Override
    public String disagreeResponse() {
        return "No lifting, let me guess.. crossfit?";
    }

    @Override
    public int compatabilityWeight() {
        return 25;
    }
    
}
