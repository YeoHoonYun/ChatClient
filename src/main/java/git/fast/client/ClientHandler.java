package git.fast.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-02
 * Github : https://github.com/YeoHoonYun
 */
public class ClientHandler extends Thread{
    Socket socket = null;
    DataInputStream in = null;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = new DataInputStream(socket.getInputStream());
            while(true) {
                in.readUTF();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}