/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.technologyrediscovery.cit111.week4.mightWeBeFriends;

import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import net.technologyrediscovery.cit111.week4.mightWeBeFriends.questions.FirstQuestion;
import net.technologyrediscovery.cit111.week4.mightWeBeFriends.questions.AbstractQuestion;
import net.technologyrediscovery.cit111.week4.mightWeBeFriends.questions.FourthListQuestion;
import net.technologyrediscovery.cit111.week4.mightWeBeFriends.questions.SecondQuestion;
import net.technologyrediscovery.cit111.week4.mightWeBeFriends.questions.ThirdQuestion;

/**
 *  Might we be friends assignment, takes input for questions and displays the output.
 * @author jacob
 */
public class MightWeBeFriends {
    
    // Statically assigned since this is technically constant in this context.
    private static final SortedSet<AbstractQuestion> QUESTIONS = new TreeSet<AbstractQuestion>();
    
    static {
        QUESTIONS.add(new FirstQuestion());
        QUESTIONS.add(new SecondQuestion());
        QUESTIONS.add(new ThirdQuestion(true));
        QUESTIONS.add(new FourthListQuestion(
                new String[] { "OldSchool RuneScape", "World of Warcraft", "COD: MW3", "League of Legends", "All", "None" },
                new int[] { 8, 8, 4, 4, 25, 0 },
                new String[] { "OldSchool.. I like it.", "If you ain't Horde you're bored.", "KDA?", "This team is trash.", "Ey, I dig it!", "MineCraft is very gamer.." }
        ));
    }
    
    public static void main(String[] args) {
        
        Scanner response = new Scanner(System.in);
        
        System.out.println("Hey there I am Jake. Let's see if we can be friends.. first of all answer the following to get started..");
        System.out.print("What is your first name? ");
        
        // create the basic instance of our 'possible friend'.
        PossibleFriend friend = new PossibleFriend(60);
        
        try {
            String firstName = response.next("[a-zA-Z]+");
            friend.setFirstName(firstName);
            System.out.print("What is your age? ");
            int age = response.nextInt();
            friend.setAge(age);        
                
            // turn our constant values into an iterable.
            Iterator<AbstractQuestion> iterable = QUESTIONS.iterator();

            // while the iterable queue hasn't been 'taken' from.
            while(iterable.hasNext()) {
                // next in the iterator.
                AbstractQuestion question = iterable.next();
                // ask the question.
                System.out.print(question.askQuestion());
                // get the response
                int questionResponse = response.nextInt();
                // set the response to the question.
                question.setResponse(questionResponse);
                // send a response based on the answer.
                System.out.println(question.questionResponse());
                // set the new compatability score.
                friend.changeCompatabilityScoreForQuestion(question);
                // set the question answered, bitmasking is fun.
                friend.setAnsweredQuestion(question);
                // should we stop? (mainly for the WeightListQuestion being linked to the previous question.
                if(question.shouldStop())
                    break; // break the iterable.
            }

            // loop through and verify we checked all questions and they were answered.
            if(!friend.answeredAllQuestions(QUESTIONS))
                System.out.println("Well we have a conundrum on our hands here, programatically that is.");

            // override the #toString to display what we want.
            System.out.println(friend.toString());
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}