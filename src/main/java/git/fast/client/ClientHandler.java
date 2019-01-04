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
                String string = in.readUTF();
                if(string.split("///")[0].equals("400")){
                    System.out.println("* 서버와 연결을 끊습니다.");
                    System.out.println("채팅 프로그램을 종료합니다.");
                    System.exit(0);
                }
                else if(string.split("///")[0].equals("100")){
                    System.out.println("* 닉네임 정보가 설정되었습니다.");
                    System.out.println(string.split("///")[1]);
                }
                else if(string.split("///")[0].equals("200")){
                    System.out.println("* 유저로부터의 메시지입니다.");
                    System.out.println(string.split("///")[1]);
                }
                else if(string.split("///")[0].equals("300")){
                    System.out.println("* 서버로부터의 메시지입니다.");
                    System.out.println(string.split("///")[1]);
                }
                else{
                    System.out.println(string);
                }
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
