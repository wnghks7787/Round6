import src.MainFrame;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClientRunner
{
    static LoginFrame loginFrame;
    MainFrame mainFrame;

    public static void main(String args[])
    {
        loginFrame = new LoginFrame();
    }

    void mainRunner()
    {
        try {
            mainFrame = new MainFrame(loginFrame.getInputName());
            String serverIp = loginFrame.getInputIP();
            Socket socket = new Socket(serverIp, 7777);
            System.out.println("서버에 연결되었습니다.");
            Thread sender = new Thread(new ClientSender(socket, loginFrame.getInputName(), mainFrame));
            Thread receiver = new Thread(new ClientReceiver(socket));

//            new MainFrame(loginFrame.getInputName(), sender, receiver);

            sender.start();
            receiver.start();
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (Exception e) {}
    }

    static class ClientSender extends Thread {
        Socket socket;
        DataOutputStream out;
        String name;

        DataOutputStream xPoint;
        DataOutputStream yPoint;
        DataOutputStream color;

        MainFrame mainFrame;

        ClientSender(Socket socket, String name, MainFrame mainFrame)
        {
            this.mainFrame = mainFrame;
            this.socket = socket;

            try {
                out = new DataOutputStream(socket.getOutputStream());
//                output.write(mainFrame.socketX);
//                out.writeInt(mainFrame.socketX);
//                xPoint = new DataOutputStream(mainFrame.socketX);
                this.name = name;
            } catch (Exception e) {}
        }

        @ Override
        public void run()
        {
            Scanner scanner = new Scanner(System.in);

            try {
                if(out != null)
                    out.writeUTF(name);

                while(out != null)
                    out.writeUTF("[" + name + "]" + scanner.nextLine());

//                while(out != null)


            } catch (IOException e) {}
        }
    }

    static class ClientReceiver extends Thread {
        Socket socket;
        DataInputStream in;

        ClientReceiver(Socket socket)
        {
            this.socket = socket;

            try {
                in = new DataInputStream(socket.getInputStream());
            } catch(IOException e) {}
        }

        @ Override
        public void run()
        {
            while(in != null)
            {
                try {
                    System.out.println(in.readUTF());
//                    System.out.println(in.readInt());
                } catch (IOException e) {}
            }
        }
    }
}