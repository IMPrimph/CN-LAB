import java.net.*;
import java.io.*;

public class RemoteServer {
    public static void main(String[] args) {
        try{
            int port;
            BufferedReader Buf=new BufferedReader(new InputStreamReader(System.in)); System.out.println("enter the port address");
            port=Integer.parseInt(Buf.readLine());
            ServerSocket ss=new ServerSocket(port);
            System.out.println("server is ready to receive a command");
            System.out.println("waiting..."); Socket s=ss.accept();
            if(s.isConnected()==true)
                System.out.println("client socket is connected successfully");
            InputStream in=s.getInputStream();
            OutputStream ou=s.getOutputStream();
            BufferedReader buf=new BufferedReader(new InputStreamReader(in));
            String cmd=buf.readLine(); PrintWriter pr=new PrintWriter(ou); pr.println(cmd);
            Runtime H=Runtime.getRuntime();
            Process p; p = H.exec(cmd);
            System.out.println("the "+cmd+" command is executed successfully");
            pr.flush();
            pr.close();
            ou.close();
            in.close();
        }
        catch (Exception e){
            System.out.println("error:"+e.getMessage());
        }
    }
}
