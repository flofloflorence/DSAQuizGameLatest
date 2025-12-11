/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

/**
 *
 * @author Hp
 */
public class AnswerStack {
    private String[] stack;
    private int top;

    public AnswerStack(int capacity) {
        stack = new String[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public void push(String value) {
        if (isFull()) {
            System.out.println("Stack overflow.");
            return;
        }
        stack[++top] = value;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow.");
            return null;
        }
        return stack[top--];
    }

    public String peek() {
        if (isEmpty()) return null;
        return stack[top];
    }
}
// this is a simple implementation of an AnswerStack class for storing answers in a stack data structure.