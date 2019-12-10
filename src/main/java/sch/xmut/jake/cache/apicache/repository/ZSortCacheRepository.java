package sch.xmut.jake.cache.apicache.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisCluster;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.web.utils.SystemUtils;

/**
 * Created by Jake.lin on 2019/12/10
 */
@Repository
public class ZSortCacheRepository {
    @Autowired
    private JedisCluster jedisCluster;

    public BaseResponse add(CacheRequest cacheRequest) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            jedisCluster.zadd(SystemUtils.buildKey(cacheRequest.getMember(), cacheRequest.getKey()), cacheRequest.getZsortMap());
        } catch (Exception e) {
            SystemUtils.buildErrorResponse(baseResponse);
        }
        return baseResponse;
    }

    public BaseResponse addOne(CacheRequest cacheRequest) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            jedisCluster.zadd(SystemUtils.buildKey(cacheRequest.getMember(), cacheRequest.getKey()), cacheRequest.getScore(), cacheRequest.getValue());
        } catch (Exception e) {
            SystemUtils.buildErrorResponse(baseResponse);
        }
        return baseResponse;
    }
}
