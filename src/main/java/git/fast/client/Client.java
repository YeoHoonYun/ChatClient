package git.fast.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
        DataInputStream in = null;

        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());


        }catch (Exception e){

        }finally {
            try {
                in.close();
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


    }

}
