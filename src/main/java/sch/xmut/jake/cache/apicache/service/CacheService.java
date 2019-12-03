package sch.xmut.jake.cache.apicache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;
import sch.xmut.jake.cache.apicache.repository.CacheRepository;

/**
 * Created by Jake.lin on 2019/12/04
 */
@Service
public class CacheService {
    @Autowired
    private CacheRepository cacheRepository;

    public BaseResponse add(CacheRequest cacheRequest) {
        return cacheRepository.add(cacheRequest);
    }

    public CacheResponse get(CacheRequest cacheRequest) {
        return cacheRepository.get(cacheRequest);
    }
}
