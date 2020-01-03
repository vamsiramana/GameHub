/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Hangman extends javax.swing.JFrame {

    String arrayOfWords[] = {"apocryphal", "fundamental", "cacophony", "rebellious", "perseverant", "preamble", "jurisdiction", "etheral", "pompous", "floating"};
    int word = 0;
    int count = 0;
    String wordChosen, wordDisplayed = "";
    static String p1,p2;
    public Hangman(String word1,String p1,String p2) {
        this.p1 = p1;
        this.p2 = p2;
        initComponents();
        initialization(word1);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }
    
    private void initialization(String w)
    {
        word = (int) (Math.random() * 10) ;
        //wordChosen = arrayOfWords[word];
        wordChosen = w.toLowerCase();
        for (int i = 0; i < wordChosen.length(); i++)
        {
            wordDisplayed += "- ";
        }
        wordDisplayTF.setText(wordDisplayed);
        guessesLeftL.setText("Guesses Left: " + (7-count));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        letterGuessL = new javax.swing.JLabel();
        letterGuessTF = new javax.swing.JTextField();
        wordL = new javax.swing.JLabel();
        wordDisplayTF = new javax.swing.JTextField();
        guessedL = new javax.swing.JLabel();
        guessedLettersTF = new javax.swing.JTextField();
        runB = new javax.swing.JButton();
        guessesLeftL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hangman");

        letterGuessL.setText("Letter In:");

        wordL.setText("Word to be Guessed");

        wordDisplayTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordDisplayTFActionPerformed(evt);
            }
        });

        guessedL.setText("Guessed:");

        runB.setText("Run");
        runB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runBActionPerformed(evt);
            }
        });

        guessesLeftL.setText("Guesses Left: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(letterGuessL, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(runB, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(guessesLeftL)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wordL, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(guessedL, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(guessedLettersTF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(wordDisplayTF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(letterGuessTF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 100, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wordL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wordDisplayTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(letterGuessL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(runB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(letterGuessTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guessedLettersTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guessedL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guessesLeftL)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void runBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runBActionPerformed
        // TODO add your handling code here:
        String guessedLetters = guessedLettersTF.getText();
        String newLetter = letterGuessTF.getText().toLowerCase();
        guessedLettersTF.setText(guessedLetters + " " + newLetter.charAt(0));
        letterGuessTF.setText("");
        String tempDisplayed = "";
        for (int i = 0; i < wordDisplayed.length(); i++)
        {
            if (wordDisplayed.charAt(i) != ' ')
            {
                tempDisplayed += wordDisplayed.charAt(i);
            }
        }
        wordDisplayed = "";
        char compared = newLetter.charAt(0);
        boolean flag = false;
        for (int i = 0; i < wordChosen.length(); i++)
        {
            char toCompare = wordChosen.charAt(i);
            if (compared == toCompare)
            {
                wordDisplayed += compared + " ";
                flag = true;
            }
            else
            {
                if (tempDisplayed.charAt(i) != '-')
                {
                    wordDisplayed += tempDisplayed.charAt(i) + " ";
                }
                else
                {
                    wordDisplayed += "- ";
                }
            }
        }
        wordDisplayTF.setText(wordDisplayed);
        if (!flag)
        {
            count += 1;
        }
        if (count == 7)
        {
            JOptionPane.showMessageDialog(null, "You ran out of guesses.", "Game Over.", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            update_score(p1,p2);
        }
        tempDisplayed = "";
        for (int i = 0; i < wordDisplayed.length(); i++)
        {
            if (wordDisplayed.charAt(i) != ' ')
            {
                tempDisplayed += wordDisplayed.charAt(i);
            }
        }
        if (tempDisplayed.equalsIgnoreCase(wordChosen))
        {
            JOptionPane.showMessageDialog(null, "You won.", "Game Over.", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            update_score(p2,p1);
        }
        guessesLeftL.setText("Guesses Left: " + (7-count));
    }//GEN-LAST:event_runBActionPerformed

    private void wordDisplayTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordDisplayTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wordDisplayTFActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hangman("Generic",p1,p2).setVisible(true);
            }
        });
    }
     public void update_score(String winner,String looser)
        {
            
            try{
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/newdatabase","root2","password");  
            Statement stmt=con.createStatement();  
            Statement s = con.createStatement();
           
            
           
                String q = "update HangmanLeaderBoard set wins = wins + 1 where name  =  '"+ winner+"'";
                stmt.executeUpdate(q);
                q = "update HangmanLeaderBoard set lost = lost + 1 where name  =  '"+ looser+"'";
                stmt.executeUpdate(q);
                this.dispose();
            
            
            
                //stmt.executeUpdate(q);
            
        }
            catch(Exception e){;}
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel guessedL;
    public javax.swing.JTextField guessedLettersTF;
    private javax.swing.JLabel guessesLeftL;
    private javax.swing.JLabel letterGuessL;
    private javax.swing.JTextField letterGuessTF;
    private javax.swing.JButton runB;
    public javax.swing.JTextField wordDisplayTF;
    private javax.swing.JLabel wordL;
    // End of variables declaration//GEN-END:variables
}
