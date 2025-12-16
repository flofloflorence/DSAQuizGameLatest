package main;

import analysis.PerformanceAnalyzer;
import gui.LoginPage;

public class QuizGameMain {
    public static void main(String[] args) {
        // Run performance analysis
        System.out.println("Performance Analysis: ");
        PerformanceAnalyzer.runAllTests();
        
        // Run login page
        java.awt.EventQueue.invokeLater(() -> {
            new LoginPage().setVisible(true);
        });
    }
}
