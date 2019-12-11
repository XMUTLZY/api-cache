package sch.xmut.jake.cache.apicache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.repository.BatchCacheRepository;
import sch.xmut.jake.cache.apicache.web.utils.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jake.lin on 2019/12/11
 */
@Service
public class BatchCacheService {
    @Autowired
    private BatchCacheRepository batchCacheRepository;

    public BaseResponse add(CacheRequest cacheRequest) {
        Map<String, String> newKeyValueMap = new HashMap<>();
        Set<Map.Entry<Map<String, String>, String>> memberKeyValueMapSet = cacheRequest.getMemberKeyValueMap().entrySet();
        for (Map.Entry<Map<String, String>, String> mapStringEntry : memberKeyValueMapSet) {
            Map<String, String> memberKeyMap = mapStringEntry.getKey();
            Set<Map.Entry<String,String>> memberKeySet = memberKeyMap.entrySet();
            for (Map.Entry<String,String> entry : memberKeySet) {
                newKeyValueMap.put(SystemUtils.buildKey(entry.getKey(), entry.getValue()), mapStringEntry.getValue());
            }
        }
        return batchCacheRepository.add(newKeyValueMap);
    }
}
