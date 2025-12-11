/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizgame_dsa;

/**
 *
 * @author Hp
 */
public class QuestionQueue {
    private QuizQuestion[] data;
    private int front;
    private int rear;
    private int size;

    public QuestionQueue(int capacity) {
        data = new QuizQuestion[capacity];
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

    public void enqueue(QuizQuestion q) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        rear = (rear + 1) % data.length;
        data[rear] = q;
        size++;
    }

    public QuizQuestion dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        QuizQuestion temp = data[front];
        front = (front + 1) % data.length;
        size--;
        return temp;
    }

    public int size() {
        return size;
    }
}
// this is sample of this class you can refer and modify to your liking