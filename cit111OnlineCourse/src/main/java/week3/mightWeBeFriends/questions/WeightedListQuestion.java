/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3.mightWeBeFriends.questions;

/**
 * Creates a weighted list of question.
 * @author jacob
 */
public abstract class WeightedListQuestion extends AbstractQuestion {
    
    // The answer chosen from the list of options.
    public int answerOption;
    
    // The options in array order and responses.
    public String[] options, responses;
    // The weights in array order.
    public int[] weights;
    
    /**
     * Creates a constructor with the arguments.
     * @param options The options for the question.
     * @param weights The weights for each option.
     * @param responses The responses for each option.
     */
    public WeightedListQuestion(String[] options, int[] weights, String[] responses) {
        this.options = options;
        this.weights = weights;
        this.responses = responses;
        this.requiresAnswer = false;
    }
    
    /**
     * The options to choose from.
     * @return The options.
     */
    public String[] getOptions() {
        return this.options;
    }
    
    /**
     * The weights of the options.
     * @return The weights.
     */
    public int[] getWeights() {
        return this.weights;
    }
    
    /**
     * The responses of the question.
     * @return The responses.
     */
    public String[] getResponses() {
        return this.responses;
    }
    
    /**
     * The weight for the chosen answer index.
     * @return The weight for the answer.
     */
    public int getWeightForAnswer() {
       return weights[answerOption];
    }
    
    /**
     * Sets the response option based on the chosen index.
     * @param index The index of the answer.
     * @return The response index.
     */
    public int setResponse(int index) {
        this.answerOption = (index > responses.length) ? responses.length : (index < 0) ? responses.length : index;
        setDidAgree(this.answerOption != options.length);
        return this.answerOption;
    }
    
    /**
     * Returns the response from the chosen index.
     * @param index The index chosen.
     * @return The response of the index.
     */
    public String getResponse(int index) {
        String _response = getResponses()[index];
        this.answerOption = (index > responses.length) ? responses.length : (index < 0) ? responses.length : index;
        return _response == null ? "No response found for index: " + index : _response;        
    }
    
}
