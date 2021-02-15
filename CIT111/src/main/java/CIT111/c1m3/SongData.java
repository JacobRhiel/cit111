/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT111.c1m3;

/**
 *
 * @author jacob
 */
public class SongData {
    
    public static void main(String[] args) {
        
        String songTitle = "Voodoo";
        String songArtist = "Godsmack";
               
        int releaseYear = 1998;
        
        double minFraction = 43.0 / 60.0;      
        // round decimal to second place.
        double songLength = Math.round((4.0 + minFraction) * 100.0) / 100.0;
        
        boolean hasLyrics = true;
        
        System.out.println("Favorite song info: " 
            + "\n Title: " + songTitle
            + "\n Artist: " + songArtist
            + "\n Release Year: " + releaseYear
            + "\n Song Duration: " + songLength + " minutes."
            + "\n This is " + (hasLyrics ? "a" : "not a") + " lyrical song."
        );
        
    }
    
}
