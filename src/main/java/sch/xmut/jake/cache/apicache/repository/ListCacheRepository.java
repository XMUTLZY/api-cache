package sch.xmut.jake.cache.apicache.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisCluster;
import sch.xmut.jake.cache.apicache.constants.CacheConstans;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;
import sch.xmut.jake.cache.apicache.web.utils.SystemUtils;

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
            SystemUtils.buildErrorResponse(baseResponse);
        }
        return baseResponse;
    }

    public CacheResponse listGetRange(CacheRequest cacheRequest) {
        CacheResponse cacheResponse = new CacheResponse();
        try {
            cacheResponse.setValueList(jedisCluster.lrange(SystemUtils.buildKey(cacheRequest.getMember(), cacheRequest.getKey()), cacheRequest.getStart(), cacheRequest.getEnd()));
        } catch (Exception e) {
            SystemUtils.buildErrorResponse(cacheResponse);
        }
        return cacheResponse;
    }
}
