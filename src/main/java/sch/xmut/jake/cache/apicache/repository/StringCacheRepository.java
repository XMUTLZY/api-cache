package sch.xmut.jake.cache.apicache.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisCluster;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;
import sch.xmut.jake.cache.apicache.web.utils.SystemUtils;

/**
 * Created by Jake.lin on 2019/12/03
 */
@Repository
public class StringCacheRepository {
    @Autowired
    private JedisCluster jedisCluster;

    public BaseResponse add(CacheRequest cacheRequest) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            jedisCluster.set(SystemUtils.buildKey(cacheRequest.getMember(), cacheRequest.getKey()), cacheRequest.getValue());
        } catch (Exception e) {
            SystemUtils.buildErrorResponse(baseResponse);
        }
        return new BaseResponse();
    }

    public CacheResponse get(CacheRequest cacheRequest) {
        CacheResponse cacheResponse = new CacheResponse();
        try {
            Object value = jedisCluster.get(SystemUtils.buildKey(cacheRequest.getMember(), cacheRequest.getKey()));
            cacheResponse.setValue(value.toString());
        } catch (Exception e) {
            SystemUtils.buildErrorResponse(cacheResponse);
        }
        return cacheResponse;
    }

    public BaseResponse delete(CacheRequest cacheRequest) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            jedisCluster.del(SystemUtils.buildKey(cacheRequest.getMember(), cacheRequest.getKey()));
        } catch (Exception e) {
            SystemUtils.buildErrorResponse(baseResponse);
        }
        return new BaseResponse();
    }

}
