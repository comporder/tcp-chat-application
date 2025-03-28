/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Message.Message;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Ceren
 */
public class MenuFrame extends javax.swing.JFrame {

    public static ChatFrame chatFrame=new ChatFrame();
    public DefaultListModel dlm = new DefaultListModel();   // to holding clients
    public DefaultListModel dlm2 = new DefaultListModel();  // to holding rooms

    public MenuFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        clientList.setModel(dlm);
        roomList.setModel(dlm2);

    }

    public static String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        int length = 5;
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dgf = new javax.swing.JLabel();
        createRoom = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        roomCodeName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        clientList = new javax.swing.JList<>();
        showClients = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        roomList = new javax.swing.JList<>();
        showRooms = new javax.swing.JButton();
        joinAvailableRoom = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        roomMembers = new javax.swing.JList<>();
        p2pChatPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        startChat1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dgf.setFont(new java.awt.Font("Bodoni MT", 0, 36)); // NOI18N
        dgf.setForeground(new java.awt.Color(51, 102, 255));
        dgf.setText("CHAT APP|");
        jPanel1.add(dgf, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, 30));

        createRoom.setBackground(new java.awt.Color(51, 102, 255));
        createRoom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        createRoom.setForeground(new java.awt.Color(255, 255, 255));
        createRoom.setText("Create");
        createRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createRoomActionPerformed(evt);
            }
        });
        jPanel1.add(createRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 240, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Room Code     :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 120, -1));
        jPanel1.add(roomCodeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 120, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 255));
        jLabel4.setText("|COMPORDER");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 150, 30));

        clientList.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)), "Clients List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13), new java.awt.Color(51, 102, 255))); // NOI18N
        clientList.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clientList.setForeground(new java.awt.Color(51, 102, 255));
        jScrollPane3.setViewportView(clientList);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 240, 160));

        showClients.setBackground(new java.awt.Color(51, 102, 255));
        showClients.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        showClients.setForeground(new java.awt.Color(255, 255, 255));
        showClients.setText("Show ");
        showClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showClientsActionPerformed(evt);
            }
        });
        jPanel1.add(showClients, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 110, -1));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roomList.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)), "Rooms List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13), new java.awt.Color(51, 102, 255))); // NOI18N
        roomList.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        roomList.setForeground(new java.awt.Color(51, 102, 255));
        roomList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(roomList);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 190, 160));

        showRooms.setBackground(new java.awt.Color(51, 102, 255));
        showRooms.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        showRooms.setForeground(new java.awt.Color(255, 255, 255));
        showRooms.setText("Show Project Rooms");
        showRooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRoomsActionPerformed(evt);
            }
        });
        jPanel2.add(showRooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, -1));

        joinAvailableRoom.setBackground(new java.awt.Color(51, 102, 255));
        joinAvailableRoom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        joinAvailableRoom.setForeground(new java.awt.Color(255, 255, 255));
        joinAvailableRoom.setText("Join Room");
        joinAvailableRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinAvailableRoomActionPerformed(evt);
            }
        });
        jPanel2.add(joinAvailableRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 170, -1));

        roomMembers.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)), "Project Members", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13), new java.awt.Color(51, 102, 255))); // NOI18N
        roomMembers.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        roomMembers.setForeground(new java.awt.Color(51, 102, 255));
        jScrollPane4.setViewportView(roomMembers);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 170, 160));

        jTabbedPane1.addTab("Projects", jPanel2);

        p2pChatPanel.setBackground(new java.awt.Color(255, 255, 255));
        p2pChatPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        p2pChatPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chat"));
        jScrollPane1.setViewportView(jTextArea1);

        p2pChatPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 380, 140));

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ceren\\Downloads\\clip (1).png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        p2pChatPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 30, 30));

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ceren\\Downloads\\happy-face (2).png")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        p2pChatPanel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 30, 30));
        p2pChatPanel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 260, 30));

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ceren\\Downloads\\send (2) (1).png")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        p2pChatPanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 30, 30));

        jTabbedPane1.addTab("My Prrojects", p2pChatPanel);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 440, 280));

        startChat1.setBackground(new java.awt.Color(51, 102, 255));
        startChat1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        startChat1.setForeground(new java.awt.Color(255, 255, 255));
        startChat1.setText("Chat");
        startChat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startChat1ActionPerformed(evt);
            }
        });
        jPanel1.add(startChat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 100, -1));

        jLabel1.setText("Welcome, ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 80, -1));

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createRoomActionPerformed
        // TODO add your handling code here:
        if (roomCodeName.getText().equals(null) || roomCodeName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a room name before creation !!");
            return;
        }
        Message msg = new Message(Message.messageType.ROOM_NAME);
        msg.content = roomCodeName.getText();
        Client.sendRequest(msg);

    }//GEN-LAST:event_createRoomActionPerformed

    private void showRoomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRoomsActionPerformed
        // TODO add your handling code here:
        Message msg = new Message(Message.messageType.ROOM_LIST);
        Client.sendRequest(msg);
    }//GEN-LAST:event_showRoomsActionPerformed

    private void showClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showClientsActionPerformed
        // TODO add your handling code here:
        System.out.println("SHOW CLIENTS BUTTON GIRDIMM");
        Message msg = new Message(Message.messageType.LIST);
        Client.sendRequest(msg);
    }//GEN-LAST:event_showClientsActionPerformed

    private void joinAvailableRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinAvailableRoomActionPerformed
        // TODO add your handling code here:
        if (!roomList.isSelectionEmpty()) {
            Message msg = new Message(Message.messageType.JOIN_ROOM);
            msg.content = (String) roomList.getSelectedValue();
            System.out.println("choosen room name: " + msg.content);
            Client.sendRequest(msg);
        }
    }//GEN-LAST:event_joinAvailableRoomActionPerformed

    private void roomListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomListMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_roomListMouseClicked

    private void startChat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startChat1ActionPerformed
        // TODO add your handling code here:
        Message msg = new Message(Message.messageType.START_CHAT);
        msg.content = (String) clientList.getSelectedValue();
        msg.senderName = jLabel1.getText().substring(3, jLabel1.getText().length()-1);
        System.out.println("msg.senderName: "+msg.senderName);
        Client.sendRequest(msg); 
        JOptionPane.showMessageDialog(this, "Chat response waiting...");
    }//GEN-LAST:event_startChat1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuFrame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> clientList;
    private javax.swing.JButton createRoom;
    private javax.swing.JLabel dgf;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JButton joinAvailableRoom;
    public javax.swing.JPanel p2pChatPanel;
    private javax.swing.JTextField roomCodeName;
    private javax.swing.JList<String> roomList;
    private javax.swing.JList<String> roomMembers;
    private javax.swing.JButton showClients;
    private javax.swing.JButton showRooms;
    private javax.swing.JButton startChat1;
    // End of variables declaration//GEN-END:variables
}
