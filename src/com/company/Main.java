package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        // repeat always - until system.exit
        while(true) {
            System.out.println("Velkommen til Enigma-projektet!");
            System.out.println("Vælg mellem følgende former for kryptering:");
            System.out.println(" 1) Number cipher");
            System.out.println(" 2) Caesar cipher");
            System.out.println(" 3) Vigenère cipher");
            System.out.println(" 0) afslut program");
            System.out.print("Skriv venligst 0-3: ");
            int type = userInput.nextInt();
            userInput.nextLine(); // FIX: Scanner Bug to ignore empty line
            if (type == 1) {
                System.out.println("Number cipher");
                System.out.println("-------------");
            } else if (type == 2) {
                System.out.println("Caesar cipher");
                System.out.println("-------------");
            } else if (type == 3) {
                System.out.println("Vigenère cipher");
                System.out.println("---------------");
            } else if (type == 0) {
                System.out.println("Du har afsluttet programmet");
                System.exit(0);
            }

            System.out.println("Vil du (e)ncrypte eller (d)ecrypte?");
            char mode = userInput.nextLine().charAt(0);

            if (type == 1 && mode == 'e') {
                encryptNumberMenu();
            } else if (type == 1 && mode == 'd') {
                decryptNumberMenu();
            } else if (type == 2 && mode == 'e') {
                encryptCaesarMenu();
            } else if (type == 2 && mode == 'd') {
                decryptCaesarMenu();
            } /*else if (type == 3 && mode == 'e') {
                vigenereCipherEncryptMenu();
            } else if (type == 3 && mode == 'd') {
                vigenereCipherDecryptMenu();
            }*/
        }
    }

    public static String listOfNumbersToText( int[] numbers ) {
        StringBuilder text = new StringBuilder();
        for (int number : numbers) {
            char letter = numberToLetter(number);
            text.append(letter);
        }
        return text.toString();
    }

    public static char numberToLetter( int number ) {
        String theAlphabet = " ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅ";
        return theAlphabet.charAt(number);
    }

    public static int[] textToListOfNumbers( String text ) {
        int[] list = new int[text.length()];
        for (int i = 0; i<text.length(); i++){
            list[i] = letterToNumber(text.charAt(i));
        }

        return list;
    }

    public static int letterToNumber( char letter ) {
        String theAlphabet = " ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅ";

        return theAlphabet.indexOf(letter);
    }


    // * NUMBER CIPHER
    public static void encryptNumberMenu() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Skriv venligst nogle tegn med store bogstaver:");
        String plainText = userInput.nextLine();
        int[] cipherText = textToListOfNumbers(plainText);
        System.out.printf("Dine krypterede talrække er: %s", Arrays.toString(cipherText));

    }

    public static void decryptNumberMenu() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Skriv venligst en krypteret talrække:");
        int[] cipher = {userInput.nextInt()};
        String plainText = listOfNumbersToText(cipher);
        System.out.println(plainText);
    }

    // Caesar
    public static void decryptCaesarMenu() {
        Scanner userInput = new Scanner(System.in);
        // beder brugeren om ciphertext
        System.out.println("Skriv venligst en tekst med store bogstaver som vil blive krypteret:");
        String cipherText = userInput.nextLine();
        // beder brugeren om shift-værdi
        System.out.println("Skriv nu venligst en shift værdi:");
        int shift = userInput.nextInt();
        // kalder caesarDecrypt med ciphertext og shift-værdi
        String plainText = caesarEncrypt(cipherText, shift);
        // udskriver plaintext modtaget fra ovenstående
        System.out.printf("Din krypterede tekst er: %s", plainText);
    }

    public static void encryptCaesarMenu() {
        Scanner userInput = new Scanner(System.in);

        // beder brugeren om plaintext
        System.out.println("Skriv venligst en tekst med store bogstaver som vil blive krypteret:");
        String plainText = userInput.nextLine();
        // beder brugeren om shift-værdi
        System.out.println("Skriv nu venligst en shift værdi:");
        int shift = userInput.nextInt();
        // kalder caesarEncrypt med ciphertext og shift-værdi
        String cipherText = caesarEncrypt(plainText, shift);
        // udskriver ciphertext modtaget fra ovenstående
        System.out.printf("Din krypterede tekst er: %s", cipherText);
    }

    public static String caesarEncrypt( String plainText, int shift ) {
        // textToListOfNumbers
        int[] numbers = textToListOfNumbers(plainText);
        // shiftListOfNumbers
        numbers = shiftListOfNumbers(numbers, shift);
        String cipherText = Arrays.toString(numbers);
        return cipherText;
    }


    public static String caesarDecrypt( String ciphertext, int shift ) {
        // textToListOfNumbers
        // shiftListOfNumbers
        // listOfNumbersToText
        return "";
    }

    public static int[] shiftListOfNumbers( int[] numbers, int shift ) {
        // kald shiftNumber for hvert tal i numbers
        // - men ikke mellemrum!
        for (int i=0; i<numbers.length; i++){
            if (numbers[i] == 0){
                numbers[i]= 0;
            }else{
              numbers[i] =  shiftNumber(numbers[i], shift);
            }
        }
        return numbers;
    }

    public static int shiftNumber( int number, int shift ) {
        int shiftedNumber = number+shift;
        return shiftedNumber;
    }



    // VIGENÈRE
    private static void vigenereCipherEncryptMenu() {
    }
    private static void vigenereCipherDecryptMenu() {
    }
}