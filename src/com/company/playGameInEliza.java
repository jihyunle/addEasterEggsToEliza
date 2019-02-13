/*
Design an application that will prompt the user for the numerical value of two cards.
The program will receive the two numbers and display their sum on the screen.
If the calculated sum is 21, an asterisk is to be displayed beside the sum.

The program shall end when two zeros are entered.
The program shall print a welcome message when it is first started and an goodbye message when it terminates.

Bonus:
Modify the application to allow the user to enter the face cards as J,Q,K or A.
If the user enters J, Q, or K then convert the entered value to 10.
If the user enters A then count the value as 11 points.

Bonus Bonus:
Modify the algorithm to allow the user who receives the A to designate it either as 1 or 11.

Objective

Define the problem by constructing an algorithm using pseudocode
What control structures (sequence, selection and repetition) are required?
What variables are required?
Show a check of your solution with test data for at least two valid test cases
*/
package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class playGameInEliza {

    // Private variables
    private ArrayList<Integer> cardsDrawn;
    private int sum;
    private int cardNumber;
    private int zeroCount = 0;
    private boolean forceExit = false;

    private Scanner keyboard;

    // No-arg ctr
    public playGameInEliza(){
        cardsDrawn = new ArrayList<>();
    }

    // One-arg ctr
    public playGameInEliza(Scanner input){
        cardsDrawn = new ArrayList<>();
        keyboard = input;
    }

    // Getters and Setters
    public ArrayList<Integer> getCardsDrawn() {
        return cardsDrawn;
    }

    public void setCardsDrawn(ArrayList<Integer> cardsDrawn) {
        this.cardsDrawn = cardsDrawn;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getZeroCount() {
        return zeroCount;
    }

    public void setZeroCount(int zeroCount) {
        this.zeroCount = zeroCount;
    }

    public boolean isForceExit() {
        return forceExit;
    }

    public void setForceExit(boolean forceExit) {
        this.forceExit = forceExit;
    }

    public void playGame(){
        // Welcome message
        showWelcomeMessage();

        do {
            // Prompt user for card number
            promptUser();
//            if (forceExit){
//                break;
//            }

            showSumOfCards();

        } while (replay());

        // Exit message
        showExitMessage();
    }

    public static void showWelcomeMessage(){
        System.out.println("Welcome! Let's play a game.");
    }


    public void promptUser(){

        for(int i=0; i<2; i++){

            System.out.println("Pick a card: ");
            Scanner input = new Scanner(System.in);
            String cardString = input.nextLine();

            // Pass string and get integer
            cardNumber = getCardNumber(cardString);

            /*
            * Validate input.
            * If it's a zero, keep count and exit after the second time
            * */
//            forceExit = validateInput(cardNumber);
//            if (forceExit){
//                break;
//            }

            /*
            * Add the two cards to array list.
            * Then calculate sum
            * */
            cardsDrawn.add(cardNumber);
            sum += cardsDrawn.get(i);
        }

    }


    public static int getCardNumber(String cardString){
        int num = 0;
        Scanner input = new Scanner(System.in);

        // If card is J, Q or K
        if(cardString.equalsIgnoreCase("J")||
                cardString.equalsIgnoreCase("Q")||
                cardString.equalsIgnoreCase("K")){
            System.out.println("You picked a face card " + cardString.toUpperCase());
            num = 10;

        // If card is A
        }else if (cardString.equalsIgnoreCase("A")){
            System.out.println("You picked a face card " + cardString.toUpperCase());
            // Allow the user to designate A as either 1 or 11
            System.out.println("Would you like to designate it as a 1 or 11?");
            if (input.nextInt()==1){
                num = 1;
            } else if (input.nextInt()==11){
                num = 11;
            }
            input.nextLine();

        // Otherwise, if it's a regular number
        }else{
            num = Integer.parseInt(cardString);
        }
        return num;
    }


    // Not using this for now
    public boolean validateInput(int num){
        // Increment zeroCount each time method is called
        while (zeroCount<2){
            if(num==0){
                zeroCount++;
            }
            return false;
        }
        // When zeroCount reaches 2 exit the program
        return true;
    }

    public void showSumOfCards(){
        System.out.print("Sum of two cards: ");
        if(sum == 21){
            System.out.println(sum + "*");
        }else{
            System.out.println(sum);
        }
    }

    /*
     * Ask if user wants to play again
     * */
    public boolean replay(){
        System.out.println("Would you like to play again? (y/n)");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        if (str.equalsIgnoreCase("y")){
            // Reset sum to zero
            resetSum();
            return true;
        }else {
            return false;
        }
        // keyboard.close() can't go here

    }

    public void resetSum(){
        cardsDrawn.clear();
        sum = 0;
    }

    public static void showExitMessage(){
        System.out.println("Goodbye! You are now exiting the game.");
        System.out.println();
    }

}


