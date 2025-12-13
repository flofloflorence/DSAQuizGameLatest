/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hp
 */

public class Question {
    private String questionText; // stores questions
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private int correctOption; // 1-4

    public Question(String questionText, String optionA, String optionB,
                        String optionC, String optionD, int correctOption) {
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }
    
    public String getOptionA() { 
        return optionA; 
    }
    
    public String getOptionB() { 
        return optionB; 
    }
    
    public String getOptionC() { 
        return optionC; 
    }
    
    public String getOptionD() {
        return optionD; 
    }
    
    public int getCorrectOption() { 
        return correctOption; 
    }
}
