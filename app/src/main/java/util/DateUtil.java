package util;

import java.util.Hashtable;

/**
 * Created by hongzhang on 8/24/15.
 */
public class DateUtil {
    public static Hashtable<String, String> Datetrans;
    public static Hashtable<String, String> Dtrans;

    static {
        Datetrans = new Hashtable<String, String>();
        Datetrans.put("2015-09-01", "Tuesday, Sept.1");
        Datetrans.put("2015-09-02", "Wednesday, Sept.2");
        Datetrans.put("2015-09-03", "Thursday, Sept.3");
        Datetrans.put("2015-09-04", "Friday, Sept.4");

        Dtrans = new Hashtable<String, String>();
        Dtrans.put("2015-09-01", "1");
        Dtrans.put("2015-09-02", "2");
        Dtrans.put("2015-09-03", "3");
        Dtrans.put("2015-09-04", "4");
    }
}
