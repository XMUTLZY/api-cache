package sch.xmut.jake.cache.apicache.web.utils;

import com.alibaba.fastjson.JSONObject;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    /**
     * @Iips: build error response
     */
    public static void buildErrorResponse(BaseResponse baseResponse) {
        baseResponse.setStatus(BaseResponse.FAILD_STATUS);
        baseResponse.setStatusCode(BaseResponse.FAILD_CODE);
        baseResponse.setMessage("system error." + SystemUtils.dateToFormat(new Date()));
    }

    /**
     * @Tips: get the request body by HttpServletRequest
     */
    public static JSONObject getRequestBody(HttpServletRequest request) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String str = "";
        String wholeStr = "";
        while ((str=bufferedReader.readLine()) != null) {
            wholeStr += str;
        }
        return JSONObject.parseObject(wholeStr);
    }
}
