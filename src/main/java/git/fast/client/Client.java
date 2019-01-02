package git.fast.client;

import java.io.*;
import java.net.Socket;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-02
 * Github : https://github.com/YeoHoonYun
 */
public class Client {
    Socket socket = null;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void connect(){
        DataOutputStream out = null;
        BufferedReader br= null;

        try {
            out = new DataOutputStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            ClientHandler clientHandler = new ClientHandler(socket);
            clientHandler.start();

            while(true){
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


    }

}
