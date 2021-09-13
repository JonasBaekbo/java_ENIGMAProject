package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class prototype {
    public static void main(String[] args) {
        // write your code here
        Scanner userInput = new Scanner(System.in);
        System.out.println("Hej og velkommen til!");
        System.out.println("Vil du gerne \033[1mE\033[0mncode eller \033[1mD\033[0mecode");
        if (userInput.nextLine().charAt(0) == 'e'){
            System.out.println("Du har valgt at Encode en tekst! \nSkriv venligst noget tekst i store bogstaver som jeg kan encode for dig");
            String text = fromLettersToNumbers(userInput.nextLine());
            System.out.printf("Jeg har encoded din tekst til følgende:\n%s", text);

        }else{
            System.out.println("Du har valgt at Encode en tekst! \nSkriv venligst nogle tal, adskilt af et komma (mellemrum som 0) som jeg kan decode for dig\nEksempel: 2,3,4,1,0,2,5");
            String text = userInput.nextLine();
            System.out.printf("Jeg har decoded din tekst til følgende tekst:\n%s", fromNumbersToLetters(text));

        }




    }

    public static String fromLettersToNumbers(String word) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅ"; // Hænger sammen med linje 36 - se kommentar
        int[] letternumber = new int [word.length()]; // Hænger sammen med linje 30 og 36 se kommentar
        for(int i =0; i<word.length(); i++){
            if(word.charAt(i) == ' '){
                letternumber[i] =  0;
            }else{
                letternumber[i] =  alphabet.indexOf(word.charAt(i)+1); // Fundet på nettet - https://stackoverflow.com/questions/8879714/how-to-get-numeric-position-of-alphabets-in-java
            }

        }
        return Arrays.toString(letternumber);
    }
    public static String fromNumbersToLetters(String numbers) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅ"; // Hænger sammen med linje 30 - se kommentar
        String[] tokens = numbers.split(","); // Hænger sammen med linje 47
        int[] numbersForLetter = new int[tokens.length]; // Hænger sammen med linje 47
        char[] letterForNumber = new char[tokens.length]; // Hænger sammen med linje 47
        StringBuilder text = new StringBuilder(); // Fundet på nettet - https://www.baeldung.com/java-array-to-string
        for (int i = 0; i < tokens.length; i++) {
            numbersForLetter[i] = Integer.parseInt(tokens[i]);
            if (numbersForLetter[i] == 0){
                letterForNumber[i] = ' ';
                text.append(letterForNumber[i]); // Hænger sammen med linje 47
            }else{
                letterForNumber[i] = alphabet.charAt(numbersForLetter[i]-1);
                text.append(letterForNumber[i]); // Hænger sammen med linje 47
            }
        }
        return text.toString(); // Hænger sammen med linje 47
    }
}
