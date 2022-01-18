import java.net.*;
import java.io.*;

public class ChatClient {
    public static void main(String args[])throws Exception
    {
        Socket sk=new Socket("localhost",2000);
        BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
        PrintStream sout=new PrintStream(sk.getOutputStream());
        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while(true)
        {
            System.out.print("client:");
            s=stdin.readLine();
            sout.println(s);
            s=sin.readLine();
            System.out.print("server:"+s+"\n");
            if(s.equalsIgnoreCase("bye"))
                break;
        }
        sk.close();
        sin.close();
        sout.close();
        stdin.close();
    }
}
