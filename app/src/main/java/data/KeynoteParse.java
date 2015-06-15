package data;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;


public class KeynoteParse {

    private ArrayList<Keynote> knList = new ArrayList<Keynote>();
    private Hashtable<String, String> Datetrans, Dtrans;

    public void daytoDate() {
        Datetrans = new Hashtable<String, String>();
        Datetrans.put("2015-06-29", "Monday, Jun.29");
        Datetrans.put("2015-06-30", "Tuesday, Jun.30");
        Datetrans.put("2015-07-01", "Wednesday, July.1");
        Datetrans.put("2015-07-02", "Thursday, July.2");
        Datetrans.put("2015-07-03", "Friday, July.3");
    }

    public void daytoid() {
        Dtrans = new Hashtable<String, String>();
        Dtrans.put("2015-06-29", "1");
        Dtrans.put("2015-06-30", "2");
        Dtrans.put("2015-07-01", "3");
        Dtrans.put("2015-07-02", "4");
        Dtrans.put("2015-07-03", "5");
    }

    public KeynoteParse() {
        this.daytoDate();
        this.daytoid();
    }

    public ArrayList<Keynote> getKeynoteData() {

        InputStreamReader isr = null;
        InputStream stream = null;
        try {
            //URL url = new URL("http://halley.exp.sis.pitt.edu/cn3mobile/allSessionsAndPresentations.jsp?eventid=86");

            //Use Post Method
            String urlString = new String("http://halley.exp.sis.pitt.edu/cn3mobile/allSessionsAndPapers.jsp?conferenceID=134&noAbstract=1");

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            stream = conn.getInputStream();


            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser();
            XMLReader xr = saxParser.getXMLReader();

            KeynoteParseHandler khandler = new KeynoteParseHandler();
            xr.setContentHandler(khandler);
            isr = new InputStreamReader(stream, "iso-8859-1");
            //InputStreamReader isr = new InputStreamReader(entity.getContent(),"UTF-8");

            xr.parse(new InputSource(isr));
            stream.close();
            isr.close();
        } catch (Exception ee) {
            System.out.print(ee.toString());
        } finally {
            try {
                if (stream != null)
                    stream.close();
                if (isr != null)
                    isr.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return knList;
    }


    private class KeynoteParseHandler extends DefaultHandler {
        private KeynoteDescriptionParser descriptionParser = new KeynoteDescriptionParser();
        private String contentID = "";
        private Keynote ke;
        private boolean keynoteStart = false;
        private boolean isKeynote = false;
        private StringBuilder sb = new StringBuilder();

        public void startDocument() throws SAXException {
        }

        public void endDocument() throws SAXException {
        }

        public void startElement(String namespaceURI, String localName,
                                 String qName, Attributes atts) throws SAXException {
            sb.setLength(0);
            if (localName.equals("Items")) {
                keynoteStart = true;
                return;
            }
            if (localName.equals("Item")) {
                ke = new Keynote();
                ke.speakerAffiliation = " ";
                ke.description = " ";
                return;
            }
        }

        public void endElement(String namespaceURI, String localName,
                               String qName) throws SAXException {
            if (localName.equals("eventSessionID")) {
                ke.ID = sb.toString();
                return;
            }
            if (localName.equals("sessionDate")) {
                String content = sb.toString();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                try {
                    date = new SimpleDateFormat("MM-dd-yyyy").parse(content);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String str = formatter.format(date);
                ke.date = Datetrans.get(str);
                ke.dayid = Dtrans.get(str);
                return;
            }
            if (localName.equals("contentID")) {
                contentID = sb.toString();
                return;
            }
            if (localName.equals("paperTitle")) {
                ke.title = sb.toString();
                return;
            }
            if (localName.equals("contentType")) {
                if ("Keynote".equals(sb.toString()))
                    isKeynote = true;
                else
                    isKeynote = false;
                return;
            }
            if (localName.equals("begintime") && keynoteStart) {
                ke.beginTime = sb.toString();
                return;
            }
            if (localName.equals("endtime") && keynoteStart) {
                ke.endTime = sb.toString();
                return;
            }
            if (localName.equals("location")) {
                ke.room = sb.toString();
                return;
            }
            if (localName.equals("authors")) {
                ke.speakerName = sb.toString();
                return;
            }
            if (localName.equals("Item")) {
                if (isKeynote) {
                    ke.description = descriptionParser.getDescription(contentID);
                    knList.add(ke);
                }
                isKeynote = false;
                return;
            }
            if (localName.equals("Items")) {
                keynoteStart = false;
                return;
            }
        }

        public void characters(char ch[], int start, int length) {
            sb.append(ch, start, length);
        }
    }

    private class KeynoteDescriptionParser {

        public String getDescription(String ID) {
            String data = "";
            try {
                URL url = new URL("http://halley.exp.sis.pitt.edu/cn3mobile/contentAbstract.jsp?contentID=" + ID);

                InputStream in = url.openStream();
                data = convertToString(in);
                in.close();
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
}
