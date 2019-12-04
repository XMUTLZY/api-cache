package sch.xmut.jake.cache.apicache.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisCluster;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;

/**
 * Created by Jake.lin on 2019/12/03
 */
@Repository
public class CacheRepository {
    @Autowired
    private JedisCluster jedisCluster;

    public BaseResponse add(CacheRequest cacheRequest) {
        jedisCluster.set(cacheRequest.getKey(), cacheRequest.getValue());
        return new BaseResponse();
    }

    public CacheResponse get(CacheRequest cacheRequest) {
        CacheResponse cacheResponse = new CacheResponse();
        if (!StringUtils.hasText(cacheRequest.getKey())) {
            cacheResponse.setStatusCode(BaseResponse.FAILD_CODE);
            cacheResponse.setStatus(BaseResponse.FAILD_STATUS);
            cacheResponse.setMessage("No Find Key");
        }
        Object value = jedisCluster.get(cacheRequest.getKey());
        cacheResponse.setValue(value.toString());
        return cacheResponse;
    }
}
