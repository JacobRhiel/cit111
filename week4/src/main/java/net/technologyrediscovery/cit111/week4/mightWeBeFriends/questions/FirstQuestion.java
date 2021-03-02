/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.technologyrediscovery.cit111.week4.mightWeBeFriends.questions;

/**
 * Boiler plate class of @see AbstractQuestion.
 * @author jacob
 */
public class FirstQuestion extends AbstractQuestion {

    @Override
    public int identifier() {
        return 1;
    }

    @Override
    public String askQuestion() {
        return "Do you enjoy technical projects? Please enter 0 for true and 1 for false. (0 - yes, 1 - no)";
    }

    @Override
    public String agreeResponse() {
        return "Great! That's one thing in common!";
    }

    @Override
    public String disagreeResponse() {
        return "That's odd, moving on..";
    }

    @Override
    public int compatabilityWeight() {
        return 25;
    }
    
}
