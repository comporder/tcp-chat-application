/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

/**
 *
 * @author Ceren
 */
import java.util.ArrayList;

public class Room {

    public String name;
    public ArrayList<String> clientList = new ArrayList();

    public Room(String name, String creatorName){
        this.name = name;
        clientList.add(creatorName);
    }
}
