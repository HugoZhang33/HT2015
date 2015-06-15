package data;


import java.util.regex.Pattern;

public class StringFilter {

    // add the filter to parse the list of the Paper Title
    public String FilterForXML(String inputString) {
        String s = inputString.replaceAll("%", " percent");
        s = s.replaceAll("\"", "\\\"");
        return s;
    }

}
