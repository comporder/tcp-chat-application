# 💬 Multi-Client Chat Application with TCP Socket Programming

A real-time, socket-based chat application developed using TCP communication. This project supports multiple clients connecting to a central server, enabling public group chats, private rooms, one-to-one messaging, and file sharing between users.

---

## 📌 Project Overview

This project was developed as part of the **Computer Networks** course and is designed to simulate real-time communication via a TCP-based client-server architecture.

### 🎯 Features

- ✅ **Client-Server Architecture** using TCP Sockets
- 👥 **Multiple Clients** can connect simultaneously
- 🗨️ **Group Chat Room** for all active users
- 🔒 **Private Rooms** with access key protection
- 📬 **Private One-to-One Messaging** between selected users
- 📁 **File Sharing** among participants
- 🧠 **Threaded Listener** for continuous message reception
- 🧾 **Message Types & Routing** via enums and message objects
- ☁️ Deployed on **Amazon Web Services (AWS)**

---

## 🧩 System Design

- **Server Class**: Listens for client connections, manages message routing, and broadcasts messages.
- **Client Class**: Connects to the server, sends messages, and listens for incoming communication via a dedicated thread.
- **Message Class**: Encapsulates message content, type, sender, and receiver.
- **Enum Types**: Used to define message categories (e.g., `LOGIN`, `GROUP_MSG`, `PRIVATE_MSG`, etc.)
- **ArrayLists**: Used for tracking connected clients, usernames, and active rooms.

---

## 🛠️ Technologies Used

- Java (Socket Programming)
- ObjectOutputStream / ObjectInputStream for message transmission
- Multi-threading for concurrent message handling
- Amazon Web Services (for deployment)


