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
import sch.xmut.jake.cache.apicache.constants.CacheConstans;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.request.RecordRequest;
import sch.xmut.jake.cache.apicache.service.aopRecord.RecordService;
import sch.xmut.jake.cache.apicache.web.utils.SystemUtils;
import java.util.Date;

/**
 * Created by Jake.lin on 2019/12/27
 * @Title: 记录访问Service的所有请求，保存在mongodb中
 */
@Component
@Aspect
public class RecordServiceRequestAop {
    @Autowired
    private RecordService recordService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("pointCut()")
    public void Before() {
        logger.info("before service init");
    }

    @Pointcut("execution(* sch.xmut.jake.cache.apicache.service.*.*(..))")
    public void pointCut() {
        logger.info("pointCut service init");
    }

    @AfterReturning(value = "pointCut()")
    public void afterRunning(JoinPoint joinPoint) {
        logger.info("afterRunning service init");
        CacheRequest cacheRequest = (CacheRequest) joinPoint.getArgs()[0];// request
        RecordRequest recordRequest = buildRecordReuqest(cacheRequest);
        recordRequest.setMethod(joinPoint.getSignature().getName());
        recordService.insert(recordRequest);
        logger.info("complete service record");
    }

    private RecordRequest buildRecordReuqest(CacheRequest cacheRequest) {
        RecordRequest recordRequest = new RecordRequest();
        recordRequest.setContentType(null);
        recordRequest.setMethodType(null);
        recordRequest.setUrl(null);
        recordRequest.setParams(JSONObject.toJSONString(cacheRequest));
        recordRequest.setProjectMember(cacheRequest.getMember());
        recordRequest.setRecordType(CacheConstans.RECORD_TYPE_SERVICE);
        recordRequest.setCreateTime(SystemUtils.dateToFormat(new Date()));
        return recordRequest;
    }
}
