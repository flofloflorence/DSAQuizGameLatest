package gui;

import java.awt.Color;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.plaf.basic.BasicButtonUI;
import structure.QuestionQueue;
import structure.AnswerStack;
import model.Question;

public class QuestionPage extends javax.swing.JFrame {

    private final QuestionQueue questionQueue;
    private Question currentQuestion;
    private AnswerStack answerStack;
    private int score = 0;
    private int totalQuestions;
    private int questionNumber = 1;
    private boolean answered = false;
    private javax.swing.Timer timer;
    private int timeLeft = 15;

    public QuestionPage(QuestionQueue questionQueue)
    {
        this.questionQueue = questionQueue;
        this.answerStack = new AnswerStack(20);
        this.totalQuestions = questionQueue.size();
        initComponents();
        Color transparent = new Color(0, 0, 0, 0); // Define a completely transparent color (Red, Green, Blue, Alpha)
        jScrollPane1.getViewport().setBackground(transparent); // Force the ScrollPane and Viewport to use this transparent color
        jScrollPane1.getViewport().setOpaque(false); // Force the ScrollPane and Viewport to be opaque
        // Centering of the question in jTextPane1
        StyledDocument doc = jTextPane1.getStyledDocument(); // Grab the internal document model of the jTextPane1
        SimpleAttributeSet center = new SimpleAttributeSet(); // Define a "style" that has Center Alignment
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false); // Apply this style to the entire paragraph
        jTextPane1.setCaretPosition(0); // Force the jTextPane1 to show the start of the question, if it's scrollable
        addHoverEffect(jButton1);
        addHoverEffect(jButton2);
        addHoverEffect(jButton3);
        addHoverEffect(jButton4);
        NextQuestion.setVisible(false); // Ensure that "Next Question" button is invisible at first
        loadNextQuestion();
    }

    /* ===================== CORE LOGIC ===================== */
    private void loadNextQuestion() 
    {
        NextQuestion.setVisible(false); // Hide the Next Question button for every question at first
        
        currentQuestion = questionQueue.dequeue();
        if (currentQuestion == null) 
        {
            new FinalScorePage(score, totalQuestions).setVisible(true);
            dispose();
            return;
        }
        CurrentQuesNum.setText(String.valueOf(questionNumber));
        TotalQuesNum.setText(String.valueOf(totalQuestions));
        questionNumber++;
        jTextPane1.setText(currentQuestion.getQuestionText());
        StyledDocument doc = jTextPane1.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        jTextPane1.setCaretPosition(0);
        jButton1.setText(currentQuestion.getOptionA());
        jButton2.setText(currentQuestion.getOptionB());
        jButton3.setText(currentQuestion.getOptionC());
        jButton4.setText(currentQuestion.getOptionD());
        resetButtons();
        startTimer();
    }

    private void resetButtons()
    {
        answered = false;
        javax.swing.JButton[] buttons = {jButton1, jButton2, jButton3, jButton4};
        for (javax.swing.JButton btn : buttons) 
        {
            btn.setEnabled(true);
            btn.setBackground(Color.WHITE);
        }
    }

    /* ===================== ANSWER HANDLING ===================== */

    private void handleButtonClick(javax.swing.JButton clickedButton) 
    {
        System.out.println("Button clicked: " + clickedButton.getText());

        if (answered) return;
        answered = true;
        if (timer != null) timer.stop();

        String correctAnswer = currentQuestion.getCorrectAnswer();
        String selectedAnswer = clickedButton.getText();
        answerStack.push(selectedAnswer);

        if (selectedAnswer.equals(correctAnswer))
        {
            clickedButton.setBackground(Color.GREEN);
            score++;
            System.out.println("✅ Correct! Score now = " + score);
        } 
        else 
        {
            clickedButton.setBackground(Color.RED);
            highlightCorrectAnswer(correctAnswer);
            
        }
        
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        
        // Show "Next Question" button after user has chosen an option
        NextQuestion.setVisible(true);
    }

    private void highlightCorrectAnswer(String correctAnswer)
    {
        if (jButton1.getText().equals(correctAnswer)) jButton1.setBackground(Color.GREEN);
        else if (jButton2.getText().equals(correctAnswer)) jButton2.setBackground(Color.GREEN);
        else if (jButton3.getText().equals(correctAnswer)) jButton3.setBackground(Color.GREEN);
        else if (jButton4.getText().equals(correctAnswer)) jButton4.setBackground(Color.GREEN);
    }

    /* ===================== TIMER ===================== */

    private void startTimer()
    {
         if (timer != null) {
        timer.stop();
    }
    timeLeft = 15;
    jLabelTimer.setText("Timer : " + timeLeft + " s");
    jLabelTimer.setForeground(new Color(51, 153, 0));
    timer = new javax.swing.Timer(1000, e -> {
        timeLeft--;
        jLabelTimer.setText("Timer : " + timeLeft + " s");

        if (timeLeft <= 5)
        {
            jLabelTimer.setForeground(Color.RED);
        }

        if (timeLeft <= 0) 
        {
            timer.stop();
            handleTimesUp();
        }
    });
    timer.start();
    }
    private void handleTimesUp() 
    {
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        
        // Show the "Next Question" button
        NextQuestion.setVisible(true);

        highlightCorrectAnswer(currentQuestion.getCorrectAnswer());
    }

    /* ===================== Hover Effect ===================== */
    private void addHoverEffect(javax.swing.JButton btn) {
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // Only highlight if the button is still enabled (hasn't been clicked yet)
                if (btn.isEnabled()) {
                    btn.setBackground(new java.awt.Color(230, 230, 250)); // Change this to Lavender
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // Only revert color if the button is enabled
                // This prevents overwriting the Green/Red answer colors
                if (btn.isEnabled()) {
                    btn.setBackground(java.awt.Color.WHITE);
                }
            }
        });
    }
    /* ===================== BUTTON EVENTS ===================== */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelTimer = new javax.swing.JLabel();
        CurrentQuesNum = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TotalQuesNum = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        NextQuestion = new javax.swing.JButton();
        Return = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUIZ-ING");
        setPreferredSize(new java.awt.Dimension(700, 650));

        jPanel1.setBackground(new java.awt.Color(237, 231, 246));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 700));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(714, 80));

        jLabel1.setFont(new java.awt.Font("Noto Sans SC", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(44, 62, 80));
        jLabel1.setText("Question");

        jLabelTimer.setFont(new java.awt.Font("Noto Sans SC", 1, 15)); // NOI18N
        jLabelTimer.setForeground(new java.awt.Color(44, 62, 80));
        jLabelTimer.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTimer.setText("Timer :   10 s");

        CurrentQuesNum.setFont(new java.awt.Font("Noto Sans SC", 1, 15)); // NOI18N
        CurrentQuesNum.setForeground(new java.awt.Color(44, 62, 80));
        CurrentQuesNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CurrentQuesNum.setText("1");

        jLabel3.setFont(new java.awt.Font("Noto Sans SC", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(44, 62, 80));
        jLabel3.setText("of");

        TotalQuesNum.setFont(new java.awt.Font("Noto Sans SC", 1, 15)); // NOI18N
        TotalQuesNum.setForeground(new java.awt.Color(44, 62, 80));
        TotalQuesNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TotalQuesNum.setText("8");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(CurrentQuesNum, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(TotalQuesNum, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                .addComponent(jLabelTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CurrentQuesNum, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalQuesNum, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.getAccessibleContext().setAccessibleName("jLabel1");
        jLabelTimer.getAccessibleContext().setAccessibleName("jLabelTimer");
        CurrentQuesNum.getAccessibleContext().setAccessibleName("CurrentQuesNum");
        TotalQuesNum.getAccessibleContext().setAccessibleName("TotalQuesNum");

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);
        jPanel2.getAccessibleContext().setAccessibleName("jPanel2");

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(600, 300));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(44, 62, 80), 2, true), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        jScrollPane1.setToolTipText("");
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(162, 49));

        jTextPane1.setEditable(false);
        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Noto Sans SC", 1, 24)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(74, 63, 107));
        jTextPane1.setFocusable(false);
        jTextPane1.setOpaque(false);
        jScrollPane1.setViewportView(jTextPane1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 500;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 30, 50);
        jPanel3.add(jScrollPane1, gridBagConstraints);

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 50, 10, 50));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridLayout(4, 1, 0, 10));

        jButton1.setFont(new java.awt.Font("Noto Sans SC", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(74, 63, 107));
        jButton1.setText("Queue");
        jButton1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        jButton1.setFocusPainted(false);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setIconTextGap(10);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);

        jButton2.setFont(new java.awt.Font("Noto Sans SC", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(74, 63, 107));
        jButton2.setText("Stack");
        jButton2.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        jButton2.setFocusPainted(false);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setIconTextGap(10);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2);

        jButton3.setFont(new java.awt.Font("Noto Sans SC", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(74, 63, 107));
        jButton3.setText("Array");
        jButton3.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        jButton3.setFocusPainted(false);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setIconTextGap(10);
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3);

        jButton4.setFont(new java.awt.Font("Noto Sans SC", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(74, 63, 107));
        jButton4.setText("Tree");
        jButton4.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        jButton4.setFocusPainted(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setIconTextGap(10);
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 500;
        gridBagConstraints.ipady = 80;
        jPanel3.add(jPanel5, gridBagConstraints);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);
        jPanel3.getAccessibleContext().setAccessibleName("jPanel3");

        jPanel4.setOpaque(false);

        NextQuestion.setBackground(new java.awt.Color(212, 228, 255));
        NextQuestion.setFont(new java.awt.Font("Noto Sans SC", 1, 14)); // NOI18N
        NextQuestion.setForeground(new java.awt.Color(74, 63, 107));
        NextQuestion.setText("Next Question");
        NextQuestion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NextQuestion.setFocusPainted(false);
        NextQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextQuestionActionPerformed(evt);
            }
        });

        Return.setBackground(new java.awt.Color(255, 183, 197));
        Return.setFont(new java.awt.Font("Noto Sans SC", 1, 14)); // NOI18N
        Return.setForeground(new java.awt.Color(74, 63, 107));
        Return.setText("Return to Main Page");
        Return.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Return.setFocusPainted(false);
        Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(467, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Return, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NextQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(NextQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Return, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        NextQuestion.getAccessibleContext().setAccessibleName("NextQuestion");
        Return.getAccessibleContext().setAccessibleName("Return");

        jPanel1.add(jPanel4, java.awt.BorderLayout.SOUTH);
        jPanel4.getAccessibleContext().setAccessibleName("jPanel4");

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        handleButtonClick(jButton1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        handleButtonClick(jButton2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        handleButtonClick(jButton3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        handleButtonClick(jButton4);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void NextQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextQuestionActionPerformed
        loadNextQuestion();
    }//GEN-LAST:event_NextQuestionActionPerformed

    private void ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnActionPerformed
        StartPage start = new StartPage();
        start.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
//            logger.log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> new QuestionPage().setVisible(true));
//        
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CurrentQuesNum;
    private javax.swing.JButton NextQuestion;
    private javax.swing.JButton Return;
    private javax.swing.JLabel TotalQuesNum;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelTimer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
