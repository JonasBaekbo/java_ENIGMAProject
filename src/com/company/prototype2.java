package com.company;


public class prototype2 {
    public static void main(String[] args) {
        int[] cipher = {1,2,5};
        String plainText = numbersListToText(cipher);
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

        return theAlphabet.indexOf(letter);
    }


    public static char numberToLetter(int number){
        String theAlphabet = " ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅ";
        return theAlphabet.charAt(number);
    }
    public static String numbersListToText(int[] numbers){
        StringBuilder text = new StringBuilder();
        for (int number : numbers) {
            char letter = numberToLetter(number);
            text.append(letter);
        }
        return text.toString();
    }
}
