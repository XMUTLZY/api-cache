package sch.xmut.jake.cache.apicache.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.JedisCluster;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.KeyResponse;
import sch.xmut.jake.cache.apicache.web.utils.SystemUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jake.lin on 2019/12/13
 */
@Repository
public class KeyRepository {
    @Autowired
    private JedisCluster jedisCluster;

    /**
     * Determine whether the key value exists
     */
    public Map<String, Boolean> isExistsByKeyList(List<String> keyList) {
        if (CollectionUtils.isEmpty(keyList)) {
            return null;
        }
        Map<String, Boolean> map = new HashMap<>();
        keyList.forEach(string -> {
            map.put(string, true);
        });
        map.entrySet().forEach(stringBooleanEntry -> {
            if (!jedisCluster.exists(stringBooleanEntry.getKey())) {
                map.put(stringBooleanEntry.getKey(), false);
            }
        });
        return map;
    }

    public KeyResponse setTime(CacheRequest cacheRequest) {
        KeyResponse keyResponse = new KeyResponse();
        try {
            jedisCluster.expire(SystemUtils.buildKey(cacheRequest.getMember(), cacheRequest.getKey()), cacheRequest.getLifeTime().intValue());
        } catch (Exception e) {
            SystemUtils.buildErrorResponse(keyResponse);
        }
        return keyResponse;
    }

    public KeyResponse getTime(CacheRequest cacheRequest) {
        KeyResponse keyResponse = new KeyResponse();
        try {
            double lifeTime = jedisCluster.ttl(SystemUtils.buildKey(cacheRequest.getMember(), cacheRequest.getKey())).doubleValue();
            keyResponse.setLifeTime(lifeTime);
        } catch (Exception e) {
            SystemUtils.buildErrorResponse(keyResponse);
        }
        return keyResponse;
    }
}
