/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {

    private static boolean hasGuessedCorect;
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        Random random= new Random();
        int minRange= 1;
        int maxRange= 100;
        int maxAttempts= 10;
        boolean playAgain= true;
        int score= 0;
        int rounds= 0;
        System.out.println("Welcome to number guessing game...!");
        while(playAgain)
        {
            int numberToGuess= random.nextInt(maxRange-minRange+1)+minRange;
            int numberOfTries= 0;
            boolean hasGuessedCorrectly= false;
            System.out.println("\nGuess a number between" + minRange + "and" +maxRange+ ".");
            System.out.println("You have" + maxAttempts + "attempts to guess the correct number.");
            while(numberOfTries<maxAttempts && !hasGuessedCorect)
            {
                System.out.println("Enter your guess=");
                int guess= scanner.nextInt();
                numberOfTries++;
                if(guess<numberToGuess)
                {
                    System.out.println("Too low!!Try again...");
                }
                else if(guess>numberToGuess)
                {
                    System.out.println("Too high!!Try again...");
                }
                else
                {
                    hasGuessedCorrectly= true;
                    System.out.println("Correct! You'have guessed the number in"+ numberOfTries);
                    score +=(maxAttempts-numberOfTries+1);
                }
            }
            if(!hasGuessedCorrectly)
            {
                System.out.println("You've used all attempts! The correct number was"+ numberToGuess+".");
            }
            rounds++;
            System.out.println("Your current score="+score);
            System.out.println("Do you want to play another round? (Yes/No)=");
            playAgain= scanner.next().equalsIgnoreCase("yes"); 
        }
        System.out.println("Game over! You played" + "rounds and your final score is" +score+ ".");
        scanner.close();
    }
}