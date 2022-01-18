import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

//public class FileTCPClient {
//    public static void main() {
//        try{
//            byte[] b = new byte[3000];
//            Socket s = new Socket("localhost",4333);
//            InputStream is = s.getInputStream();
//            FileOutputStream f = new FileOutputStream("E:\\cnlab1.txt");
//            is.read(b,0,b.length);
//            f.write(b,0,b.length);
//            System.out.println("File received Successfully");
//        }
//        catch (Exception e){
//            System.out.println("error:"+e.getMessage());
//        }
//    }
//}

public class FileTCPClient {

    Socket s;

    public FileTCPClient(String host, int port, String file) {
        try {
            s = new Socket(host, port);
            sendFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendFile(String file) throws IOException {
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[4096];

        while (fis.read(buffer) > 0) {
            dos.write(buffer);
        }

        fis.close();
        dos.close();
    }

    public static void main() {
        FileTCPClient fc = new FileTCPClient("localhost", 1988, "E:\\cnlab.txt");
    }

}
