package com.company;

import java.util.Arrays;

public class prototype2 {
    public static void main(String[] args) {
        String plainText = "ABE";
        int[] cipherText = textToNumbersList(plainText);
        System.out.println(Arrays.toString(cipherText));
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
}
