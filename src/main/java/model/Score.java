package model;

public class Score {
    private int correctAnswers;
    private int totalQuestions;
    
    public Score(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = 0;
    }
    
    public void addCorrect() {
        correctAnswers++;
    }
    
    public int getCorrectAnswers() {
        return correctAnswers;
    }
    
    public int getTotalQuestions() {
        return totalQuestions;
    }
    
    public double getPercentage() {
        if (totalQuestions == 0)
            return 0.0;
        else
            return (correctAnswers * 100.0) / totalQuestions;
    }
}
