import javax.swing.*;
import java.io.*;
import java.lang.*;
import java.awt.*;

class Server2 extends JFrame
{
    JTabbedPane jtp1=new JTabbedPane();
    JPanel jp1=new JPanel();
    JTextArea t1=new JTextArea();
    Server2() throws Exception
    {
        super("MegaViewer");
        FileReader f=new FileReader("MyFile.txt");
        BufferedReader brk=new BufferedReader(f);
        String s;
        while((s=brk.readLine())!=null)
            t1.setText(s);
        jp1.add(t1);
        jtp1.addTab("Notice Board",t1);
        add(jtp1);
    }
    public static void display() throws  Exception{
        Server2 mv1=new Server2();
        mv1.pack();
        mv1.setVisible(true);
        mv1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void add(String msg){
        try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(msg);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void delete(){
        File myObj = new File("MyFile.txt");
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
    public static void main(String[] args) throws Exception
    {
        String command = args[0];
        System.out.println(args[0]);
        System.out.println(args[1]);
        if(command.equals(("add"))){
            String s = "";
            for(int i = 1; i < args.length; i++) {
                add(args[i].toString());
            }
        } else if(command.equals("del")){
            delete();
        } else {
            display();
        }
    }
}