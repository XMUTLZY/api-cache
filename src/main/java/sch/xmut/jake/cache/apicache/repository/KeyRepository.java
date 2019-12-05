package sch.xmut.jake.cache.apicache.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.JedisCluster;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        for (String string : keyList) {
            map.put(string, true);
        }
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            if (!jedisCluster.exists(entry.getKey())) {
                map.put(entry.getKey(), false);
            }
        }
        return map;
    }
}
