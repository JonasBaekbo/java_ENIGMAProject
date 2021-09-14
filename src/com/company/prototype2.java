package com.company;

import java.util.Arrays;

public class prototype2 {
    public static void main(String[] args) {
        int cipher[] = {1,2,5};
        String plainText = numbersListtoText(cipher);
        System.out.println(plainText);

        /*
        Text To Number
        String plainText = "ABE";
        int[] cipherText = textToNumbersList(plainText);
        System.out.println(Arrays.toString(cipherText));
        */
    }
    public static int[] textToNumbersList(String text){
        int[] list = new int[text.length()];
        for (int i = 0; i<text.length(); i++){
            list[i] = letterToNumber(text.charAt(i));
        }

        return list;
    }
    public static int letterToNumber(char letter){
        String theAlphabet = " ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅ";
        int number = theAlphabet.indexOf(letter);

        return number;
    }


    public static char numberToLetter(int number){
        String theAlphabet = " ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅ";
        char letter = theAlphabet.charAt(number);
        return letter;
    }

    public static String numbersListtoText(int[] numbers){
        String text = "";
        for (int i=0; i<numbers.length; i++){
            int number = numbers[i];

            char letter = numberToLetter(number);
            text = text + letter;
        }
        return text;
    }
}
