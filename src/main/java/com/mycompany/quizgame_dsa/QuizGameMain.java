/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quizgame_dsa;

import javax.swing.SwingUtilities;
//import analysis.PerformanceAnalyzer;
import gui.StartPage;

/**
 *
 * @author Hp
 */
public class QuizGameMain {

    public static void main(String[] args) {
         // Run performance analysis once at startup
//        PerformanceAnalyzer.runAllTests();

        // Start GUI on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new StartPage().setVisible(true);
        });
    }
}
