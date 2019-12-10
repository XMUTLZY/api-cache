package sch.xmut.jake.cache.apicache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;
import sch.xmut.jake.cache.apicache.repository.HashCacheRepository;

/**
 * Created by Jake.lin on 2019/12/10
 */
@Service
public class HashCacheService {
    @Autowired
    private HashCacheRepository hashCacheRepository;

    public BaseResponse hashAdd(CacheRequest cacheRequest) {
        BaseResponse baseResponse = new BaseResponse();
        if (CollectionUtils.isEmpty(cacheRequest.getValueMap())) {
            baseResponse.setMessage("the value map cant't no be null.");
        } else {
            baseResponse = hashCacheRepository.hashAdd(cacheRequest);
        }
        return baseResponse;
    }

    public BaseResponse hashAddOne(CacheRequest cacheRequest) {
        return hashCacheRepository.hashAddOne(cacheRequest);
    }

    public CacheResponse get(CacheRequest cacheRequest) {
        return hashCacheRepository.get(cacheRequest);
    }
}
