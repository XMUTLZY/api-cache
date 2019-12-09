package sch.xmut.jake.cache.apicache.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisCluster;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;
import sch.xmut.jake.cache.apicache.web.utils.SystemUtils;

@Repository
public class SetCacheRepository {
    @Autowired
    private JedisCluster jedisCluster;

    public BaseResponse setAdd(CacheRequest cacheRequest) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            String newKey = SystemUtils.buildKey(cacheRequest.getMember(), cacheRequest.getKey());
            for (String string : cacheRequest.getValueList()) {
                jedisCluster.sadd(newKey, string);
            }
        } catch (Exception e) {
            SystemUtils.buildErrorResponse(baseResponse);
        }
        return baseResponse;
    }

    public CacheResponse setGet(CacheRequest cacheRequest) {
        CacheResponse cacheResponse = new CacheResponse();
        try {
            cacheResponse.setValueSet(jedisCluster.smembers(SystemUtils.buildKey(cacheRequest.getMember(), cacheRequest.getKey())));
        } catch (Exception e) {
            SystemUtils.buildErrorResponse(cacheResponse);
        }
        return cacheResponse;
    }
}
