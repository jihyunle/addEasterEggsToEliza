package com.company;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Eliza {
    public static void main(String[]args){

        String userInput = " ";
        boolean userQuits = false;
        String elizaSays = " ";
        int pigCount = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Good day. How are you doing today?");

        while(!userQuits){
            System.out.println("Enter your response here, or press Q to quit.");
            userInput = input.nextLine();

            // if user types a quit command
            if (userQuits = checkQuitCommand(userInput)){
                break;
            // if user types "caps"
            }else if (userInput.equalsIgnoreCase("caps")){
                System.out.println("Enter your response here, or press Q to quit.");
                userInput = input.nextLine();
                elizaSays = allCaps(userInput);
            // if user types "pig"
            }else if (userInput.equalsIgnoreCase("pig")){
                    System.out.println("Enter your response here, or press Q to quit.");
                    userInput = input.nextLine();
                    while (!userInput.equalsIgnoreCase("pig")){
                        String str = replaceWords(userInput);
                        elizaSays = pigLatin(str);
                    }
            }else{
                elizaSays = hedgeOrQualifier(userInput);
            }

            System.out.println(elizaSays);

        }

        System.out.println(">>> END");
        input.close();
        System.exit(0);
    }

    public static String hedgeOrQualifier(String userInput){
        String elizaSays = "";
        // After user input is read, generate a random number between 0 and 1
        Random rnd = new Random();
        int responseOption = rnd.nextInt(2);
        if(responseOption==1){
            // call method that randomly chooses hedge
            return elizaSays = respondWithHedges();

        }else{
            // call method that first replaces words in user input
            // then prepends the qualifier
            return elizaSays = respondWithQualifiers(userInput);
        }
    }

    public static String allCaps(String str){
        String newStr = str.toUpperCase();
        return newStr;
    }

    public static String pigLatin(String str){

        String newStr = "";
        char firstletter = str.toLowerCase().charAt(0);
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        // eliza speaks in pig latin
        for(int i=0; i<vowels.length; i++){
            // if first letter vowel, append "way" or "tay" randomly chosen
            if (firstletter == vowels[i]){
                int num = (int)Math.random()*2;
                if (num==0){
                    // append "way"
                    newStr = str + "way";
                }else{
                    // append "tay"
                    newStr = str + "tay";
                }
            }
            // else if first letter consonant, append "ay"
            else {
                newStr = str + "ay";

            }

        }
        return newStr;

    }

    public static String respondWithHedges(){

        String[] hedges = {"Please tell me more",
                "Many of my patients tell me the same thing",
                "It is getting late, maybe we had better quit"};

        Random rnd = new Random();
        int index = rnd.nextInt(hedges.length);
        return hedges[index];
    }

    public static String respondWithQualifiers(String str){

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

        // Use shorthand to loop each element inside array
        for(String word: words){

            // Lower Case all letters
            word = word.toLowerCase();

            //    replace i with you
            //    replace me with you
            //    replace my with your
            //    replace am with are

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

    public static boolean checkQuitCommand(String str){
        // initialize default bool as false
        boolean quit = false;
        // bool changes to true if quit commands are typed
        if (str.equalsIgnoreCase("Q") || str.equalsIgnoreCase("i am feeling great")) {
            quit = true;
        }
        return quit;
    }


}
