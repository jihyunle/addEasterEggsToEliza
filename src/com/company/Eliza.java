package com.company;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Eliza {
    public static void main(String[]args){

        Scanner input = new Scanner(System.in);
        System.out.println("Good day. How are you doing today?");

        String userInput = " ";
        boolean userQuit = false;
        String elizaSays = " ";

        while(!userQuit){
            System.out.println("Enter your response here, or press Q to quit.");
            userInput = input.nextLine();

            // Check if user wants to quit
            if (userQuit = checkQuitCommand(userInput)){
                break;
            }


            System.out.println();

            // After user input is read, generate a random number between 0 and 1
            Random rnd = new Random();
            int responseOption = rnd.nextInt(2);
            if(responseOption==1){
                // call method that randomly chooses hedge
                elizaSays = respondWithHedges();

            }else{
                // call method that first replaces words in user input
                // then prepends the qualifier
                elizaSays = respondWithQualifiers(userInput);
            }

            System.out.println(elizaSays);
            System.out.println();
        }

        System.out.println(">>> END");
        input.close();
        System.exit(0);
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

        boolean quit = false;
        if (str.equalsIgnoreCase("Q") || str.equalsIgnoreCase("i am feeling great")) {
            quit = true;
        }
        return quit;
    }


}
