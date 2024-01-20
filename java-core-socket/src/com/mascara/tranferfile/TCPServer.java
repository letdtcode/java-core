package com.mascara.tranferfile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 20/01/2024
 * Time      : 6:50 CH
 * Filename  : TCPServer
 */
public class TCPServer extends Thread {
    private ServerSocket serverSocket;
    private int port = 9900;

    public static void main(String[] args) {
        TCPServer tcpServer = new TCPServer();
        tcpServer.open();
        tcpServer.start();
    }

    //    open server
    public void open() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is open on port: " + port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (true) {
            Socket server = null;
            DataInputStream inFromClient = null;
            ObjectInputStream ois = null;
            ObjectOutputStream oos = null;

            try {
//                accept connect from client and create Socket object
                server = serverSocket.accept();
                System.out.println("Connected to " + server.getRemoteSocketAddress());

//                get greeting from client
                inFromClient = new DataInputStream(server.getInputStream());
                System.out.println(inFromClient.readUTF());

//                receive file info
                ois = new ObjectInputStream(server.getInputStream());
                FileInfo fileInfo = (FileInfo) ois.readObject();
                if (fileInfo != null) {
                    createFile(fileInfo);
                }

//                confirm that file is received
                oos = new ObjectOutputStream(server.getOutputStream());
                fileInfo.setStatus("success");
                fileInfo.setDataBytes(null);
                oos.writeObject(fileInfo);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
//                close all stream
                closeStream(ois);
                closeStream(oos);
                closeStream(inFromClient);

//                close session
                closeSocket(server);
            }
        }
    }

    private boolean createFile(FileInfo fileInfo) {
        BufferedOutputStream bos = null;
        try {
            if (fileInfo != null) {
                File fileReceive = new File(fileInfo.getDestinationDirectory() + fileInfo.getFileName());
                bos = new BufferedOutputStream(new FileOutputStream(fileReceive));

//                write file content
                bos.write(fileInfo.getDataBytes());
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeStream(bos);
        }
        return true;
    }

    //    close input stream
    public void closeStream(InputStream inputStream) {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    close socket
    public void closeSocket(Socket socket) {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    close output stream
    public void closeStream(OutputStream outputStream) {
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
