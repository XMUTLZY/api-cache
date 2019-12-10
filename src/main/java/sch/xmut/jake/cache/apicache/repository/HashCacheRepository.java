package sch.xmut.jake.cache.apicache.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisCluster;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;
import sch.xmut.jake.cache.apicache.web.utils.SystemUtils;

/**
 * Created by Jake.lin on 2019/12/10
 */
@Repository
public class HashCacheRepository {
    @Autowired
    private JedisCluster jedisCluster;

    public BaseResponse hashAdd(CacheRequest cacheRequest) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            jedisCluster.hmset(SystemUtils.buildKey(cacheRequest.getMember(), cacheRequest.getKey()), cacheRequest.getValueMap());
        } catch (Exception e) {
            SystemUtils.buildErrorResponse(baseResponse);
        }
        return baseResponse;
    }

    public BaseResponse hashAddOne(CacheRequest cacheRequest) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            jedisCluster.hset(SystemUtils.buildKey(cacheRequest.getMember(), cacheRequest.getKey()), cacheRequest.getNewKey(), cacheRequest.getNewValue());
        } catch (Exception e) {
            SystemUtils.buildErrorResponse(baseResponse);
        }
        return baseResponse;
    }

    public CacheResponse get(CacheRequest cacheRequest) {
        CacheResponse cacheResponse = new CacheResponse();
        try {
            String newKey = SystemUtils.buildKey(cacheRequest.getMember(), cacheRequest.getKey());
            cacheResponse.setMapEntry(jedisCluster.hgetAll(newKey));
            cacheResponse.setKeySet(jedisCluster.hkeys(newKey));
            cacheResponse.setValueList(jedisCluster.hvals(newKey));
        } catch (Exception e) {
            SystemUtils.buildErrorResponse(cacheResponse);
        }
        return cacheResponse;
    }
}
