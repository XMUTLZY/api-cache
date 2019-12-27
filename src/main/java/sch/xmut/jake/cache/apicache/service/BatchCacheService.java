package sch.xmut.jake.cache.apicache.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;
import sch.xmut.jake.cache.apicache.repository.BatchCacheRepository;
import sch.xmut.jake.cache.apicache.service.serviceInterface.BatchCacheServiceInterface;
import sch.xmut.jake.cache.apicache.web.utils.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jake.lin on 2019/12/11
 */
@Service
public class BatchCacheService implements BatchCacheServiceInterface {
    @Autowired
    private BatchCacheRepository batchCacheRepository;

    @Override
    public BaseResponse add(CacheRequest cacheRequest) {
        Set<Map.Entry<String, String>> entrySet = cacheRequest.getKeyValueMap().entrySet();
        Map<String, String> newKeyValueMap = new HashMap<>();
        String member = cacheRequest.getMember();
        entrySet.forEach(stringStringEntry -> {
            newKeyValueMap.put(SystemUtils.buildKey(member, stringStringEntry.getKey()), stringStringEntry.getValue());
        });
        return batchCacheRepository.add(newKeyValueMap);
    }

    @Override
    public CacheResponse get(CacheRequest cacheRequest) {
        CacheResponse cacheResponse = new CacheResponse();
        if (CollectionUtils.isEmpty(cacheRequest.getKeyList())) {
            cacheResponse.setMessage("the key list can't no be null.");
            return cacheResponse;
        }
        return batchCacheRepository.get(cacheRequest);
    }
}
