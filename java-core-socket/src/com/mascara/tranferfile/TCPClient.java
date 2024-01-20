package com.mascara.tranferfile;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 20/01/2024
 * Time      : 7:12 CH
 * Filename  : TCPClient
 */
public class TCPClient {
    //    create Socket object
    private Socket client;
    private String serverHost = "localhost";
    private int serverPort = 9900;
    private JTextArea textArea;

    public TCPClient(String host, int port, JTextArea textArea) {
        this.serverHost = host;
        this.serverPort = port;
        this.textArea = textArea;
    }

    //    connect to server
    public void connectServer() {
        try {
            client = new Socket(serverHost, serverPort);
            textArea.append("Connected to server.\n");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    send file to server
    public void sendFile(String sourceFilePath, String destinationDir) {
        DataOutputStream outToServer = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
//            make greeting
            outToServer = new DataOutputStream(client.getOutputStream());
            outToServer.writeUTF("Hello from " + client.getLocalSocketAddress());

//            get file info
            FileInfo fileInfo = getFileInfo(sourceFilePath, destinationDir);

//            send file
            oos = new ObjectOutputStream(client.getOutputStream());
            oos.writeObject(fileInfo);

//            get confirmation
            ois = new ObjectInputStream(client.getInputStream());
            fileInfo = (FileInfo) ois.readObject();
            if (fileInfo != null) {
                System.out.println(fileInfo.getStatus());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private FileInfo getFileInfo(String sourceFilePath, String destinationDir) {
        FileInfo fileInfo = null;
        BufferedInputStream bis = null;
        try {
            File sourceFile = new File(sourceFilePath);
            bis = new BufferedInputStream(new FileInputStream(sourceFile));
            fileInfo = new FileInfo();
            byte[] fileBytes = new byte[(int) sourceFile.length()];

//            get file info
            bis.read(fileBytes, 0, fileBytes.length);
            fileInfo.setFileName(sourceFile.getName());
            fileInfo.setDataBytes(fileBytes);
            fileInfo.setDestinationDirectory(destinationDir);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(bis);
        }
        return fileInfo;
    }

    //    close socket
    public void closeSocket() {
        try {
            if (client != null) {
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
