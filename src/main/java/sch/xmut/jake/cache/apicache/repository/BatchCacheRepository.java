package sch.xmut.jake.cache.apicache.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.util.JedisClusterCRC16;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;
import sch.xmut.jake.cache.apicache.web.config.JedisSlotAdvancedConnectionHandler;
import sch.xmut.jake.cache.apicache.web.utils.SystemUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jake.lin on 2019/12/11
 */
@Repository
public class BatchCacheRepository {
    @Autowired
    private JedisSlotAdvancedConnectionHandler jedisSlotAdvancedConnectionHandler;
    @Autowired
    private JedisCluster jedisCluster;

    public BaseResponse add(Map<String, String> newKeyValueMap) {
        BaseResponse baseResponse = new BaseResponse();
        Map<JedisPool, List<String>> jedisPoolStringMap = buildJedisPoolKeyListMap();
        for (String key : newKeyValueMap.keySet()) {
            int slot = JedisClusterCRC16.getSlot(key); //获取key对应的槽位
            JedisPool jedisPool = jedisSlotAdvancedConnectionHandler.getJedisPoolFromSlot(slot); //根据槽位获取jedisPool
            jedisPoolStringMap.get(jedisPool).add(key);
        }
        Set<Map.Entry<JedisPool, List<String>>> entrySet = jedisPoolStringMap.entrySet();
        try {
            long begin = System.currentTimeMillis();
            for (Map.Entry<JedisPool, List<String>> entry : entrySet) {
                Jedis jedis = entry.getKey().getResource();
                Pipeline pipeline = jedis.pipelined();
                entry.getValue().forEach(item->{
                    pipeline.set(item, newKeyValueMap.get(item));
                });
                pipeline.sync();
                jedis.close();
            }
            long end = System.currentTimeMillis();

            // 测试不适用管道的时间
            long begin1 = System.currentTimeMillis();
            Set<Map.Entry<String, String>> entrySet1 = newKeyValueMap.entrySet();
            for (Map.Entry<String, String> entry : entrySet1) {
                jedisCluster.set(entry.getKey(), entry.getValue());
            }
            long end1 = System.currentTimeMillis();

            baseResponse.setMessage("use pipeline batch set total time：" + (end - begin) + ", no use pipeline batch set total time：" + (end1 - begin1));
        } catch (Exception e) {
            SystemUtils.buildErrorResponse(baseResponse);
        }
        return baseResponse;
    }

    public CacheResponse get(CacheRequest cacheRequest) {
        CacheResponse cacheResponse = new CacheResponse();
        List<Object> resultList = new ArrayList<>();
        Map<JedisPool, List<String>> jedisPoolStringMap = buildJedisPoolKeyListMap();
        List<String> newKeyList = new ArrayList<>();
        cacheRequest.getKeyList().forEach(string->{
            newKeyList.add(SystemUtils.buildKey(cacheRequest.getMember(), string));
        });
        newKeyList.forEach(key->{
            JedisPool jedisPool = jedisSlotAdvancedConnectionHandler.getJedisPoolFromSlot(JedisClusterCRC16.getSlot(key));
            jedisPoolStringMap.get(jedisPool).add(key);
        });
        Set<Map.Entry<JedisPool, List<String>>> entrySet = jedisPoolStringMap.entrySet();
        try {
            entrySet.forEach(entry->{
                Jedis jedis = entry.getKey().getResource();
                Pipeline pipeline = jedis.pipelined();
                entry.getValue().forEach(key->{
                    pipeline.get(key);
                });
                resultList.addAll(pipeline.syncAndReturnAll());
                jedis.close();
            });
        } catch (Exception e) {
            SystemUtils.buildErrorResponse(cacheResponse);
        }
        cacheResponse.setResultList(resultList);
        return cacheResponse;
    }

    private Map<JedisPool, List<String>> buildJedisPoolKeyListMap() {
        List<String> valueList1 = new ArrayList<>();
        List<String> valueList2 = new ArrayList<>();
        List<String> valueList3 = new ArrayList<>();
        Map<JedisPool, List<String>> jedisPoolStringMap = new HashMap<>();
        jedisPoolStringMap.put(jedisSlotAdvancedConnectionHandler.getJedisPoolFromSlot(2000), valueList1); //获取node1的jedispool
        jedisPoolStringMap.put(jedisSlotAdvancedConnectionHandler.getJedisPoolFromSlot(7000), valueList2); //获取node2的jedispool
        jedisPoolStringMap.put(jedisSlotAdvancedConnectionHandler.getJedisPoolFromSlot(12000), valueList3); //获取node3的jedispool
        return jedisPoolStringMap;
    }
}
