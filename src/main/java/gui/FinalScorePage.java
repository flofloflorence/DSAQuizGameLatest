package gui;

import javax.swing.ImageIcon;
import model.Question;
import structure.QuestionQueue;

public class FinalScorePage extends javax.swing.JFrame 
{
    public FinalScorePage(int score, int total) 
    {
        initComponents();
        TotalScore.setText(score + " / " + total);
        int percentage = (int)((score * 100.0) / total);
     


    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TotalScore = new javax.swing.JLabel();
        TotalPercentage = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MISSION ACCOMPLISHED!");

        jPanel1.setBackground(new java.awt.Color(237, 231, 246));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 700));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(74, 63, 107));
        jLabel1.setText("Misson Accomplished!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Noto Sans SC", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(44, 62, 80));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("YEEESHHH! You've completed the quiz.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        jPanel2.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 7));

        jLabel3.setFont(new java.awt.Font("Noto Sans SC", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(44, 62, 80));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Score:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel3.setPreferredSize(new java.awt.Dimension(75, 35));
        jLabel3.setRequestFocusEnabled(false);
        jPanel2.add(jLabel3);

        TotalScore.setFont(new java.awt.Font("Noto Sans SC", 0, 18)); // NOI18N
        TotalScore.setForeground(new java.awt.Color(44, 62, 80));
        TotalScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        TotalScore.setText("8/10");
        TotalScore.setPreferredSize(new java.awt.Dimension(40, 35));
        jPanel2.add(TotalScore);
        TotalScore.getAccessibleContext().setAccessibleName("TotalScore");

        TotalPercentage.setFont(new java.awt.Font("Noto Sans SC", 0, 18)); // NOI18N
        TotalPercentage.setForeground(new java.awt.Color(44, 62, 80));
        TotalPercentage.setText("(80%)");
        TotalPercentage.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        TotalPercentage.setMaximumSize(new java.awt.Dimension(50, 35));
        TotalPercentage.setPreferredSize(new java.awt.Dimension(55, 35));
        jPanel2.add(TotalPercentage);
        TotalPercentage.getAccessibleContext().setAccessibleName("TotalPercentage");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 300));
        jPanel3.setRequestFocusEnabled(false);
        jPanel3.setLayout(new java.awt.GridLayout(2, 2, 10, 10));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clap clap.jpg"))); // NOI18N
        jPanel3.add(jLabel6);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/never give up.jpg"))); // NOI18N
        jPanel3.add(jLabel8);

        jLabel7.setFont(new java.awt.Font("Noto Sans SC", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(44, 62, 80));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("<html>Got them all right?<br>You crushed it!<br>Time complexity<br>of ur brain = O(1)</html>");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel7);

        jLabel9.setFont(new java.awt.Font("Noto Sans SC", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(44, 62, 80));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("<html>Got some wrong?<br>It's totally fine...<br>Your brain just ran<br>in O(n²) today.</html>");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel9);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        jPanel1.add(jPanel3, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(255, 183, 197));
        jButton1.setFont(new java.awt.Font("Noto Sans SC", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(74, 63, 107));
        jButton1.setText("PLAY AGAIN");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 30, 0);
        jPanel1.add(jButton1, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        QuestionQueue queue = new QuestionQueue(3);

    queue.enqueue(new Question(
        "What is the time complexity of binary search?",
        "O(n)", "O(log n)", "O(n^2)", "O(1)", 1
    ));

    queue.enqueue(new Question(
        "Which data structure follows FIFO?",
        "Stack", "Tree", "Queue", "Graph", 2
    ));

    queue.enqueue(new Question(
        "Which data structure uses LIFO?",
        "Queue", "Stack", "Array", "Linked List", 1
    ));

    new StartPage().setVisible(true);
    this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
//        java.awt.EventQueue.invokeLater(() -> new FinalScorePage().setVisible(true));
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TotalPercentage;
    private javax.swing.JLabel TotalScore;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
