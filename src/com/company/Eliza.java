package com.company;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Eliza {
    public static void main(String[]args){
        String userInput = "";
        String elizaSays = "";
        boolean userQuits = false;

        Scanner input = new Scanner(System.in);
        System.out.println("Good day. How are you doing today?");

        while(!userQuits){
            System.out.println("Enter your response here, or press Q to quit.");
            userInput = input.nextLine();

            // if user types a quit command, the bool value of userQuits becomes true
            if (userQuits = getQuitCommand(userInput)){
                break;
            }

            // if user types "pig"
            while (userInput.equalsIgnoreCase("pig")){
                // Recognize command to activate pig mode
                System.out.println("Now speaking in Pig Latin!");

                // Prompt user again for a question
                System.out.println("Enter your response here, or press Q to quit.");
                String str = input.nextLine();

                // Loop within pig mode until user types "pig" again
                // If user types anything besides "pig", proceed with pig latin
                if(!str.equalsIgnoreCase("pig")){
                    String strTwo = replaceWords(str);
                    elizaSays = getPigLatin(strTwo);
                }



            }


            // if user types "caps"
            else if (userInput.equalsIgnoreCase("caps")){
                System.out.println("Enter your response here, or press Q to quit.");
                userInput = input.nextLine();
                elizaSays = getCaps(userInput);
            }

            // if user types "play game"
            else if (userInput.equalsIgnoreCase("play game")){
                System.out.println("Now playing BlackJack");
                // copy and paste the BlackJack game from earlier
//            num = playBlackJack();
            }

            // if user types "red"
            else if (userInput.equalsIgnoreCase("red")){
                System.out.println("Now showing text in red");
                // call method redText
            }


            System.out.println(elizaSays);
        }


        // Add a step at the end that prints chat history
        System.out.println(">>> END");
        input.close();
        System.exit(0);
    }


//    public static String getCaps(String str){
//        String newStr = str.toUpperCase();
//        return newStr;
//    }

//    public static String getPigLatin(String str) {
//        String[] words = str.split(" ");
//        String newStr = "";
//        String newWord = "";
//        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
//
//        // Loop through each word in the string
//        for (String word : words) {
//            char firstChar = word.toLowerCase().charAt(0);
//
//            // Loop through and test each vowel
//            for (int i = 0; i < vowels.length; i++) {
//                // If first letter is a vowel, append "way" or "tay", randomly chosen
//                if (firstChar == vowels[i]) {
//                    // Generate random number
//                    int num = (int) Math.random() * 2;
//                    if (num == 0) {
//                        // append "way"
//                        newWord = word + "way";
//                    } else {
//                        // append "tay"
//                        newWord = word + "tay";
//                    }
//                }
//                // If first letter is a consonant, append "ay"
//                else {
//                    newWord = word + "ay";
//                }
//            }
//        }
//
//        // Concatenate the contents of the array back into a String
//        newStr += newWord + " ";
//        return newStr;
//    }

//    public static String getElizaSays(String userInput){
//        String elizaSays = "";
//        // After user input is read, generate a random number between 0 and 1
//        Random rnd = new Random();
//        int responseOption = rnd.nextInt(2);
//        if(responseOption==1){
//            // call method that randomly chooses hedge
//            return elizaSays = replyWithHedge();
//        }else{
//            // call method that first replaces words in user input
//            // then prepends the qualifier
//            return elizaSays = replyWithQualifier(userInput);
//        }
//    }

//    public static String replyWithHedge(){
//        String[] hedges = {"Please tell me more",
//                "Many of my patients tell me the same thing",
//                "It is getting late, maybe we had better quit"};
//        Random rnd = new Random();
//        int index = rnd.nextInt(hedges.length);
//        return hedges[index];
//    }
//
//    public static String replyWithQualifier(String str){
//        String replacedStr = replaceWords(str);
//        String[] qualifiers = {"Why do you say that ",
//                "You seem to think that ",
//                "So, you are concerned that "};
//        Random rnd = new Random();
//        int index = rnd.nextInt(qualifiers.length);
//        String newStr = qualifiers[index] + replacedStr;
//        return newStr;
//    }
//
//    public static String replaceWords(String str){
//        String[] words = str.split(" ");
//        String newStr = "";
//
//        for(String word: words){
//            // Lower Case all letters
//            word = word.toLowerCase();
//            // If HashMap contains key, swap out key for value
//            HashMap<String, String> myMap = new HashMap<>();
//            myMap.put("i", "you");
//            myMap.put("me", "you");
//            myMap.put("my", "your");
//            myMap.put("am", "are");
//
//            if(myMap.containsKey(word)){
//                word = myMap.get(word);
//            }
//            // Concatenate the contents of the array back into a String
//            newStr += word + " ";
//        }
//        return newStr;
//    }

//    public static boolean getQuitCommand(String str){
//        // initialize default bool as false
//        boolean quit = false;
//        // bool changes to true if quit commands are typed
//        if (str.equalsIgnoreCase("Q") || str.equalsIgnoreCase("i am feeling great")) {
//            quit = true;
//        }
//        return quit;
//    }


}
