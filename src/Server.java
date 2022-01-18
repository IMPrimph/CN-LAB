import java.net.*;
import java.io.*;


public class Server {
    public static void main(String[] args) throws Exception{
        try{
            int port;
            BufferedReader Buf=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("enter the port address");
            port=Integer.parseInt(Buf.readLine());
            ServerSocket sck=new ServerSocket(port);
            System.out.println("Server is ready to receive a message");
            System.out.println("Waiting for client socket connection");
            Socket so=sck.accept();
            if(so.isConnected()==true)
                System.out.println("Client socket is connected successfully");
            InputStream in=so.getInputStream();
            OutputStream ou=so.getOutputStream();
            PrintWriter pr=new PrintWriter(ou);
            BufferedReader buf;
            buf=new BufferedReader(new InputStreamReader(in));
            String str=buf.readLine();
            System.out.println("Message received from client :"+str);
            System.out.println("This message is forwarded to client"); pr.println(str); pr.flush();

        }
        catch(Exception e) {
            System.out.println("error"+e.getMessage());
        }
    }
}
