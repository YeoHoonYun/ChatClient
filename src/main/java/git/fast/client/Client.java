package git.fast.client;

import java.io.*;
import java.net.ServerSocket;
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
        BufferedReader br= null;

        try {
            socket = new Socket(ip,port);
            out = new DataOutputStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));

            ClientHandler clientHandler = new ClientHandler(socket);
            clientHandler.start();

            while(true){
                System.out.print("text를 입력하세요. : ");
                String text = br.readLine();

                out.writeUTF(text);
                out.flush();
            }

        }catch (Exception e){

        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client("localhost" , 8000);
        client.connect();
    }

}
