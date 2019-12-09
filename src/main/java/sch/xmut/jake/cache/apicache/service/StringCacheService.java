package sch.xmut.jake.cache.apicache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;
import sch.xmut.jake.cache.apicache.repository.StringCacheRepository;

/**
 * Created by Jake.lin on 2019/12/04
 */
@Service
public class StringCacheService {
    @Autowired
    private StringCacheRepository stringCacheRepository;

    public BaseResponse add(CacheRequest cacheRequest) {
        BaseResponse baseResponse = new BaseResponse();
        if (!StringUtils.hasText(cacheRequest.getValue())) {
            baseResponse.setMessage("the value can't no be null.");
        } else {
            baseResponse = stringCacheRepository.add(cacheRequest);
        }
        return baseResponse;
    }

    public CacheResponse get(CacheRequest cacheRequest) {
        CacheResponse cacheResponse = stringCacheRepository.get(cacheRequest);
        if (!StringUtils.hasText(cacheResponse.getValue())) {
            cacheResponse.setMessage("no find value.");
        }
        return cacheResponse;
    }

    public BaseResponse delete(CacheRequest cacheRequest) {
        return stringCacheRepository.delete(cacheRequest);
    }

}
