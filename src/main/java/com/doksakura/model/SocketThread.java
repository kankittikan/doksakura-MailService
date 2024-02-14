package com.doksakura.model;

import com.doksakura.service.Parser;

import java.io.*;
import java.net.Socket;

public class SocketThread extends Thread{
    protected Socket socket;

    public SocketThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        InputStream inp = null;
        DataInputStream brinp = null;
        DataOutputStream out = null;
        try {
            inp = socket.getInputStream();
            brinp = new DataInputStream(new BufferedInputStream(inp));
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            return;
        }
        String line = "";
        while (true) {
            try {
                line = brinp.readUTF();
                if (line.equalsIgnoreCase("EXIT")) {
                    socket.close();
                    return;
                } else {
                    out.writeUTF(new Parser().parse(line).toString());
                }
            } catch (IOException e) {
                return;
            }
        }
    }
}