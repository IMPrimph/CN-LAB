import java.io.*;
import java.net.*;
public class TalkServer {
    public static void main(String args[]) throws Exception
    {
        try
        {
            int Port;
            BufferedReader Buf =new BufferedReader(new
                    InputStreamReader(System.in));
            System.out.print(" Enter the Port Address : " );
            Port=Integer.parseInt(Buf.readLine());
            ServerSocket sok =new ServerSocket(Port);
            System.out.println(" Server is Ready To Receive a Message. ");
            System.out.println(" Waiting ..... ");
            Socket so=sok.accept();
            if(so.isConnected()==true)
                System.out.println(" Client Socket is Connected Successfully. ");
            InputStream in=so.getInputStream();
            OutputStream ou=so.getOutputStream();
            PrintWriter pr=new PrintWriter(ou);
            BufferedReader br1=new BufferedReader(new
                    InputStreamReader(System.in));
            BufferedReader br2=new BufferedReader(new
                    InputStreamReader(in));
            String str;
            while(true)
            {
                System.out.println(" Message From Client : " + br2.readLine() );
                System.out.print(" Enter the Message : ");
                str=br1.readLine();
                pr.println(str);
                pr.flush();
            }
        }
        catch(Exception e)
        {
            System.out.println(" Error : " + e.getMessage());
        }
    }
}
