package download;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
public class Decoder {

    public static String DecodeFromUrl(String unicode)
    {
        try {
            return URLDecoder.decode(unicode,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args)
    {
        System.out.println(Decoder.DecodeFromUrl("疑犯追踪"));
    }
}
