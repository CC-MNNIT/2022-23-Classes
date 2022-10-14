package class_5.stopwatch;


import java.awt.event.ActionEvent;

public class Stopwatch extends javax.swing.JFrame {

    Timer timer;
    Thread t;
    int flag=0;
    boolean alreadyStarted=false;

    public Stopwatch() {
        initComponents();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hourTF = new javax.swing.JTextField();
        minTF = new javax.swing.JTextField();
        secTF = new javax.swing.JTextField();
        startBT = new javax.swing.JButton();
        pauseBT = new javax.swing.JButton();
        lapBT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lapTA = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("STOP WATCH");

        jLabel2.setText("Hours");

        jLabel3.setText("Minutes");

        jLabel4.setText("Seconds");

        hourTF.setText("0");

        minTF.setText("0");

        secTF.setText("0");

        startBT.setText("Start");
        startBT.addActionListener(this::startBTActionPerformed);

        pauseBT.setText("Pause");
        pauseBT.addActionListener(this::pauseBTActionPerformed);

        lapBT.setText("Lap");
        lapBT.addActionListener(this::lapBTActionPerformed);

        lapTA.setColumns(20);
        lapTA.setRows(5);
        jScrollPane1.setViewportView(lapTA);

        jButton1.setText("Stop");
        jButton1.addActionListener(this::stopBTActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel2)
                                .addGap(115, 115, 115)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(48, 48, 48))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(hourTF, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(startBT)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(minTF, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                                                .addComponent(secTF, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(184, 184, 184)
                                                .addComponent(lapBT))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(98, 98, 98)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(pauseBT)
                                                .addGap(209, 209, 209))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel1)
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(hourTF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(secTF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minTF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(75, 75, 75)
                                .addComponent(startBT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(15, 15, 15)
                                .addComponent(pauseBT)
                                .addGap(37, 37, 37)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(lapBT)
                                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBTActionPerformed
        // TODO add your handling code here:
        if(alreadyStarted)return;
        timer = new Timer(this);
        t = new Thread(timer, "timer1");
        t.start();
        alreadyStarted=true;
    }//GEN-LAST:event_startBTActionPerformed

    private void pauseBTActionPerformed(ActionEvent evt) {//GEN-FIRST:event_pauseBTActionPerformed
        // TODO add your handling code here:
        System.out.println("Pause button clicked!");
        if(flag==0){
            timer.suspend();
            pauseBT.setText("Resume");
            flag = 1;
        }
        else if(flag ==1)
        {
            timer.resume();
            pauseBT.setText("Pause");
            flag=0;
        }
    }//GEN-LAST:event_pauseBTActionPerformed

    private void lapBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lapBTActionPerformed
        // TODO add your handling code here:
        String lap = hourTF.getText()+" "+minTF.getText()+" "+secTF.getText()+"\n";
        lapTA.append(lap);
    }//GEN-LAST:event_lapBTActionPerformed

    private void stopBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        timer.stop();
        alreadyStarted=false;

    }//GEN-LAST:event_jButton1ActionPerformed

    public void setTimer(int hr, int min, int sec){
        hourTF.setText(""+hr);
        minTF.setText(""+min);
        secTF.setText(""+sec);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hourTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lapBT;
    private javax.swing.JTextArea lapTA;
    private javax.swing.JTextField minTF;
    private javax.swing.JButton pauseBT;
    private javax.swing.JTextField secTF;
    private javax.swing.JButton startBT;
    // End of variables declaration//GEN-END:variables
}