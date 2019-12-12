package sch.xmut.jake.cache.apicache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;
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
        Set<Map.Entry<String, String>> entrySet = cacheRequest.getKeyValueMap().entrySet();
        Map<String, String> newKeyValueMap = new HashMap<>();
        String member = cacheRequest.getMember();
        for (Map.Entry<String, String> entry : entrySet) {
            newKeyValueMap.put(SystemUtils.buildKey(member, entry.getKey()), entry.getValue());
        }
        return batchCacheRepository.add(newKeyValueMap);
    }

    public CacheResponse get(CacheRequest cacheRequest) {
        CacheResponse cacheResponse = new CacheResponse();
        if (CollectionUtils.isEmpty(cacheRequest.getKeyList())) {
            cacheResponse.setMessage("the key list can't no be null.");
            return cacheResponse;
        }
        return batchCacheRepository.get(cacheRequest);
    }
}
