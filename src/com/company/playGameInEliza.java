/*Design an application that will prompt the user for the numerical value of two cards.
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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class playGameInEliza {

    // Private variables
    private ArrayList<Integer> cardsDrawn = new ArrayList<>();
    private int sum;
    private int cardNumber;

    // Constructor no-arg
    public playGameInEliza(){
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

    public void playGame(){
        // Welcome message
        showWelcomeMessage();

        // Prompt user for card number
        promptUser();
        if(sum!=0){
            showSumOfCards(sum);
        }

        // Exit message
        showExitMessage();
    }

    public static void showWelcomeMessage(){
        System.out.println("Welcome! Let's play a game.");
    }

    public static void showExitMessage(){
        System.out.println("Goodbye! You are now exiting the game.");
    }

    public void promptUser(){
        Scanner input = new Scanner(System.in);
        for(int i=0; i<2; i++){
            System.out.println("Pick a card: ");
            String card = input.nextLine();

            // If user inputs J, Q or K, convert it to 10
            // Convert A to 11
            cardNumber = getFaceCardNumber(card);

            // Allow the user to designate A as either 1 or 11
            if(cardNumber==11){
                System.out.println("Would you like to designate it as a 1 or 11?");
                int aceCard = input.nextInt();
                cardNumber = getAceCardNumber(aceCard);
                input.nextLine();
            }

            // Check the inputted number to see if it's a zero
            // If so, keep count
            trackZeroCount(cardNumber);

            // Remember the card number in a list
            cardsDrawn.add(cardNumber);
            sum += cardsDrawn.get(i);
        }
    }

    public static void showSumOfCards(int sum){
        System.out.print("Sum of two cards: ");
        if(sum==21){
            System.out.println(sum + "*");
        }else{
            System.out.println(sum);
        }
    }

    public static void trackZeroCount(int cardNum){
        // Validate whether zero is entered
        int zeroCount = 0;
        // Increment zeroCount each time method is called
        if(cardNum==0){
            zeroCount++;
        }
        // When zeroCount reaches 2 exit the program
        if(zeroCount==2){
            System.exit(0);
        }
    }

    public static int getFaceCardNumber(String card){
        int num = -1;

        if(card.equalsIgnoreCase("J")||
                card.equalsIgnoreCase("Q")||
                card.equalsIgnoreCase("K")){
            System.out.println("You picked a face card " + card.toUpperCase());
            num = 10;
        }else if (card.equalsIgnoreCase("A")){
            System.out.println("You picked a face card " + card.toUpperCase());
            num = 11;
        }else{
            num = Integer.parseInt(card);
        }
        return num;
    }

    public static int getAceCardNumber(int a){
        int n = -1;
        if(a==1){
            n = 1;
        }else if (a==11){
            n = 11;
        }
        return n;
    }
}


