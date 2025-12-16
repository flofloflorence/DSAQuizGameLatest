package structure;

import model.Question;

// Store questions in a queue data structure (FIFO)
// Store users for performance analysis
public class QuestionQueue {
        private Question[] data;
        private int front;
        private int rear;
        private int size;

    public QuestionQueue(int capacity) {
        data = new Question[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public void enqueue(Question q) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        rear = (rear + 1) % data.length;
        data[rear] = q;
        size++;
    }

    public Question dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        Question temp = data[front];
        front = (front + 1) % data.length;
        size--;
        return temp;
    }

    public int size() {
        return size;
    }
}
