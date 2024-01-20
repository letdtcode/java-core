package com.mascara.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 20/01/2024
 * Time      : 5:29 CH
 * Filename  : ServerExample
 */
public class ServerExample extends Thread {
    private ServerSocket serverSocket;

    public ServerExample(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(30000);
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("Just connected to" + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());

                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("Thank you for connecting to" + server.getLocalSocketAddress() + "\nGoodbye");
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try {
            Thread t = new ServerExample(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
