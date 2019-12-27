package sch.xmut.jake.cache.apicache.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;
import sch.xmut.jake.cache.apicache.repository.HashCacheRepository;
import sch.xmut.jake.cache.apicache.service.serviceInterface.HashCacheServiceInterface;

/**
 * Created by Jake.lin on 2019/12/10
 */
@Service
public class HashCacheService implements HashCacheServiceInterface {
    @Autowired
    private HashCacheRepository hashCacheRepository;

    @Override
    public BaseResponse hashAdd(CacheRequest cacheRequest) {
        BaseResponse baseResponse = new BaseResponse();
        if (CollectionUtils.isEmpty(cacheRequest.getValueMap())) {
            baseResponse.setMessage("the value map cant't no be null.");
        } else {
            baseResponse = hashCacheRepository.hashAdd(cacheRequest);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse hashAddOne(CacheRequest cacheRequest) {
        return hashCacheRepository.hashAddOne(cacheRequest);
    }

    @Override
    public CacheResponse get(CacheRequest cacheRequest) {
        return hashCacheRepository.get(cacheRequest);
    }
}
