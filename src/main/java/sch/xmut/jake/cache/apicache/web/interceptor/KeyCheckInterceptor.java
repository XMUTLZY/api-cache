package sch.xmut.jake.cache.apicache.web.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import sch.xmut.jake.cache.apicache.service.KeyService;
import sch.xmut.jake.cache.apicache.web.annotation.KeyRequired;
import sch.xmut.jake.cache.apicache.web.utils.SystemUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jake.lin on 2019/12/09
 * @Tips: 判断key值是否存在  拦截器
 */
public class KeyCheckInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private KeyService keyService;
    public static final Integer MEMBER_BE_NULL = 431;
    public static final Integer KEY_BE_NULL = 432;
    public static final Integer KEY_NO_EXISTS = 433;
    public static final String CHARSET_ENCODING = "UTF-8";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) { // 如果注解不标记在方法上，则不进行拦截
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.getAnnotation(KeyRequired.class) != null) {
            JSONObject jsonObject = SystemUtils.getRequestBody(request);
            String member = (String) jsonObject.get("member");
            String key = (String) jsonObject.get("key");
            if (!StringUtils.hasText(member)) {
                buildHttpServletResponse(response, MEMBER_BE_NULL, "{\"status\":" + MEMBER_BE_NULL + ",\n\"message\":\"the member can't no be null.\"}");
                return false;
            } else if (!StringUtils.hasText(key)) {
                buildHttpServletResponse(response, KEY_BE_NULL, "{\"status\":" + KEY_BE_NULL + ",\n\"message\":\"the key can't no be null.\"}");
                return false;
            } else {
                List<String> keyList = Arrays.asList(SystemUtils.buildKey(member, key));
                if (!keyService.isExistsByKeyList(keyList).get(keyList.get(0))) {
                    buildHttpServletResponse(response, KEY_NO_EXISTS, "{\"status\":" + KEY_NO_EXISTS + ",\n\"message\":\"the key(member+key) no exist.\"}");
                    return false;
                }
            }
        }
        return true;
    }

    private void buildHttpServletResponse(HttpServletResponse response, Integer statusCode, String message) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(CHARSET_ENCODING);
        response.setStatus(statusCode);
        response.getWriter().write(message);
        response.getWriter().close();
    }
}
