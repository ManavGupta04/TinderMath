package com.example.manav.tindermaths;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class question {

    BufferedReader fileReader;

    String question = "question doesn't exist";
    String answer = "answer doesn't exist";
    String questionLine = "";


    public question(String filename) {
        //readFile(filename);
    }



    public void readFile(String filename) {
        FileReader questionFile = null;

        try {

            questionFile = new FileReader(filename);
            fileReader = new BufferedReader(questionFile);
        } catch (FileNotFoundException e) {
            System.out.println("Find Not Found");
        }
    }

    public String[] getNextQuestion()
    {
        /*String[] questionLines = null;
        try {
            questionLine = fileReader.readLine();
            questionLines = questionLine.split(",");
            question = questionLines[0];
            answer = questionLines[1];
        } catch (IOException e) {
            System.out.println("IOException in Read");
        }*/
        Random rand = new Random();
        int x = rand.nextInt(10)+1;
        int y = rand.nextInt(10)+1;
        int result = x+y;
        String correct = "TRUE";
        if(rand.nextInt(1) == 0){
            result = rand.nextInt(20)+1;
            if(result != x+y){
                correct = "FALSE";
            }
        }
        String[] hardCode = new String[2];
        hardCode[0] = Integer.toString(x) + "+" + Integer.toString(y) + "=" + Integer.toString(result);
        hardCode[1] = correct;
        return hardCode;
    }

}