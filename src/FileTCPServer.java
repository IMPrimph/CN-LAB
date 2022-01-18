import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//public class FileTCPServer {
//    public static void main() throws Exception{
//        try {
//            ServerSocket a = new ServerSocket(4333);
//            Socket s1 =a.accept();
//            FileInputStream f1 = new FileInputStream("E:\\cnlab.txt");
//            byte b[]=new byte[3000];
//            f1.read(b,0,b.length);
//            OutputStream os = s1.getOutputStream();
//            os.write(b,0,b.length);
//            System.out.println("File Sent Successfully");
//
//    } catch (Exception e){
//            System.out.println("error:"+e.getMessage());
//        }
//    }
//}

public class FileTCPServer extends Thread {

    private ServerSocket ss;

    public FileTCPServer(int port) {
        try {
            ss = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                Socket clientSock = ss.accept();
                saveFile(clientSock);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveFile(Socket clientSock) throws IOException {
        DataInputStream dis = new DataInputStream(clientSock.getInputStream());
        FileOutputStream fos = new FileOutputStream("E:\\cnlab1.txt");
        byte[] buffer = new byte[4096];

        int filesize = 15123; // Send file size in separate msg
        int read = 0;
        int totalRead = 0;
        int remaining = filesize;
        while((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
            totalRead += read;
            remaining -= read;
            System.out.println("read " + totalRead + " bytes.");
            fos.write(buffer, 0, read);
        }

        fos.close();
        dis.close();
    }

    public static void main() {
        FileTCPServer fs = new FileTCPServer(1988);
        fs.start();
    }

}

