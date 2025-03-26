/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Message;


/**
 *
 * @author emirozalp
 */
public class Message implements java.io.Serializable {

    public static enum messageType {
        NAME, ROOM_NAME, ROOM_LIST, LIST,                                       // MENU MESSAGE TYPES
        JOIN_ROOM, REFRESH, TEXT,  ROOM_FILE, ROOM_FILE_NOTIFY,                 // ROOM MESSAGE TYPES
        START_CHAT, DECIDE, DECIDE_FINISH, P2P_TEXT, P2P_FILE, P2P_FILE_NOTIFY, // P2P MESSAGE TYPES 
    }

    // type of message
    public messageType type;

    // message sender 
    public String senderName;
    
    // who wants to talk
    public String whoWantsToTalk;
    
    // to send a file content as a byte array
    public byte[] fileContent;
    
    // casteble message content 
    public Object content;
    
    public Message(messageType t) {
        this.type = t;
    }
}
