package chitchatjavaclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.table.DefaultTableModel;

public class chitchatjavaClient extends javax.swing.JFrame {

    private Socket s;
    private BufferedReader in;  //character
    private PrintWriter out;    //character
    private String msg;
    
    private DefaultTableModel model;

    public chitchatjavaClient() {
        initComponents();
        model = (DefaultTableModel) tb_message.getModel();
    }

    public void connectServer() {
        String ip = tf_ip.getText();
        int port = Integer.parseInt(tf_port.getText());

        try {
            //step 1 connect to server
            //localhost
            s = new Socket(ip, port); //จะวิ่งไปที่ step 2 ของ server ที่รออยู่เพื่อทำงานต่อ

            //step 2 create input and output
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));  //byte to character to buffered
            out = new PrintWriter(s.getOutputStream()); //byte to character

            //step 3 process
//            out.println("Hello");
//            out.flush(); //ดันให้หมดท่อ (ไม่มีอะไรค้างในท่อ)
//            msg = in.readLine();
//            System.out.println("Server echo: " + msg);
            //step 4 close
            s.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void sendMessage() {
        String name = tf_name.getText();
        String message = tf_message.getText();

        try {
            //step 3 process
            out.println("" + name + message);
            out.flush(); //ดันให้หมดท่อ (ไม่มีอะไรค้างในท่อ)
            msg = in.readLine();
            System.out.println("Server echo: " + msg);

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void tests() {

        
        
        String ip = tf_ip.getText();
        int port = Integer.parseInt(tf_port.getText());
        String name = tf_name.getText();
        String message = tf_message.getText();
        
        
        try {
            //step 1 connect to server
            //localhost
            s = new Socket(ip, port); //จะวิ่งไปที่ step 2 ของ server ที่รออยู่เพื่อทำงานต่อ

            //step 2 create input and output
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));  //byte to character to buffered
            out = new PrintWriter(s.getOutputStream()); //byte to character

            //step 3 process
            out.println(name+" : "+message);
            out.flush(); //ดันให้หมดท่อ (ไม่มีอะไรค้างในท่อ)
            msg = in.readLine();
            
            model.addRow(new Object[]{msg});
            
            System.out.println("Server echo: " + msg);

            //step 4 close
            s.close();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        tf_ip = new javax.swing.JTextField();
        tf_port = new javax.swing.JTextField();
        tf_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bt_send = new javax.swing.JButton();
        tf_message = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_message = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        l_user = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");

        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("IP");

        jLabel2.setText("Port");

        jLabel3.setText("Name");

        bt_send.setText("SEND");
        bt_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sendActionPerformed(evt);
            }
        });

        tb_message.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message"
            }
        ));
        jScrollPane1.setViewportView(tb_message);

        l_user.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(l_user);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(tf_port, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(tf_message, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bt_send))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_message, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_send))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        connectServer();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sendActionPerformed
        //sendMessage();
        tests();
    }//GEN-LAST:event_bt_sendActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(chitchatjavaClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chitchatjavaClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chitchatjavaClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chitchatjavaClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chitchatjavaClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_send;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> l_user;
    private javax.swing.JTable tb_message;
    private javax.swing.JTextField tf_ip;
    private javax.swing.JTextField tf_message;
    private javax.swing.JTextField tf_name;
    private javax.swing.JTextField tf_port;
    // End of variables declaration//GEN-END:variables
}
