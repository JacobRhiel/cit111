/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.technologyrediscovery.cit111.week4.mightWeBeFriends.questions;

/**
 * Boiler plate class of @see WeightedListQuestion.
 * @author jacob
 */
public class FourthListQuestion extends WeightedListQuestion {

    /**
     * Override the default constructor so it is passed to the accessor of this class.
     * @param options The options for the question.
     * @param weights The weights of the options.
     * @param responses The responses of the options.
     */
    public FourthListQuestion(String[] options, int[] weights, String[] responses) {
        super(options, weights, responses);
    }
    
    @Override
    public int identifier() {
        return 4;
    }

    @Override
    public String askQuestion() {
        // create a StringBuilder to append by.
        StringBuilder builder =  new StringBuilder("Any of the following games? Answer with the number at the beginning of the games name.");
        int optionsSize = getOptions().length;
        // for loop the size of the options so we have the indexes.
        for(int index = 0; index < optionsSize; index++) {
            // the string option for said index.
            String option = getOptions()[index];
            builder.append("\n\t")
                    .append(String.format("%o " + option, index));// format the string by a numeric value.
            // optionsSize - 1, since the for loop stops if the next is ==.
            if(index == (optionsSize - 1)) 
                builder.append("\nAnswer: ");
        }
        return builder.toString();
    }

    @Override
    public String agreeResponse() {
        return getResponse(this.answerOption);
    }

    @Override
    public String disagreeResponse() {
        return "Looks like we won't cross paths it seems.";
    }

    @Override
    public int compatabilityWeight() {
        return 25;
    }
    
}
