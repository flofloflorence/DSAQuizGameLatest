
package com.mycompany.quizgame_dsa;
import gui.LoginPage;
public class QuizGameMain
{

    public static void main(String[] args) 
    {
        java.awt.EventQueue.invokeLater(() -> {
            new LoginPage().setVisible(true);
        });

    }
}
