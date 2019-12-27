package sch.xmut.jake.cache.apicache.web.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sch.xmut.jake.cache.apicache.constants.CacheConstans;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.request.RecordRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.service.aopRecord.RecordService;
import sch.xmut.jake.cache.apicache.web.utils.SystemUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Jake.lin on 2019/12/24
 * @Title: 记录访问Controller的所有请求，保存在mongodb中
 */
@Component
@Aspect
public class RecordControllerRequestAop {
    @Autowired
    private RecordService recordService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("pointCut()")
    public void Before() {
        logger.info("before controller init");
    }

    @Pointcut("execution(* sch.xmut.jake.cache.apicache.web.controller..*.*(..))")
    public void pointCut() {
        logger.info("pointCut controller init");
    }

    @AfterReturning(returning = "response", value = "pointCut()")
    public void afterRunning(JoinPoint joinPoint, Object response) {
        logger.info("afterRunning init");
        BaseResponse baseResponse = (BaseResponse) response; // response
        CacheRequest cacheRequest = (CacheRequest) joinPoint.getArgs()[0];// request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        RecordRequest recordRequest = buildRecordReuqest(request, cacheRequest);
        recordRequest.setMethod(joinPoint.getSignature().getName());
        if (BaseResponse.SUCCESS_CODE == baseResponse.getStatusCode()) {
            recordService.insert(recordRequest);
        } else {
            logger.warn("response error, skip controller record");
        }
        logger.info("complete controller record");
    }

    private RecordRequest buildRecordReuqest(HttpServletRequest request, CacheRequest cacheRequest) {
        RecordRequest recordRequest = new RecordRequest();
        recordRequest.setUrl(request.getRequestURL().toString());
        recordRequest.setContentType(request.getContentType());
        recordRequest.setMethodType(request.getMethod());
        recordRequest.setParams(JSONObject.toJSONString(cacheRequest));
        recordRequest.setProjectMember(cacheRequest.getMember());
        recordRequest.setRecordType(CacheConstans.RECORD_TYPE_CONTROLLER);
        recordRequest.setCreateTime(SystemUtils.dateToFormat(new Date()));
        return recordRequest;
    }
}
