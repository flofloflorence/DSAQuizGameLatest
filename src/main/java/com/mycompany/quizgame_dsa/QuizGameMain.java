
package com.mycompany.quizgame_dsa;
import gui.LoginPage;
import analysis.PerformanceAnalyzer;

public class QuizGameMain {
    public static void main(String[] args) {
        PerformanceAnalyzer.runAllTests();
        
        java.awt.EventQueue.invokeLater(() -> {
            new LoginPage().setVisible(true);
        });

    }
}
