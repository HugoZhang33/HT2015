package data;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CheckDBUpdate {
    public boolean needUpdate;


    public boolean compare() {
        String result = getTimestamp();
        if (result == null || !Character.isDigit(result.charAt(0)) ||
                result.compareTo(Conference.timstamp) == 0 || !Character.isDigit(Conference.timstamp.charAt(0)))
            needUpdate = false;
        else {
            needUpdate = true;
            Conference.timstamp = result;
        }

        return needUpdate;
    }

    public boolean check() {
        String result = getTimestamp();
        System.out.println("+++++++++++++++from server: " + result);
        System.out.println("+++++++++++++++: " + Conference.timstamp);
        if (result == null || !Character.isDigit(result.charAt(0)) ||
                result.compareTo(Conference.timstamp) == 0 || !Character.isDigit(Conference.timstamp.charAt(0)))
            needUpdate = false;
        else {
            needUpdate = true;
        }

        return needUpdate;
    }

    public String getTimestamp() {
        String result = null;
        try {
            URL url = new URL(ConferenceURL.CheckUpdate + "eventID=" + Conference.id);
            InputStream in = url.openStream();
            result = convertToString(in);
            int start = result.indexOf("<timestamp>");
            int end = result.indexOf("</timestamp>");
            result = result.substring(start+11, end);
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private String convertToString(InputStream is) {
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

