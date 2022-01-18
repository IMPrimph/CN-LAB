import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class SemServer1 {
    public static void main(String[] args) {
        try
        {
            int Port = 8000;
            BufferedReader Buf =new BufferedReader(new InputStreamReader(System.in));
//            System.out.print("Enter the Port Address: ");
//            Port=Integer.parseInt(Buf.readLine());
            ServerSocket ss=new ServerSocket(Port);
            System.out.println("Server is Ready To Receive a Command. ");
            System.out.println("Waiting ..... ");
            Socket s=ss.accept();
            if(s.isConnected()==true)
                System.out.println("Client Socket is Connected Successfully. ");
            InputStream in=s.getInputStream();
            OutputStream ou=s.getOutputStream();
            BufferedReader buf=new BufferedReader(new InputStreamReader(in));
            PrintWriter pr=new PrintWriter(ou);


            String card_no,card_type,aos;

            card_no = buf.readLine();
            card_type = buf.readLine();
            aos = buf.readLine();

            System.out.println(card_no);
            System.out.println(card_type);
            System.out.println(aos);

/**
 111111111111111
 4242424242424242
 4012888888881881
 4263982640269299
 4917484589897107
 **/

            Integer req=Integer.parseInt(aos);

            HashMap<String, Double> details = new HashMap<String, Double>();
            details.put("12345", 10000.00);
            details.put("23456", 5500.0);
            details.put("34567", 5000.00);
            details.put("45678", 3000.00);
            details.put("56789", 24000.00);
            details.put("10000", 1000.00);

            Double avail_bal = details.get(card_no);
            Double request = 105*1.0 / 100 * req;


            if(details.containsKey(card_no) )
            {
                String[] det = new String[]{card_type,avail_bal.toString(), aos};
                Double ans = SemServer2.main(det);
                System.out.println(card_type+" "+avail_bal+" "+aos);
                if(ans>=0){
                    details.put(card_no, ans);

                    pr.println("Successful transaction!, your new balance is- " + details.get(card_no));
                }
                else {
                    pr.println("Failure :( You don't have sufficient balance!");
                }
            }
            else {
                pr.println("Failure! Invalid Card No");
            }

            pr.flush();
        }
        catch(Exception e)
        {
            System.out.println(" Error : " + e.getMessage());
        }


    }
}
