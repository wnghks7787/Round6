import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class ServerRunner {
    HashMap clients;

    ServerRunner()
    {
        clients = new HashMap();
        Collections.synchronizedMap(clients);
    }

    public void start()
    {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 시작되었습니다.");

            while(true)
            {
                socket = serverSocket.accept();
                System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속하였습니다.");
                ServerReceiver thread = new ServerReceiver(socket);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void sendPoint(int x)
    {
        Iterator it = clients.keySet().iterator();

        while(it.hasNext())
        {
            try {
                DataOutputStream output = (DataOutputStream) clients.get(it.next());
                output.writeInt(x);
            } catch(IOException e) {}
        }
    }

    void sendToAll(String msg)
    {
        Iterator it = clients.keySet().iterator();

        while(it.hasNext())
        {
            try {
                DataOutputStream out = (DataOutputStream)clients.get(it.next());
                out.writeUTF(msg);
            } catch (IOException e) {}
        }
    }
    public static void main(String[] args) {
        new ServerRunner().start();
    }

    class ServerReceiver extends Thread
    {
        Socket socket;
        DataInputStream in;
        DataOutputStream out;

        ServerReceiver(Socket socket)
        {
            this.socket = socket;
            try {
                in =  new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {}
        }

        public void run()
        {
            String name = "";

            try {
                name = in.readUTF();
                sendToAll("#" + name + "님이 들어오셨습니다.");

                clients.put(name, out);
                System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");

                while(in != null)
                    sendToAll(in.readUTF());

//                while(in != null)
//                    sendPoint(in.readInt());

//                System.out.println(in.readInt());

            } catch (IOException e) {

            } finally {
                sendToAll("#" + name + "님이 나가셨습니다.");
                clients.remove(name);
                System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속을 종료했습니다.");
                System.out.println("현재 서버접속자 수는" + clients.size() + "입니다.");
            }

//            try {
//                int x = in.readInt();
//                sendPoint(x);
//            } catch(IOException e) {}
        }
    }


    static String getTime()
    {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
}