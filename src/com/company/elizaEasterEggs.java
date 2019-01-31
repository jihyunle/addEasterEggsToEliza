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

    public static void main(String[]args) {
        String userInput = "";
        String str = "";
        String newStr = "";
        String elizaSays = "";
        int num = -1;
        boolean userQuits = false;
        boolean isPig = false;
        boolean isCaps = false;
        boolean isPlayGame = false;
        boolean isRed = false;

        Scanner input = new Scanner(System.in);
        System.out.println("Good day. What is your problem today?");

        while (userQuits){
            System.out.println("Enter your response here: ");
            userInput = input.nextLine();
            addtoHistory(userInput);

            // If user types a quit command, set variable userQuits to true
            if (userQuits = getQuitCommand(userInput)) {
                break;
            }

            // If user types in "pig"
            if (userInput.equalsIgnoreCase("pig")) {
                isPig = onOffSwitch(isPig);
            }

            // If isPig is true
            if (!isPig){
                String intro = "Now speaking in pig latin";
                printAndAddToHistory(intro);
                do {
                    System.out.println("Enter your response here: ");
                    userInput = input.nextLine();
                    addtoHistory(userInput);
                    elizaSays = getPigLatin(userInput);
                    printAndAddToHistory(elizaSays);
                }while (!isPig);
            }else{
                String outro = "Exiting pig mode";
                printAndAddToHistory(outro);
                continue;
            }

            // If user types in "caps"
            if (userInput.equalsIgnoreCase("caps")) {
                isCaps = onOffSwitch(isCaps);
            }

            // If isCaps is true
            if (!isCaps) {
                String intro = "Now showing text in all caps";
                printAndAddToHistory(intro);
                do {
                    System.out.println("Enter your response here: ");
                    userInput = input.nextLine();
                    addtoHistory(userInput);
                    elizaSays = getCaps(userInput);
                    printAndAddToHistory(elizaSays);
                }while (!isCaps);
            } else {
                String outro = "Exiting caps mode";
                printAndAddToHistory(outro);
                continue;
            }

            // If uer types in "red"
            if (userInput.equalsIgnoreCase("red")) {
                isRed = onOffSwitch(isRed);
            }

            // If isRed is true
            if (!isRed) {
                String intro = "Now showing text in red";
                printAndAddToHistory(intro);
                do {
                    System.out.println("Enter your response here: ");
                    userInput = input.nextLine();
                    addtoHistory(userInput);
                    elizaSays = getRed(userInput);
                    printAndAddToHistory(elizaSays);
                }while (!isRed);
            } else {
                String outro = "Now showing text in black";
                printAndAddToHistory(outro);
                continue;
            }

            // If user types in "play game"
            if (userInput.equalsIgnoreCase("play game")) {
                isPlayGame = onOffSwitch(isPlayGame);
            }

            // If isPlayGame is true
            if (!isPlayGame) {
                String intro = "Now playing BlackJack game";
                printAndAddToHistory(intro);
                playGameInEliza pg = new playGameInEliza();
                pg.playGame();
            } else {
                String outro = "Exiting playgame mode";
                printAndAddToHistory(outro);
                continue;
            }


        } // End of while loop

        String outro = ">>> END";
        printAndAddToHistory(outro);
        input.close();

        // At the end, print chat history
        printEntireHistory();

        // End of Main method
        System.exit(0);
    }



    // Other methods



    public static boolean getQuitCommand(String str){
        // initialize boolean as false
        boolean userQuits = false;
        // boolean changes to true if quit commands are typed
        if (str.equalsIgnoreCase("Q") || str.equalsIgnoreCase("i am feeling great")) {
            userQuits = true;
        }
        return userQuits;
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

            // If first letter is a vowel, append "way" or "tay", randomly chosen
            // If first letter is a consonant, append "ay"
            if (isVowel){
                // Generate a pigIndex that will be either 0 or 1
                Random rnd = new Random();
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

    // Print and add to History each time it prints
    public static void printAndAddToHistory(String str){
        System.out.println(str);
        addtoHistory(str);
    }

    // Add to history each time user types input and each time eliza returns a statement
    public static void addtoHistory(String str){
        history.add(str);
    }

    // Print history at the end of main method
    public static void printEntireHistory(){
        System.out.println("Printing chat history: ");
        for (int i=0; i<history.size(); i++){
            System.out.println(history.get(i));
        }
    }


}
