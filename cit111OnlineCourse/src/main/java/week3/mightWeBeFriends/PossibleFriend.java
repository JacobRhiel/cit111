/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3.mightWeBeFriends;

import java.util.Set;
import week3.mightWeBeFriends.questions.AbstractQuestion;
import week3.mightWeBeFriends.questions.WeightedListQuestion;

/**
 * A possible friend object.
 * @author jacob
 */
public class PossibleFriend {

    public String firstName;
    
    public int age;
    
    // define 75 as default to safe on any proccessing at the init.
    // the last question is a list and should be added based on response, not subtracted.
    public int compatabilityScore = 75;
    
    public int questionMask = 0;
    
    public int scoreThreshold;
    
    public PossibleFriend(int scoreThreshold) {
        this.scoreThreshold = scoreThreshold;
    }
    
    /**
     * Sets the first name.
     * @param firstName The first name.
     * @return The first name.
     */
    public String setFirstName(String firstName) {
        return this.firstName = firstName;
    }
    
    /**
     * Gets the first name.
     * @return The first name.
     */
    public String getFirstName() {
        return this.firstName;
    }
    
    /**
     * Sets the age.
     * @param age The age.
     * @return The age.
     */
    public int setAge(int age) {
        return this.age = age;
    }
    
    /**
     * Gets the age.
     * @return The age.
     */
    public int getAge() {
        return this.age;
    }
    
    /**
     * Changes the compatability score based on the question answered.
     * @param question The question at hand.
     * @return The new score.
     */
    public int changeCompatabilityScoreForQuestion(AbstractQuestion question) {
        int changeInScore = 0;
         if(question instanceof WeightedListQuestion) {
            changeInScore = ((WeightedListQuestion)question).getWeightForAnswer();
            return increaseCompatabilityScore(changeInScore);
        } else if(!question.didAgree()) {
            return decreaseCompatabilityScore(question.compatabilityWeight());
        }
        return compatabilityScore;
    }
    
    /**
     * Increases the score.
     * @param value The value to increase by.
     * @return The new score.
     */
    public int increaseCompatabilityScore(int value) {
        return this.compatabilityScore += value;
    }
    
    /**
     * Decreases the score.
     * @param value The value to decrease by.
     * @return The new score.
     */
    public int decreaseCompatabilityScore(int value) {
        int projectedScore = this.compatabilityScore - value;
        return this.compatabilityScore = projectedScore < 0 ? 0 : projectedScore;
    }
   
    /**
     * The compatability score.
     * @return The score.
     */
    public int getCompatabilityScore() {
        return this.compatabilityScore;
    }
    
    /**
     * Returns if the question was answered.
     * @param question The question.
     * @return If it was answered.
     */
    public boolean answeredQuestion(AbstractQuestion question) {
        return (questionMask & question.identifier()) == question.identifier();
    }
    
    /**
     * Sets the bitmask to answered for this question.
     * @param question The question.
     */
    public void setAnsweredQuestion(AbstractQuestion question) {
        questionMask = questionMask | question.identifier();
    }
    
    /**
     * Checks if all questions were answered.
     * @param questions The questions in 'question'.
     * @return If they were all answered.
     */
    public boolean answeredAllQuestions(Set<AbstractQuestion> questions) {
        boolean answered = true;
        for(AbstractQuestion question : questions) {
            // omit if it isn't required an answer.
            if(!answeredQuestion(question) && question.requiresAnswer())
            {
                answered = false;
                break;
            }
        }
        return answered;
    }
    
    /**
     * Can we be friends?
     * @return If the score is acceptable.
     */
    public boolean canBeFriends() {
        return this.scoreThreshold > 50;
    }
    
    @Override
    public String toString() {
        return new StringBuilder().append("Well, ")
                .append(firstName)
                .append(String.format(" based on your compatability score of %d. ", this.compatabilityScore))
                .append("It looks like we ")
                .append(canBeFriends() ? "can" : "cannot")
                .append(" be friends.")
                .toString();
    }
    
}
