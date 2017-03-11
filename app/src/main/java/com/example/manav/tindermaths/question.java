package com.example.manav.tindermaths;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class question {

    BufferedReader fileReader;

    String question = "question doesn't exist";
    String answer = "answer doesn't exist";
    String questionLine = "";


    public question(String filename) {
        ;readFile(filename);
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
        String[] questionLines = null;
        try {
            questionLine = fileReader.readLine();
            questionLines = questionLine.split(",");
            question = questionLines[0];
            answer = questionLines[1];
        } catch (IOException e) {
            System.out.println("IOException in Read");
        }
        return questionLines;
    }

}