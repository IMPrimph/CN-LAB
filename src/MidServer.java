import javax.swing.*;
import java.io.*;
import java.net.*;

class duplicate2{
    public void myMethod(String str2){
        try{
            int i=0; byte[] b=new byte[1024];
            DatagramSocket ds=new DatagramSocket(2000);
            System.out.println("UDP file sender");
            File fname=new File("E:\\cnlab.txt");
            FileInputStream fi=new FileInputStream(fname);
            InetAddress ip=InetAddress.getLocalHost();
            while(fi.available()!=0)
            {
                b[i]=(byte)fi.read();
                i++;
            }
            fi.close();
            DatagramPacket dp=new DatagramPacket(b,i,ip,1000);
            ds.send(dp);
            System.out.println("The file is sent successfully");


        }
        catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
}

public class MidServer {
    private int currentTot;
    ServerSocket serversocket;
    Socket client;
    int bytesRead;
    Connect c = new Connect();
    BufferedReader input;
    PrintWriter output;

    public void start() throws IOException{
        System.out.println("Connection Starting on port:" + c.getPort());
        //make connection to client on port specified
        serversocket = new ServerSocket(c.getPort());

        //accept connection from client
        client = serversocket.accept();

        System.out.println("Waiting for connection from client");

        try {
            logInfo();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void logInfo() throws Exception{
        //open buffered reader for reading data from client
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String username = input.readLine();
        System.out.println("SERVER SIDE" + username);
        String password = input.readLine();
        System.out.println("SERVER SIDE" + password);
        String inp = input.readLine();
        System.out.println("INP is" + inp);

        //open printwriter for writing data to client
        output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

        if(username.equals(c.getUsername()) && password.equals(c.getPassword())){
            output.println("Login Success");
//            byte b[]=new byte[1024];
//            FileInputStream f=new FileInputStream("D://raj.txt");
//            DatagramSocket dsoc=new DatagramSocket(1000);
//            int i=0;
//            while(f.available()!=0)
//            {
//                b[i]=(byte)f.read();
//                i++;
//            }
//            f.close();
//            System.out.println(b);
//            dsoc.send(new DatagramPacket(b,i,InetAddress.getLocalHost(),1000));

//            int i=0;
//            byte[] b=new byte[1024];
//            DatagramSocket ds=new DatagramSocket(2000);
//            File fname=new File("D:\\raj.txt");
//            FileInputStream fi=new FileInputStream(fname);
//            InetAddress ip=InetAddress.getLocalHost();
//            while(fi.available()!=0)
//            {
//                b[i]=(byte)fi.read();
//                i++;
//            }
//            fi.close();
//            DatagramPacket dp=new DatagramPacket(b,i,ip,1000);
//            ds.send(dp);
//            System.out.println(b);
//            duplicate2 d2 = new duplicate2();
//            d2.myMethod("skajdh");
//            FileTCPServer obj = new FileTCPServer();
//            obj.TCPServer();
//            System.out.println("before try");
//            try {
//                System.out.println("after try");
//                ServerSocket a = new ServerSocket(1000);
//                Socket s1 =a.accept();
//                FileInputStream f1 = new FileInputStream("E:\\cnlab.txt");
//                byte b[]=new byte[3000];
//                f1.read(b,0,b.length);
//                OutputStream os = s1.getOutputStream();
//                os.write(b,0,b.length);
//                System.out.println("File Sent Successfully");
//
//            } catch (Exception e){
//                System.out.println("error:"+e.getMessage());
//            }
            FileTCPServer.main();
//            FileTCPClient.main();


        }else{
            output.println("Login Failed");
        }
        output.flush();
        output.close();

    }
    public static void main(String[] args){
        MidServer server = new MidServer();
        try {
            server.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
