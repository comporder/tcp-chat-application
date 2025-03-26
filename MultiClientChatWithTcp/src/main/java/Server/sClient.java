/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Message.Message;
import Message.Message.messageType;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emirozalp
 */
public class sClient {

    public int clientID;
    public Socket socket;
    public String clientName;
    public ObjectOutputStream sOutput;
    public ObjectInputStream sInput;
    public Listen listener;

    public sClient(int clientID, Socket socket) {
        try {
            this.socket = socket;
            this.clientID = clientID;
            this.sOutput = new ObjectOutputStream(this.socket.getOutputStream());
            this.sInput = new ObjectInputStream(this.socket.getInputStream());
            this.listener = new Listen(this);
        } catch (IOException ex) {
            Logger.getLogger(sClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendMessage(Message message) {
        try {
            this.sOutput.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(sClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            this.socket.close();
        } catch (IOException ex) {
            Logger.getLogger(sClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public class Listen extends Thread implements java.io.Serializable {
        
        sClient sclient;

        public Listen(sClient sclient) {
            this.sclient = sclient;
        }
        

        @Override
        public void run() {
            while (sclient.socket.isConnected()) {
                try {
                    Message msg = (Message) this.sclient.sInput.readObject();
                    switch (msg.type) {
                         case NAME:
                            System.out.println("gelen name mesajı: " + msg.content.toString());
                            sclient.clientName = msg.content.toString();
                            break;
                        case ROOM_NAME:
                            System.out.println("gelen room name mesajı: " + msg.content.toString());
                            Room newRoom = new Room(msg.content.toString(), sclient.clientName);
                            Server.projectRoomList.add(newRoom);
                            Message roomMSG = new Message(Message.messageType.ROOM_NAME);
                            roomMSG.content = newRoom.name;
                            Server.sendMessageToClient(this.sclient, roomMSG);
                            break;
                        case LIST:
                            ArrayList<String> usernames = new ArrayList<String>();
                            for (sClient item : Server.clientList) {
                                usernames.add(item.clientName);
                            }
                            Message mesaj = new Message(messageType.LIST);
                            mesaj.content = usernames;
                            Server.sendMessageToClient(this.sclient, mesaj);
                            break;
                        case ROOM_LIST:
                            ArrayList<String> roomNames = new ArrayList<String>();
                            for (Room item : Server.projectRoomList) {
                                roomNames.add(item.name);
                            }
                            Message roomListMsg = new Message(messageType.ROOM_LIST);
                            roomListMsg.content = roomNames;
                            Server.sendMessageToClient(this.sclient, roomListMsg);
                            break;
                        case JOIN_ROOM:
                            // msg.content == choosen room name from list
                            // searching a room in server, so if it is exist then enter a room
                            // and add this sclient to rooms user list
                            String tempRoomName = "NO";
                            for (Room item : Server.projectRoomList) {
                                if (item.name.equals(msg.content)) {
                                    tempRoomName = item.name;
                                    item.clientList.add(this.sclient.clientName);
                                    break;
                                }
                            }
                            Message roomNameMSG = new Message(Message.messageType.JOIN_ROOM);
                            roomNameMSG.content = tempRoomName;
                            Server.sendMessageToClient(this.sclient, roomNameMSG);
                            break;
                        case REFRESH:
                            // msg.content == room name
                            ArrayList<String> clientNames = new ArrayList();
                            for (Room room : Server.projectRoomList) {
                                if (room.name.equals(msg.content.toString())) {
                                    for (String client : room.clientList) {
                                        clientNames.add(client);
                                    }
                                }
                            }
                            Message clientsMSG = new Message(messageType.REFRESH);
                            clientsMSG.content = clientNames;
                            Server.sendMessageToClient(this.sclient, clientsMSG);
                            break;
                        case START_CHAT:
                            // msg.content == selected client name from list to chat
                            Message decideMSG = new Message(Message.messageType.START_CHAT);
                            decideMSG.content = (String) "DECIDE";
                            decideMSG.whoWantsToTalk = msg.senderName;
                            for (sClient sclient : Server.clientList) {
                                if (sclient.clientName.equals(msg.content)) {
                                    Server.sendMessageToClient(sclient, decideMSG);
                                    break;
                                }
                            }
                            break;
                        case DECIDE:
                            // msg.content == selection ---> YES = 0, NO = 1
                            if (msg.content.equals(0)) {
                                Message finish = new Message(Message.messageType.DECIDE_FINISH);
                                finish.content = "OPEN";
                                finish.senderName = msg.senderName;
                                finish.whoWantsToTalk = msg.whoWantsToTalk;
                                for (sClient item : Server.clientList) {
                                    if (item.clientName.equals(msg.whoWantsToTalk)) {
                                        Server.sendMessageToClient(item, finish);
                                        break;
                                    }
                                }  
                            }              
                            break;     
                        case P2P_TEXT:
                            // msg.content == sended message 
                            Message textMSG = new Message(Message.messageType.P2P_TEXT);
                            textMSG.content = this.sclient.clientName.toUpperCase() + ": " + msg.content;
                            Server.sendMessageToClients(textMSG);
                            break;
                        case P2P_FILE:
                            // msg.content == file name
                            Server.sendMessageToClients(msg);
                            break;
                        case P2P_FILE_NOTIFY:
                            // msg.content == filename + shared..
                            Server.sendMessageToClients(msg);
                            break;
                        case TEXT:
                            // msg.content == sended message to room 
                            Message chatMSG = new Message(Message.messageType.TEXT);
                            chatMSG.content = this.sclient.clientName.toUpperCase() + ": " + msg.content;
                            Server.sendMessageToClients(chatMSG);
                            break;
                        case ROOM_FILE:
                            // msg.content == file name
                            Server.sendMessageToClients(msg);
                            break;
                        case ROOM_FILE_NOTIFY:
                            // msg.content == filename + shared..
                            Server.sendMessageToClients(msg);
                            break;
                        default:
                            throw new AssertionError();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(sClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(sClient.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }
}
