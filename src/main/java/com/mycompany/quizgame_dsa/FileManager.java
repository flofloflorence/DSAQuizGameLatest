/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizgame_dsa;

/**
 *
 * @author Hp
 */
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileManager {
    public static final String QUESTIONS_FILE = "questions.txt";
    public static final String LEADERBOARD_FILE = "leaderboard.txt";
    public static final String ANALYSIS_FILE = "analysis.txt";

    public static List<QuizQuestion> loadQuestions() {
        File f = new File(QUESTIONS_FILE);
        if (!f.exists()) {
            System.out.println("questions.txt not found. Loading default questions.");
            return getDefaultQuestions();
        }

        List<QuizQuestion> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] p = line.split(";");

                if (p.length == 6) {
                    list.add(new QuizQuestion(p[0], p[1], p[2], p[3], p[4],
                            Integer.parseInt(p[5].trim())));
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file. Using default questions.");
            return getDefaultQuestions();
        }

        return list.isEmpty() ? getDefaultQuestions() : list;
    }

    private static List<QuizQuestion> getDefaultQuestions() {
        List<QuizQuestion> list = new ArrayList<>();
        list.add(new QuizQuestion("Which data structure uses FIFO?", "Stack", "Queue", "Tree", "Graph", 2));
        list.add(new QuizQuestion("Which DS uses LIFO?", "Queue", "Graph", "Stack", "Array", 3));
        list.add(new QuizQuestion("Binary search complexity?", "O(n)", "O(n log n)", "O(log n)", "O(1)", 3));
        list.add(new QuizQuestion("Which is non-linear?", "Array", "Queue", "Stack", "Tree", 4));
        return list;
    }

    public static void appendLeaderboard(String name, int score, int total) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LEADERBOARD_FILE, true))) {
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            bw.write(name + " | Score: " + score + "/" + total + " | " + time);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing leaderboard.");
        }
    }

    public static List<String> readLeaderboard() {
        List<String> lines = new ArrayList<>();
        File f = new File(LEADERBOARD_FILE);

        if (!f.exists()) return lines;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) lines.add(line);
        } catch (IOException e) {
            System.out.println("Error loading leaderboard.");
        }

        return lines;
    }

    public static void appendAnalysis(String text) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ANALYSIS_FILE, true))) {
            bw.write(text);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Unable to write analysis.");
        }
    }
}

// this is a simple implementation of a FileManager class for handling file operations in the quiz system