import java.io.*;
import java.net.*;

public class Ping {
    public static void main(String args[])
    {
        try
        {
            String str;
            System.out.print(" Enter the IP Address to be Ping : ");
            BufferedReader buf1=new BufferedReader(new
                    InputStreamReader(System.in));
            String ip=buf1.readLine();
            Runtime H=Runtime.getRuntime();
            Process p=H.exec("ping " + ip);
            InputStream in=p.getInputStream();
            BufferedReader buf2=new BufferedReader(new
                    InputStreamReader(in));
            while((str=buf2.readLine())!=null)
            {
                System.out.println(" " + str);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
