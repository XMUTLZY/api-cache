package sch.xmut.jake.cache.apicache.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisCluster;
import sch.xmut.jake.cache.apicache.constants.CacheConstans;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.web.utils.SystemUtils;
import java.util.Date;

/**
 * Created by Jake.lin 2019/12/05
 */
@Repository
public class ListCacheRepository {
    @Autowired
    private JedisCluster jedisCluster;

    public BaseResponse add(CacheRequest cacheRequest) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            String newKey = SystemUtils.buildKey(cacheRequest.getMember(), cacheRequest.getKey());
            for (String string : cacheRequest.getValueList()) {
                if (CacheConstans.OPERATE_TYPE_LEFT.equals(cacheRequest.getOperateType())) {
                    jedisCluster.lpush(newKey, string);
                } else {
                    jedisCluster.rpush(newKey, string);
                }
            }
        } catch (Exception e) {
            baseResponse.setStatus(BaseResponse.FAILD_STATUS);
            baseResponse.setStatusCode(BaseResponse.FAILD_CODE);
            baseResponse.setMessage("system error." + SystemUtils.dateToFormat(new Date()));
        }
        return baseResponse;
    }
}
