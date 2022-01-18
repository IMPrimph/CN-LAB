import java.io.*;
import java.net.*;
import java.util.*;

public class FileUDPClient {
    public static void UDPClient() throws IOException {
        try{
                String str;
                byte[] b=new byte[1024];
                DatagramSocket ds=new DatagramSocket(1000);
                System.out.println("UDP file receiver");
                System.out.println("The content of the file is:");
                while(true)
                {
                    DatagramPacket dp=new DatagramPacket(b,b.length);
                    ds.receive(dp);
                    str=new String(dp.getData(),0,dp.getLength());
                    System.out.println(str);
                    System.out.println("The file received successfully");
                    ds.close();
                }

        }
        catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
}
