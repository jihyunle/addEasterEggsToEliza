package com.company;/*
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

public class addEasterEggsToEliza {

    public static void main(String[]args){

        Eliza myEliza = new Eliza();


        String userInput = "";
        String str = "";
        String newStr = "";
        int num = -1;

        if (userInput.equalsIgnoreCase("pig")){
            System.out.println("Now speaking Pig Latin!");
            // call method pigLatin
            newStr = pigLatin(str);
        }

        else if (userInput.equalsIgnoreCase("caps")){
            System.out.println("Now showing text in all caps");
            // call method allCaps
            newStr = allCaps(str);
        }

        else if (userInput.equalsIgnoreCase("play game")){
            System.out.println("Now playing BlackJack");
            // copy and paste the BlackJack game from earlier
//            num = playBlackJack();

        }

        else if (userInput.equalsIgnoreCase("red")){
            System.out.println("Now showing text in red");
            // call method redText
        }

        // At the end, print chat history


    }

//    public static int playBlackJack(){
//
//    }

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
}
