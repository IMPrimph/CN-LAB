import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws  Exception{
        try{
            int port;
            BufferedReader Buf=new BufferedReader(new
                    InputStreamReader(System.in));
            System.out.println("enter the port address");
            port=Integer.parseInt(Buf.readLine());
            Socket suk=new Socket("Localhost",port);
            if(suk.isConnected()==true)
                System.out.println("Server Socket is connected");
            InputStream in=suk.getInputStream();
            OutputStream ou=suk.getOutputStream();
            PrintWriter pr=new PrintWriter(ou);
            BufferedReader Buf2=new BufferedReader(new InputStreamReader(in));
            String str1,str2;


            System.out.println("Enter the message");
            str1=Buf.readLine();
            pr.println(str1);
            pr.flush();
            System.out.println("Message sent successfully");
            str2=Buf2.readLine();
            System.out.println("Message from server"+str2);

        } catch (Exception e){
            System.out.println("error"+e.getMessage());
        }
    }
}
