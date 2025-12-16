package analysis;

import model.Question;
import model.User;
import structure.QuestionQueue;
import structure.AnswerStack;
import dataSaving.FileManager;

public class PerformanceAnalyzer {
    public static void runAllTests() {
        testStack(100);
        testStack(150);
        testQueue(100);
        testQueue(150);
    }

    // Measure add/remove for AnswerStack using User objects
    private static void testStack(int amount) {
        AnswerStack stack = new AnswerStack(amount);
        User[] users = new User[amount];
        // Fill the array with N diff users
        for (int i = 0; i < amount; i++) {
            users[i] = new User("User" + i);
        }

        // Measure add users to the stack
        long startAdd = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            stack.push(users[i].getUsername()); 
        }
        long endAdd = System.nanoTime();

        // Measure remove users from the stack
        long startRemove = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            stack.pop();
        }
        long endRemove = System.nanoTime();

        // Cal elapsed time
        long totalAddTime = endAdd - startAdd; 
        long totalRemoveTime = endRemove - startRemove; 

        System.out.println("Stack - " + amount + " users: add = " + totalAddTime + "ns, remove = " + totalRemoveTime + "ns");
        FileManager.savePerformance("Stack", amount, totalAddTime, totalRemoveTime);
    }

    // Measure add/remove for QuestionQueue using User objects
    private static void testQueue(int amount) {
        QuestionQueue queue = new QuestionQueue(amount);
        User[] users = new User[amount];
        for (int i = 0; i < amount; i++) {
            users[i] = new User("User" + i);
        }

        long startAdd = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            Question userQ = new Question(users[i].getUsername(), "", "", "", "", "");
            queue.enqueue(userQ);
        }
        long endAdd = System.nanoTime();

        long startRemove = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            queue.dequeue();
        }
        long endRemove = System.nanoTime();

        long totalAddTime = endAdd - startAdd;
        long totalRemoveTime = endRemove - startRemove;

        System.out.println("Queue - " + amount + " users: add = " + totalAddTime + "ns, remove = " + totalRemoveTime + "ns");
        FileManager.savePerformance("Queue", amount, totalAddTime, totalRemoveTime);
    }
}
