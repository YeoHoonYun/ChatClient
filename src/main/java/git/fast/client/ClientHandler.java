package git.fast.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-02
 * Github : https://github.com/YeoHoonYun
 */
public class ClientHandler extends Thread {
    private Socket socket = null;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream in = null;
        try {
            in = new DataInputStream(socket.getInputStream());
            while (true) {
                System.out.println(in.readUTF());
            }
        } catch (IOException e) {
            System.out.println("접속을 종료합니다.");
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
