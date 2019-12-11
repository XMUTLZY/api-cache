package sch.xmut.jake.cache.apicache.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.util.JedisClusterCRC16;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.web.config.JedisSlotAdvancedConnectionHandler;
import java.util.Map;

/**
 * Created by Jake.lin on 2019/12/11
 */
@Repository
public class BatchCacheRepository {
    @Autowired
    private JedisSlotAdvancedConnectionHandler jedisSlotAdvancedConnectionHandler;

    public BaseResponse add(Map<String, String> newKeyValueMap) {
        for (String key : newKeyValueMap.keySet()) {
            int slot = JedisClusterCRC16.getSlot(key); //获取key对应的槽位
            JedisPool jedisPool = jedisSlotAdvancedConnectionHandler.getJedisPoolFromSlot(slot); //根据槽位获取jedisPool
        }
        return new BaseResponse();
    }
}
