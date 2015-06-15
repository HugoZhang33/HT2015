package data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

public final class ConferenceInfoParser {
    private static Hashtable<String, String> Datetrans;

    static {
        Datetrans = new Hashtable<String, String>();
        Datetrans.put("2015-06-29", "Monday, Jun.29");
        Datetrans.put("2015-06-30", "Tuesday, Jun.30");
        Datetrans.put("2015-07-01", "Wednesday, July.1");
        Datetrans.put("2015-07-02", "Thursday, July.2");
        Datetrans.put("2015-07-03", "Friday, July.3");
    }

    public static void getConferenceInfo(String conferenceID) {

        InputStream stream = null;
        try {
            //Use Post Method
            String urlString = new String("http://halley.exp.sis.pitt.edu/cn3/loadAllConferences.php?conferenceID=134");

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            stream = conn.getInputStream();

            String jsonStr = convertToString(stream);

            JSONArray jsonArray = new JSONArray(jsonStr);
            JSONObject conJson = (JSONObject) jsonArray.get(0);
            conJson.getString("shortTitle");

            Conference.id = conJson.getString("eventID");

            Conference.title = conJson.getString("title");
            Conference.description = conJson.getString("abstract");

            Conference.location = conJson.getString("location");
            Conference.twitter_item = conJson.getString("twitter_item");
            Conference.twitter_item_active = conJson.getString("twitter_item_active");
            Conference.twitter_widget_id = conJson.getString("twitter_widget_id");
            Conference.twitter_handler = conJson.getString("twitter_handler");
            Conference.twitter_hashtag = conJson.getString("twitter_hashtag");
            Conference.homepage = conJson.getString("home_page");

            // transform data
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(conJson.getString("beginDate"));
                Conference.startDate = Datetrans.get(formatter.format(date));

                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(conJson.getString("endDate"));
                Conference.endDate = Datetrans.get(formatter.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            stream.close();
        } catch (JSONException ee) {
            ee.printStackTrace();
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            try {
                if (stream != null)
                    stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String convertToString(InputStream is) {
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
