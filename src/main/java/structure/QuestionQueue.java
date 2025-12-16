package structure;

import model.Question;

// Store questions in a queue data structure (FIFO)
// Store users for performance analysis
public class QuestionQueue {
        private Question[] questions;
        private int front;
        private int rear;
        private int size;

    public QuestionQueue(int capacity) {
        questions = new Question[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == questions.length;
    }

    public void enqueue(Question q) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        rear = (rear + 1) % questions.length;
        questions[rear] = q;
        size++;
    }

    public Question dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        Question temp = questions[front];
        front = (front + 1) % questions.length;
        size--;
        return temp;
    }

    public int size() {
        return size;
    }
}
