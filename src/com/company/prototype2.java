package com.company;

public class prototype2 {
    public static void main(String[] args) {
        char letter = 'B';
        int number = letterToNumber(letter);
        System.out.printf("Bogstavet %c bliver til %d", letter, number);
    }
    public static int[] textToNumbersList(String text){
        return new int[0];
    }
    public static int letterToNumber(char letter){
        String theAlphabet = " ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅ";
        int number = theAlphabet.indexOf(letter);

        return number;
    }
}
