import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SemClient {
    public static void main(String args[])
    {
        try
        {
            int Port = 8000;
            BufferedReader Buf =new BufferedReader(new InputStreamReader(System.in));
//            System.out.print(" Enter the Port Address : " );
//            Port=Integer.parseInt(Buf.readLine());
            Socket s=new Socket("localhost",Port);
            if(s.isConnected()==true)
                System.out.println("Server Socket is Connected Successfully. ");
            InputStream in=s.getInputStream();
            OutputStream ou=s.getOutputStream();
            BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
            BufferedReader buf1=new BufferedReader(new InputStreamReader(in));
            PrintWriter pr=new PrintWriter(ou);

            String card_no,str2,card_type,aos;
            System.out.println("Enter the Card Number :");
            card_no=buf.readLine();
            pr.println(card_no);
            pr.flush();


            System.out.println("Enter the credit card type(visa (or) master): ");
            card_type = buf.readLine();
            pr.println(card_type);
            pr.flush();


            System.out.println("Enter the sales amount: ");
            aos = buf.readLine();
            pr.println(aos);
            pr.flush();


            String success = buf1.readLine();
            System.out.println(success);
        }
        catch(Exception e)
        {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
