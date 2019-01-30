/*
* If you type "pig" Eliza should begin speaking in pig latin
* Pig Latin Rules:

    If the first letter is a consonant, add "ay" to the end
    If the first letter is a vowel, add "way" or "tay" to the end
    Don't worry about the "multiple-letters-that-sounds-like one" rule (ex. str-, ch-, th-, etc.)

Additional Features:

If you type "caps" Eliza should begin speaking in all caps.

If you type "play game" Eliza should allow you to play a game, such as your choose your own adventure game.

If you type in "red" Eliza 's text should be displayed in red.

At the end of the chat, print out the chat history.*/

package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class elizaEasterEggs {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    private static ArrayList<String> history = new ArrayList<>();


    public static void main(String[]args){

        String userInput = "";
        String str = "";
        String newStr = "";
        String elizaSays = "";
        int num = -1;
        boolean userQuits = true;
        boolean isPig = false; boolean isCaps = false; boolean isPlayGame = false; boolean isRed = false;

        Scanner input = new Scanner(System.in);
        do {
        System.out.println("Good day. What is your problem today?");
        userInput = input.nextLine();
        userQuits = getQuitCommand(userInput);

            // If user types a quit command, set variable userQuits to true
//            if (userQuits = getQuitCommand(userInput)){
            if (userQuits){
                break;
            }
//                break;
//            }

            else if (userInput.equalsIgnoreCase("pig")){
                isPig = onOffSwitch(isPig);
                if (isPig=true){
                    System.out.println("Now speaking in pig latin");
                    while (isPig=true){
                        System.out.println("Good day. What is your problem today?");
                        userInput = input.nextLine();
                        elizaSays = getPigLatin(userInput);
                        printElizaSays(elizaSays);
                    }
                }else{
                    System.out.println("Exiting pig mode");
                    continue;
                }
            }

            else if (userInput.equalsIgnoreCase("caps")){
                isCaps = onOffSwitch(isCaps);
                if (isCaps=true){
                    System.out.println("Now showing text in all caps");
                    while (isCaps=true){
                        System.out.println("Good day. What is your problem today?");
                        userInput = input.nextLine();
                        elizaSays = getCaps(userInput);
                        printElizaSays(elizaSays);
                    }
                }else{
                    System.out.println("Exiting caps mode");
                    continue;
                }
            }

            else if (userInput.equalsIgnoreCase("play game")){
                isPlayGame = onOffSwitch(isPlayGame);
                if (isPlayGame=true){
                    System.out.println("Now playing BlackJack");
                    playgameInEliza pg = new playgameInEliza();
                    pg.playGame();

                }else{
                    System.out.println("Exiting playgame mode");
                }
                continue;
            }

            else if (userInput.equalsIgnoreCase("red")){
                isRed = onOffSwitch(isRed);
                if (isRed=true){
                    System.out.println("Now showing text in red");
                    System.out.println("Good day. What is your problem today?");
                    userInput = input.nextLine();
                    elizaSays = getRed(userInput);
                    printElizaSays(elizaSays);
                }else{
                    System.out.println("Now showing text in black");
                    continue;
                }
            }

            else{
                elizaSays = getElizaSays(userInput);
                printElizaSays(elizaSays);
            }

            // At the end, print chat history


        }while (!userQuits);

        // Add a step at the end that prints chat history

        System.out.println(">>> END");
        input.close();
        System.exit(0);
        // End of Main method
    }


    public static boolean getQuitCommand(String str){
        // initialize boolean as false
        boolean userQuits = false;
        // boolean changes to true if quit commands are typed
        if (str.equalsIgnoreCase("Q") || str.equalsIgnoreCase("i am feeling great")) {
            userQuits = true;
        }
        return userQuits;
    }

    public static boolean onOffSwitch (boolean value){
        // Acts as an on/off switch
        if (value = true){
            value = false;
        }else if (value = false){
            value = true;
        }
        return value;
    }

    public static String getPigLatin(String str) {
        String[] words = str.split(" ");
        String newStr = "";
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        // Loop through each word in the string
        for (String word : words) {
            char firstChar = word.toLowerCase().charAt(0);
            // Loop through and test each vowel
            for (int i = 0; i < vowels.length; i++) {
                // If first letter is a vowel, append "way" or "tay", randomly chosen
                if (firstChar == vowels[i]) {
                    // Generate 2 random numbers
                    int num = (int) Math.random() * 2;
                    if (num == 0) {
                        // append "way"
                        word = word + "way";
                    } else {
                        // or append "tay"
                        word = word + "tay";
                    }
                }
                // If first letter is a consonant, append "ay"
                else {
                    word = word + "ay";
                }
            }
            // Concatenate the words back into a String
            newStr += word + " ";
        }
        // Return a String
        return newStr;
    }

    public static String getCaps(String str){
        String s = "";
        String newStr = "";
        s = getElizaSays(str);
        newStr = s.toUpperCase();
        return newStr;
    }

    public static String getRed(String str){
        String s = "";
        String newStr = "";
        s = getElizaSays(str);
        newStr = ANSI_RED + s + ANSI_RESET;
        return newStr;
    }

    public static String getElizaSays(String str){
        String newStr = "";
        // After user input is read, generate a random number between 0 and 1
        Random rnd = new Random();
        int responseOption = rnd.nextInt(2);
        if(responseOption==1){
            // call method that randomly chooses hedge
            return newStr = replyWithHedge();
        }else{
            // call method that first replaces words in user input
            // then prepends the qualifier
            return newStr = replyWithQualifier(str);
        }
    }

    public static String replyWithHedge(){
        String[] hedges = {"Please tell me more",
                "Many of my patients tell me the same thing",
                "It is getting late, maybe we had better quit"};
        Random rnd = new Random();
        int index = rnd.nextInt(hedges.length);
        return hedges[index];
    }

    public static String replyWithQualifier(String str){
        String replacedStr = replaceWords(str);
        String[] qualifiers = {"Why do you say that ",
                "You seem to think that ",
                "So, you are concerned that "};
        Random rnd = new Random();
        int index = rnd.nextInt(qualifiers.length);
        String newStr = qualifiers[index] + replacedStr;
        return newStr;
    }

    public static String replaceWords(String str){
        String[] words = str.split(" ");
        String newStr = "";

        for(String word: words){
            // Lower Case all letters
            word = word.toLowerCase();
            // If HashMap contains key, swap out key for value
            HashMap<String, String> myMap = new HashMap<>();
            myMap.put("i", "you");
            myMap.put("me", "you");
            myMap.put("my", "your");
            myMap.put("am", "are");

            if(myMap.containsKey(word)){
                word = myMap.get(word);
            }
            // Concatenate the contents of the array back into a String
            newStr += word + " ";
        }
        return newStr;
    }

    // Print elizaSays
    // And call addToHistory each time Eliza returns a statement
    public static void printElizaSays(String str){
        System.out.println(str);
        buildHistory(str);
    }

    // Call addToHistory each time user types input and each time eliza returns a statement
    public static void buildHistory(String str){
        history.add(str);
    }

    // Call printHistory at the end of main method
    public static void printHistory(){
        for (int i=0; i<history.size(); i++){
            System.out.println(history.get(i));
        }
    }


}
