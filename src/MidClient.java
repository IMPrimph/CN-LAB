import javax.swing.*;
import java.io.*;
import java.net.*;

class Connect {
    private String USERNAME = "abhi";
    private String PASSWORD = "abhi";
    private int PORT = 9090;
    private String HOSTNAME = "localhost";

    public String getUsername(){
        return this.USERNAME;
    }

    public String getPassword(){

        return this.PASSWORD;
    }

    public int getPort(){
        return this.PORT;
    }

    public String gethostName(){
        return this.HOSTNAME;
    }
}

class duplicate{
    public void myMethod(String str2){
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

public class MidClient {
    private final String FILENAME = null;
    Connect c = new Connect();
    Socket socket;
    BufferedReader read;
    PrintWriter output;

    public void startClient() throws UnknownHostException, IOException{
        //Create socket connection
        socket = new Socket(c.gethostName(), c.getPort());

        //create printWriter for sending login to server
        output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        //prompt for user name
        String username = JOptionPane.showInputDialog(null, "Enter User Name:");

        //send user name to server
        output.println(username);

        //prompt for password
        String password = JOptionPane.showInputDialog(null, "Enter Password");

        //send password to server
        output.println(password);

        //prompt for filename
        String inp = JOptionPane.showInputDialog(null, "Select filename");

        //send password to server
        output.println(inp);
        output.flush();

        //create Buffered reader for reading response from server
        read = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //read response from server
        String response = read.readLine();
        System.out.println("This is the response: " + response);

        //display response
        JOptionPane.showMessageDialog(null, response);

               FileTCPClient.main();

//        System.out.println("before try");
//        try{
//            System.out.println("inside try");
//            byte[] b = new byte[3000];
//            Socket s = new Socket("localhost",1000);
//            InputStream is = s.getInputStream();
//            FileOutputStream f = new FileOutputStream("E:\\cnlab1.txt");
//            is.read(b,0,b.length);
//            f.write(b,0,b.length);
//            System.out.println("File received Successfully");
//        }
//        catch (Exception e){
//            System.out.println("error:"+e.getMessage());
//        }
//        finally {
            output.flush();
//        }

    }

    public void fileInfo(){

    }

    public static void main(String args[]){
        MidClient client = new MidClient();
        try {
            client.startClient();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
