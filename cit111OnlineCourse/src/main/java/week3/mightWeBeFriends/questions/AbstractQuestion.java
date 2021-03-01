/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3.mightWeBeFriends.questions;

/**
 * Creates an abstract inheritable 'Question'.
 * Comparable is for the iterator.
 * @author jacob
 */
public abstract class AbstractQuestion implements Comparable {

    // response is an integer to be converted to a boolean or a list type for
    // @see WeightedListQuestion.
    int response;
    
    // did we agree on the answer.
    boolean didAgree = false;
    
    // do we stop 'break' the iterator if we disagree.
    boolean stopOnDisagree;
    
    // does the question require an answer.
    boolean requiresAnswer = true;
    
    /**
     * Default constructor.
     */
    public AbstractQuestion() {
        this(false);
    }
    
    /**
     * Constructor stating if we stop the program on disagreement.
     * @param stopOnDisagree 
     */
    public AbstractQuestion(boolean stopOnDisagree) {
        this.stopOnDisagree = stopOnDisagree;
    }
    
    /**
     * The identifier for our bit mask.
     * @return The identifier.
     */
    public abstract int identifier();
    
    /**
     * The question to be asked.
     * @return The asked question.
     */
    public abstract String askQuestion();
    
    /**
     * The response if we agree.
     * @return The agree response.
     */
    public abstract String agreeResponse();
    
    /**
     * The response if we disagree.
     * @return The disagree response.
     */
    public abstract String disagreeResponse();
    
    /**
     * The compatability weight of the question.
     * @return The compatability weight.
     */
    public abstract int compatabilityWeight();
       
    /**
     * If the question requires an answer.
     * @return Required answer.
     */
    public boolean requiresAnswer() {
        return this.requiresAnswer;
    }
    
    /**
     * Should stop 'break' the program.
     * @return If we should stop.
     */
    public boolean shouldStop() {
        return this.stopOnDisagree && !this.didAgree;
    }
    
    /**
     * Sets the response from the scanner input.
     * @param response The scanner input.
     * @return The response.
     */
    public int setResponse(int response) {
        setDidAgree(response == 0);
        return this.response = response;
    }
    
    /**
     * Sets the question state.
     * @param value If agree or not.
     * @return If agreed.
     */
    public boolean setDidAgree(boolean value) {
        return this.didAgree = value;
    }
    
    /**
     * If we agree.
     * @return Agreed.
     */
    public boolean didAgree() {
        return this.didAgree;
    }
    
    /**
     * The question response.
     * @return The response based on if we agreed.
     */
    public String questionResponse() {
        return this.didAgree ? agreeResponse() : disagreeResponse();
    }

    /**
     * Compares two objects, for this instance in the iterator.
     * @param o Compared against object.
     * @return If the two objects are equal.
     */
    @Override
    public int compareTo(Object o) {
        AbstractQuestion o1 = (AbstractQuestion)o;
        if(!(o1.agreeResponse() == null ? this.agreeResponse() == null : o1.agreeResponse().equals(this.agreeResponse()))
                && !(o1.askQuestion() == null ? this.askQuestion() == null : o1.askQuestion().equals(this.askQuestion()))
                && (o1.disagreeResponse() == null ? this.disagreeResponse() != null : !o1.disagreeResponse().equals(this.disagreeResponse()))
                && o1.identifier() != this.identifier())
            return 1;
        else return 0;
    }
    
}
