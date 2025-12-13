/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataSaving;

import model.Question;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author Hp
 */

public class FileManager {
    public static final String QUESTIONS_FILE = "questions.txt";
    public static final String LEADERBOARD_FILE = "leaderboard.txt";
    public static final String ANALYSIS_FILE = "analysis.txt";

    public static List<Question> loadQuestions() {
        File f = new File(QUESTIONS_FILE);
        if (!f.exists()) {
            System.out.println("questions.txt not found. Loading default questions.");
            return getDefaultQuestions();
        }

        List<Question> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] p = line.split(";");

                if (p.length == 6) {
                    list.add(new Question(p[0], p[1], p[2], p[3], p[4],
                            Integer.parseInt(p[5].trim())));
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file. Using default questions.");
            return getDefaultQuestions();
        }

        return list.isEmpty() ? getDefaultQuestions() : list;
    }

    private static List<Question> getDefaultQuestions() {
        List<Question> list = new ArrayList<>();
        list.add(new Question("Which data structure uses FIFO?", "Stack", "Queue", "Tree", "Graph", 2));
        list.add(new Question("Which DS uses LIFO?", "Queue", "Graph", "Stack", "Array", 3));
        list.add(new Question("Binary search complexity?", "O(n)", "O(n log n)", "O(log n)", "O(1)", 3));
        list.add(new Question("Which is non-linear?", "Array", "Queue", "Stack", "Tree", 4));
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
