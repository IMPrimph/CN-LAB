import java.io.*;
import java.net.*;
public class Talkclient {
    public static void main(String args[]) throws Exception
    {
        try
        {
            int Port;
            BufferedReader Buf =new BufferedReader(new
                    InputStreamReader(System.in));
            System.out.print(" Enter the Port Address : " );
            Port=Integer.parseInt(Buf.readLine());
            Socket sok=new Socket("localhost",Port);
            if(sok.isConnected()==true)
                System.out.println(" Server Socket is Connected Successfully. ");
            InputStream in=sok.getInputStream();
            OutputStream ou=sok.getOutputStream();
            PrintWriter pr=new PrintWriter(ou);
            BufferedReader br1=new BufferedReader(new
                    InputStreamReader(in));
            BufferedReader br2=new BufferedReader(new
                    InputStreamReader(System.in));
            String str;
            while(true)
            {
                System.out.print(" Enter the Message : ");
                str=br2.readLine();
                pr.println(str);
                pr.flush();
                System.out.println(" Message From Server : " + br1.readLine());
            }
        }
        catch(Exception e)
        {
            System.out.println(" Error : " + e.getMessage());
        }
    }
}
