
package com.mycompany.quizgame_dsa;
import gui.StartPage;
public class QuizGameMain
{

    public static void main(String[] args) 
    {
        java.awt.EventQueue.invokeLater(() -> {
            new StartPage().setVisible(true);
        });

    }
}
