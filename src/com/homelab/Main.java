package com.homelab;


import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random rand = new Random();
        int low = 0;
        int high = 100;
        int number = rand.nextInt((high+1)-low) + low;
        int guess = -1;
        int counter = 0;
        int counterError = 0;
        String history = "";
        Scanner sc = new Scanner(System.in);
        while (guess !=  number){
            System.out.println(history);
            System.out.print("Guess number from " + low + " to " + high + ": ");
            try {
                guess = sc.nextInt();
                if ( (guess < low)||(guess > high) ){
                    guess = 0;
                    throw new IllegalArgumentException();
                }
                counter++;
                if (guess < number) {
                    System.out.println("Bigger!");
                    low = guess;
                }
                else if (guess > number) {
                    System.out.println("Smaller!");
                    high = guess;
                }
                else {
                    System.out.println("Congratulations! Number was: " + number);
                    System.out.println("Number of attempts: " + counter);
                    System.out.println("Number of incorrect guesses: " + counterError);
                }
                history += counter + ". Guess was: " + guess + "\n";
            } catch (Exception e) {
                sc.nextLine();
                counterError++;          }
        }
        sc.close();
    }
}
