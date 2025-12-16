package analysis;

import model.Question;
import model.User;
import structure.QuestionQueue;
import structure.AnswerStack;
import dataSaving.FileManager;

public class PerformanceAnalyzer {
    // Run all required tests (call this once, e.g. from a menu button)
    public static void runAllTests() {
        testStack(100);
        testStack(150);
        testQueue(100);
        testQueue(150);
    }

    // Measure add/remove for AnswerStack using User objects
    private static void testStack(int count) {
        AnswerStack stack = new AnswerStack(count);
        User[] users = new User[count];
        // Fill the array with N diff users
        for (int i = 0; i < count; i++) {
            users[i] = new User("User" + i);
        }

        // Measure add users to the stack
        long startAdd = System.nanoTime();
        for (int i = 0; i < count; i++) {
            stack.push(users[i].getUsername()); // Store username on the stack
        }
        long endAdd = System.nanoTime();

        // Measure remove users from the stack
        long startRemove = System.nanoTime();
        for (int i = 0; i < count; i++) {
            stack.pop();
        }
        long endRemove = System.nanoTime();

        // Cal elapsed time
        long addTimeNs = endAdd - startAdd; // Total time to push N usernames to the stack
        long removeTimeNs = endRemove - startRemove; // Total time to remove N username from the stack

        System.out.println("Stack - " + count + " users: add = " + addTimeNs + "ns, remove = " + removeTimeNs + "ns");
        FileManager.savePerformance("Stack", count, addTimeNs, removeTimeNs);
    }

    // Measure add/remove for QuestionQueue using User objects
    private static void testQueue(int count) {
        QuestionQueue queue = new QuestionQueue(count);
        User[] users = new User[count];
        for (int i = 0; i < count; i++) {
            users[i] = new User("User" + i);
        }

        long startAdd = System.nanoTime();
        for (int i = 0; i < count; i++) {
            Question userQ = new Question(users[i].getUsername(), "", "", "", "", "");
            queue.enqueue(userQ);
        }
        long endAdd = System.nanoTime();

        long startRemove = System.nanoTime();
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        long endRemove = System.nanoTime();

        long addTimeNs = endAdd - startAdd;
        long removeTimeNs = endRemove - startRemove;

        System.out.println("Queue - " + count + " users: add = " + addTimeNs + "ns, remove = " + removeTimeNs + "ns");
        FileManager.savePerformance("Queue", count, addTimeNs, removeTimeNs);
    }
}
