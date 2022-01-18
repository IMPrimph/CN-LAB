import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;

public class WebPageDownload {
    public static void DownloadWebPage(String webpage) {
        try{
            URL url = new URL(webpage);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter("data.html"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();
            System.out.println("Successfully Downloaded");
        }
        catch (MalformedURLException mue){
            System.out.println("Malformed URL exception raised");
        }
        catch (IOException ie){
            System.out.println("IO exception raised");
        }
    }
    public static void main(String[] args) throws  Exception{
            String url = "https://www.google.com";
            DownloadWebPage(url);
    }
}
