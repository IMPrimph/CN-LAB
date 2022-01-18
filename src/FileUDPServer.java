import java.io.*;
import java.net.*;
import java.util.*;

public class FileUDPServer {
    public static void UDPServer() throws  IOException{
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
