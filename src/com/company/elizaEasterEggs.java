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

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static Scanner keybd;
//    private static Scanner keybd = new Scanner(System.in);
    private static ArrayList<String> history;
    private static Random rnd;
//    private static Random rnd = new Random();

    public elizaEasterEggs(){
        history = new ArrayList<>();
        keybd = new Scanner(System.in);

        rnd = new Random();
    }

    public static void main(String[]args) {

        String userInput = "";
        String elizaSays = "";

        boolean isPig = false;
        boolean isCaps = false;
        boolean isRed = false;

        print("Good day. What is your problem today?");

        while(true) {

            print("Enter your response here: ");
            userInput = keybd.nextLine();
            addHistory(userInput);

            // If user types in "pig"
            if (userInput.equalsIgnoreCase("pig")) {
                isPig = onOffSwitch(isPig);
                if (isPig){
                    String intro = "pig ON";
                    print(intro);
                }else{
                    String outro = "pig OFF";
                    print(outro);
                }
                // Then return to top of the loop
                continue;
            }

            // If user types in "caps"
            if (userInput.equalsIgnoreCase("caps")) {
                isCaps = onOffSwitch(isCaps);
                if (isCaps){
                    String intro = "caps ON";
                    print(intro);
                }else{
                    String outro = "caps OFF";
                    print(outro);
                }
                // Then return to top of the loop
                continue;
            }

            // If uer types in "red"
            if (userInput.equalsIgnoreCase("red")) {
                // Call on/off method
                isRed = onOffSwitch(isRed);

                if (isRed){
                    String intro = "red ON";
                    print(intro);
                }else {
                    String outro = "red OFF";
                    print(outro);
                }
                // Then return to top of the loop
                continue;
            }

            // If user types in "play game"
            if (userInput.equalsIgnoreCase("play game")) {

                    String intro = "Loading game...";
                    print(intro);
                    System.out.println();
                    playGameInEliza pg = new playGameInEliza(keybd);
                    pg.playGame();
                    print("Finished playing a game");
                    continue;
            }


            // If user types a quit command
            if (getQuitCommand(userInput)) {
                break;
            }
            // Otherwise
            else {
                elizaSays = getReply(userInput);

                // If isPig is true
                if (isPig){
                    elizaSays = getPigLatin(elizaSays);
                }

                // If isCaps is true
                if (isCaps) {
                    elizaSays = getCaps(elizaSays);

                }

                // If isRed is true
                if (isRed) {
                    elizaSays = getRed(elizaSays);

                }

                print(elizaSays);

            }

        } // End of while loop

        String outro = ">>> END";
        print(outro);
        keybd.close();

        // At the end, print chat history
        showHistory();

        System.exit(0);
    } // End of Main method



    public static boolean getQuitCommand(String str){

        if (str.equalsIgnoreCase("Q") || str.equalsIgnoreCase("i am feeling great")) {
            return true;
        }else {
            return false;
        }
    }

    public static boolean onOffSwitch (boolean onOff){
        return !onOff;
    }


    public static String getPigLatin(String str) {
        String[] words = str.split(" ");
        String newStr = "";
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        boolean isVowel = true ;
        String[] pigLatin = {"way", "tay", "ay"};
        String pigString = "";

        // Loop through each word in the string
        for (String word : words) {
            // Lower case all words and obtain first character
            word = word.toLowerCase();
            char firstLetter = word.charAt(0);

            // Loop through and test for each vowel
            for (int i = 0; i < vowels.length; i++) {
                if (firstLetter==vowels[i]){
                    isVowel = true;
                    break;
                }else{
                    isVowel = false;
                    continue;
                }
            }

            /*
            * If first letter is a vowel, append "way" or "tay", randomly chosen
            * If first letter is a consonant, append "ay"
            * */
            if (isVowel){
                // Generate a pigIndex that will be either 0 or 1
                int index = rnd.nextInt(2);
                pigString = pigLatin[index];
            }else{
                pigString = pigLatin[2];
            }

            // Concatenate the words back into a String
            word += pigString;
            newStr += word + " ";
        }

        // Return a String
        return newStr;
    }

    public static String getCaps(String str){
        String newStr = "";
        newStr = str.toUpperCase();
        return newStr;
    }

    public static String getRed(String str){
        String newStr = "";
        newStr = ANSI_RED + str + ANSI_RESET;
        return newStr;
    }

    public static String getReply(String str){
        String newStr = "";
        // After user keybd is read, generate a random number between 0 and 1
        int num = rnd.nextInt(2);
        switch (num){
            case 0:
                // call hedge
                newStr = replyHedge(rnd);
                break;
            case 1:
                // call qualifier
                newStr = replyQualifier(rnd);
                break;
        }
        return newStr;
    }

    public static String replyHedge(Random rnd){
        ArrayList<String> hedges = new ArrayList<>();
        hedges.add("Please tell me more");
        hedges.add("Many of my patients tell me the same thing");
        hedges.add("It is getting late, maybe we had better quit");
        return hedges.get(rnd.nextInt(hedges.size()));
    }

    public static String replyQualifier(Random rnd){
        ArrayList<String> qualifiers = new ArrayList<>();
        qualifiers.add("Why do you say that ");
        qualifiers.add("You seem to think that ");
        qualifiers.add("So, you are concerned that ");
        return qualifiers.get(rnd.nextInt(qualifiers.size()));
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

    // Print and add to History each time it prints
    public static void print(String str){
        System.out.println(str);
        addHistory(str);
    }

    // Add to history each time user types keybd and each time eliza returns a statement
    public static void addHistory(String str){
        history.add(str);
    }

    // Print history at the end of main method
    public static void showHistory(){
        System.out.println("Printing chat history: ");
        for (int i=0; i<history.size(); i++){
            System.out.println(history.get(i));
        }
    }

}
