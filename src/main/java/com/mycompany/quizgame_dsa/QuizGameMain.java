package com.mycompany.quizgame_dsa;

import analysis.PerformanceAnalyzer;
import gui.LoginPage;

public class QuizGameMain {
    public static void main(String[] args) {
        // Run performance analysis
        System.out.println("Performanace Analysis: ");
        PerformanceAnalyzer.runAllTests();
        
        // Run login page
        java.awt.EventQueue.invokeLater(() -> {
            new LoginPage().setVisible(true);
        });
    }
}
