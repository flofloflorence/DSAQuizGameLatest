/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analysis;

import model.Question;
import structure.QuestionQueue;
import structure.AnswerStack;

/**
 *
 * @author Hp
 */

public class PerformanceAnalyzer {
    public static long timeAddQueue(int n) {
        QuestionQueue q = new QuestionQueue(n + 10);
        long start = System.nanoTime();
        for (int i = 0; i < n; i++)
            q.enqueue(new Question("U" + i, "", "", "", "", 1));
        return (System.nanoTime() - start) / 1_000_000;
    }

    public static long timeRemoveQueue(int n) {
        QuestionQueue q = new QuestionQueue(n + 10);
        for (int i = 0; i < n; i++)
            q.enqueue(new Question("U" + i, "", "", "", "", 1));
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) q.dequeue();
        return (System.nanoTime() - start) / 1_000_000;
    }

    public static long timeAddStack(int n) {
        AnswerStack s = new AnswerStack(n + 10);
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) s.push("User" + i);
        return (System.nanoTime() - start) / 1_000_000;
    }

    public static long timeRemoveStack(int n) {
        AnswerStack s = new AnswerStack(n + 10);
        for (int i = 0; i < n; i++) s.push("User" + i);
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) s.pop();
        return (System.nanoTime() - start) / 1_000_000;
    }
}
