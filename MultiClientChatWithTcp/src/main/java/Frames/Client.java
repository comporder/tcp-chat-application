/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;

import Message.Message;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ceren
 */
public class Client implements java.io.Serializable {

    public static Socket socket;
    public static ObjectInputStream sInput;
    public static ObjectOutputStream sOutput;
    public static boolean respond = false;
    public static ListenServer listener;
 

    public static void startConnection(String ip, int port) {
        try {
            // server ve socket baglantilari
            Client.socket = new Socket(ip, port);
            Client.listener = new ListenServer();
            Client.sInput = new ObjectInputStream(Client.socket.getInputStream());
            Client.sOutput = new ObjectOutputStream(Client.socket.getOutputStream());
            Client.listener.start();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sendRequest(Message msg) {
        try {
            Client.sOutput.writeObject(msg);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void stopConnection() {
        try {
            if (Client.socket != null) {
                Client.listener.stop();
                Client.socket.close();
                Client.sOutput.flush();
                Client.sOutput.close();
                Client.sInput.close();

            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class ListenServer extends Thread implements java.io.Serializable {

    

    @Override
    public void run() {
        while (Client.socket.isConnected()) {
            try {
                Message msg = (Message) Client.sInput.readObject();
                switch (msg.type) {
                    case NAME:
                        break;
                    case ROOM_NAME:
                        // msg.content == newRoom.name
                        MenuFrame.chatFrame.roomlbl.setText(msg.content.toString().toUpperCase());
                        MenuFrame.chatFrame.setVisible(true);
                        break;
                    case LIST:
                        LoginFrame.menuFrame.dlm.removeAllElements();
                        ArrayList<String> receivedNames = new ArrayList();
                        receivedNames = (ArrayList<String>) msg.content;
                        for (String item : receivedNames) {
                            LoginFrame.menuFrame.dlm.addElement(item);
                        }
                        break;
                    case ROOM_LIST:
                        LoginFrame.menuFrame.dlm2.removeAllElements();
                        ArrayList<String> receivedRooms = new ArrayList();
                        receivedRooms = (ArrayList<String>) msg.content;
                        for (String item : receivedRooms) {
                            LoginFrame.menuFrame.dlm2.addElement(item);
                        }
                        break;
                    case JOIN_ROOM:
                        // msg.content == temp (NO or room name)
                        if (msg.content.equals("NO")) {
                            JOptionPane.showMessageDialog(LoginFrame.menuFrame, "Room name Failure!!");
                            return;
                        }
                        MenuFrame.chatFrame.roomlbl.setText(msg.content.toString().toUpperCase());
                        MenuFrame.chatFrame.setVisible(true);
                        break;
                    case REFRESH:
                        MenuFrame.chatFrame.dlm.removeAllElements();
                        ArrayList<String> roomsClients = new ArrayList();
                        roomsClients = (ArrayList<String>) msg.content;
                        for (String item : roomsClients) {
                            MenuFrame.chatFrame.dlm.addElement(item);
                        }
                        break;
                    case START_CHAT:
                        // msg.content == "DECIDE"
                        // msg.whoWantsToTalk == username who click start chat button
                        // selection: receiver users decide. Is he/she wants to talk or not ?
                        int selection = 0;
                        if (msg.content.equals("DECIDE")) {
                            selection = JOptionPane.showConfirmDialog(LoginFrame.menuFrame, msg.whoWantsToTalk + " wants to talk you? Do you accept?", "Chat Request", JOptionPane.YES_OPTION);
                        }

                        if (selection == JOptionPane.YES_OPTION) {
                            TitledBorder title=new TitledBorder(msg.whoWantsToTalk);
                            LoginFrame.menuFrame.jTextArea1.setBorder(title);
                            LoginFrame.menuFrame.p2pChatPanel.show();
                            
                            //  to notify the client is he/she accept to chat request ?
                            Message decide = new Message(Message.messageType.DECIDE);
                            decide.content = selection; // if option is yes selection equals 0, if it is not then selection eq 1
                            decide.senderName = LoginFrame.menuFrame.jLabel1.getText().substring(3, LoginFrame.menuFrame.jLabel1.getText().length() - 1);
                            decide.whoWantsToTalk = msg.whoWantsToTalk;
                            Client.sendRequest(decide);
                        }

                        
                        break;
                    case DECIDE_FINISH:
                        // if msg.content open, so it means client accept to chat
                        if (msg.content.equals("OPEN")) {
                            TitledBorder title=new TitledBorder(msg.whoWantsToTalk);
                            LoginFrame.menuFrame.jTextArea1.setBorder(title);
                            LoginFrame.menuFrame.p2pChatPanel.show(); 
                        }
                        break;
                    case P2P_TEXT:
                        LoginFrame.menuFrame.jTextArea1.append(msg.content.toString() + "\n");
                        break;
                    case P2P_FILE:
                        // msg.content == file name
                        String homePath = System.getProperty("user.home");
                        File receivedFile = new File(homePath + "/Desktop/" + msg.content);
                        OutputStream os = new FileOutputStream(receivedFile);
                        byte content[] = (byte[])msg.fileContent;
                        os.write(content);
                        break;
                    case P2P_FILE_NOTIFY:
                        LoginFrame.menuFrame.jTextArea1.append(msg.content.toString() + "\n");
                        break;
                    case TEXT:
                        MenuFrame.chatFrame.messageArea.append(msg.content.toString() + "\n");
                        break;
                    case ROOM_FILE:
                        // msg.content == file name
                        String homePath1 = System.getProperty("user.home");
                        File receivedFile1 = new File(homePath1 + "/Desktop/" + msg.content);
                        OutputStream os1 = new FileOutputStream(receivedFile1);
                        byte content1[] = (byte[])msg.fileContent;
                        os1.write(content1);
                        break;
                    case ROOM_FILE_NOTIFY:
                        MenuFrame.chatFrame.messageArea.append(msg.content.toString() + "\n");
                        break;
                    default:
                        throw new AssertionError();
                }
            } catch (IOException ex) {
                Logger.getLogger(ListenServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListenServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
