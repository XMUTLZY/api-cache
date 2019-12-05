package sch.xmut.jake.cache.apicache.web.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jake.lin on 2019/12/05
 */
public class SystemUtils {
    /**
     * @Tips: convert key to standard format
     */
    public static String buildKey(String member, String key) {
        return member + ":" + key;
    }

    /**
     * @Tips: convert date to standard format
     */
    public static String dateToFormat(Date date) {
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dFormat.format(date);
    }
}
