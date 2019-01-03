package git.fast.client;

import java.io.*;
import java.net.Socket;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-02
 * Github : https://github.com/YeoHoonYun
 */
public class Client {
    private String ip;
    private int port;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void connect(){
        Socket socket = null;
        DataOutputStream out = null;
        BufferedReader br = null;
        try {
            socket = new Socket(ip, port);
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new DataOutputStream(socket.getOutputStream());

            System.out.println("소켓을 연결합니다.");

            ClientHandler clientHandler = new ClientHandler(socket);
            clientHandler.start();

            while(true){
                String string = br.readLine();
                if(string.equals("/quit"))
                    return;
                out.writeUTF(string);
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 8000);
        client.connect();

    }

}
