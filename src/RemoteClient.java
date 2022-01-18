import java.net.*;
import java.io.*;

public class RemoteClient {
    public static void main(String[] args) {
        try{
            int port;
            BufferedReader Buf=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("enter the port address");
            port=Integer.parseInt(Buf.readLine());
            Socket s=new Socket("localhost",port); if(s.isConnected()==true)
                System.out.println("server socket is connected successfully)");
            InputStream in=s.getInputStream();
            OutputStream ou=s.getOutputStream();
            BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
            BufferedReader buf1=new BufferedReader(new InputStreamReader(in));
            PrintWriter pr=new PrintWriter(ou);
            System.out.println("enter the command to be executed"); pr.println(buf.readLine()); pr.flush();
            String str=buf1.readLine();
            System.out.println(" "+str+"opened successfully");
            System.out.println("the"+str+"the command is executed successfully");
            pr.close();
            ou.close();
            in.close();

        } catch (Exception e){
            System.out.println("error:"+e.getMessage());
        }
    }
}
