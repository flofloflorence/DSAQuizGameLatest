/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizgame_dsa;

/**
 *
 * @author Hp
 */
public class QuizQuestion {
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private int correctOption; // 1-4

    public QuizQuestion(String questionText, String optionA, String optionB,
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
    public String getOptionA() { return optionA; }
    public String getOptionB() { return optionB; }
    public String getOptionC() { return optionC; }
    public String getOptionD() { return optionD; }
    public int getCorrectOption() { return correctOption; }
}
// this is just example code for a QuizQuestion class can refer or add your own twist