package download;


import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class Download {

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        String destination = "G:/"; // This is the destination of your local machine
        for(int i = 1;i<24;i++) // Change the start of i and end of i to fit the range of videos / other files (Ex. this example start at Episode 1 and end at Episode 24)
        {
            String address = "http://anning.luanniao-zuida.com/1908/疑犯追踪第五季-"; // This is the URL pattern you want to put in
            if(i<10)
            {
                address+="0";
            }
            address+=i;
            address+=".mp4"; // This is the Suffix (后缀) of the online file
            downloadFromUrl(address, destination); // Download the file
            Thread.sleep(1000); // Sleep to avoid some anti-spider detection
            System.out.println(address);
        }
    }


    public static String downloadFromUrl(String url,String dir) {

        try {
            URL httpurl = new URL(url);
            String fileName = getFileNameFromUrl(url);
            System.out.println(fileName);
            File f = new File(Decoder.DecodeFromUrl(dir + fileName)); // Use Decoder to change potential Unicode to UTF-8 codes.
            FileUtils.copyURLToFile(httpurl, f);
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail!";
        }
        return "Success!";
    }

    public static String getFileNameFromUrl(String url){
        String name = new Long(System.currentTimeMillis()).toString() + ".X";
        int index = url.lastIndexOf("/");
        if(index > 0){
            name = url.substring(index + 1);
            if(name.trim().length()>0){
                return name;
            }
        }
        return name;
    }
}
