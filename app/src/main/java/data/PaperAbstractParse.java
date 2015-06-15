package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;


public class PaperAbstractParse {

    public String getPaperAbstract(String ID) {
        String data = null;
        try {
            URL url = new URL("http://halley.exp.sis.pitt.edu/cn3mobile/contentAbstract.jsp?contentID=" + ID);

            InputStream in = url.openStream();
            data = convertToString(in);

            in.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public String convertToString(InputStream is) {
        if (is != null) {
            StringBuilder sb = new StringBuilder();
            String line;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                while ((line = reader.readLine()) != null) {
                    sb.append(line).append(" ");
                }
            } catch (Exception e) {
                System.out.print(e.getMessage());
            } finally {
                try {
                    is.close();
                } catch (Exception e) {

                }
            }
            return sb.toString();
        } else {
            return "";
        }
    }
}
