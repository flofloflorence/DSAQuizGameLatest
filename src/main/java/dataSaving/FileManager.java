package dataSaving;

import model.Question;
import java.io.*; // Write and read files 
import java.util.*; // Import HashMap class to store key/value pairs
import java.time.LocalDateTime;

public class FileManager {
    
    // File names
    public static final String USERS_FILE = "users.txt";
    public static final String QUESTIONS_FILE = "questions.txt";
    public static final String SCORE_FILE = "score.txt";
    public static final String PERFORMANCE_FILE = "performance.txt";

    //  1. Save user when register
    public static void saveUser(String username, String password) {
        try (FileWriter fw = new FileWriter(USERS_FILE, true)) {
            fw.write(username + ";" + password + "\n"); 
        } catch (IOException e) {
            System.out.println("Unable to save user.");
        }
    }

    // Load users for login to check username
    public static Map<String, String> loadUsers() {
        Map<String, String> users = new HashMap<>(); // Store users in key/value pairs
        File f = new File(USERS_FILE);
        if (!f.exists()) 
            return users;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;

                String[] p = line.split(";", -1);
                if (p.length != 2) continue;

                String username = p[0].trim();
                String password = p[1].trim();
                if (!username.isEmpty() && !password.isEmpty()) {
                    users.put(username, password);
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to load users.");
        }
        return users;
    }
    
    // 2. Load Questions (The Correct New Version)
    public static List<Question> loadQuestions() {
        List<Question> list = new ArrayList<>();
        File f = new File(QUESTIONS_FILE);

        // If file doesn't exist, just return the empty list
        if (!f.exists()) {
            System.out.println("questions.txt not found.");
            return list; 
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split by semicolon
                String[] p = line.split(";"); 

                // We expect 6 parts: Question + 4 Options + Answer
                if (p.length == 6) {
                    Question q = new Question(
                        p[0].trim(), // Question Text
                        p[1].trim(), // Option A
                        p[2].trim(), // Option B
                        p[3].trim(), // Option C
                        p[4].trim(), // Option D
                        p[5].trim()  // Correct Answer (String)
                    );
                    list.add(q);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        return list;
    }
    
    // 3. Save user score with time
    public static void saveScore(String username, int correct, int total, double percentage) {
        try (FileWriter fw = new FileWriter(SCORE_FILE, true)) {
            fw.write(LocalDateTime.now() + "," + username + "," + correct + "/" + total + "," + percentage + "%\n");
        } catch (IOException e) {
            System.out.println("Unable to save user score.");
        }
    }

    // 4. Save performance analysis
    public static void savePerformance(String structureName, int count, long addTimeNs, long removeTimeNs) {
        try (FileWriter fw = new FileWriter(PERFORMANCE_FILE, true)) {
            fw.write(LocalDateTime.now() + ", " + structureName + ", " + count + ", add = " + addTimeNs + "ns, remove = " + removeTimeNs + "ns\n");
        } catch (IOException e) {
            System.out.println("Unable to save performance.");
        }
    }
}

