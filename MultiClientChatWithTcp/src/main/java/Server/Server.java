/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Message.Message;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ceren
 */
public class Server {

    public static int port;
    public static int clientID = 0;
    public static ServerSocket socket;
    public static listenClient listener;
    public static ArrayList<sClient> clientList = new ArrayList();
    public static ArrayList<Room> projectRoomList = new ArrayList();

    public static void Start(int port) {
        try {
            Server.port = port;
            Server.socket = new ServerSocket(Server.port);
            Server.listener = new listenClient();
            Server.listener.start();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sendMessageToClient(sClient sClient, Message msg) {
        try {
            sClient.sOutput.writeObject(msg);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sendMessageToClients(Message msg) {
        for (sClient client : clientList) {
            try {
                client.sOutput.writeObject(msg);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void sendMessageToClients(sClient sclient, Message msg) {

        for (sClient client : clientList) {
            try {
                if (!client.equals(sclient)) {
                    client.sOutput.writeObject(msg);
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class listenClient extends Thread {

    

    @Override
    public void run() {
        while (!Server.socket.isClosed()) {
            try {
                Socket clientSocket = Server.socket.accept();
                sClient newClient = new sClient(Server.clientID,clientSocket);
                Server.clientID++;
                Server.clientList.add(newClient);
                newClient.listener.start();
            } catch (IOException ex) {
                Logger.getLogger(listenClient.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
