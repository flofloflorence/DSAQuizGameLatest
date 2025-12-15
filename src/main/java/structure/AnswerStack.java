
package structure;
public class AnswerStack {
    private String[] answers;
    private int top;

    public AnswerStack(int capacity) {
        answers = new String[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == answers.length - 1;
    }

    public void push(String value) {
        if (isFull()) {
            System.out.println("Stack overflow.");
            return;
        }
        answers[++top] = value;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow.");
            return null;
        }
        return answers[top--];
    }

    public String peek() {
        if (isEmpty()) return null;
        return answers[top];
    }
    
    public int size() {
        return top + 1;
    }
}
