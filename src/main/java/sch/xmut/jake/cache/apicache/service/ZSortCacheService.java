package sch.xmut.jake.cache.apicache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.repository.ZSortCacheRepository;

/**
 * Created by Jake.lin on 2019/12/10
 */
@Service
public class ZSortCacheService {
    @Autowired
    private ZSortCacheRepository zSortCacheRepository;

    public BaseResponse add(CacheRequest cacheRequest) {
        BaseResponse baseResponse = new BaseResponse();
        if (CollectionUtils.isEmpty(cacheRequest.getZsortMap())) {
            baseResponse.setMessage("the zsort map can't no be null.");
        } else {
            baseResponse = zSortCacheRepository.add(cacheRequest);
        }
        return baseResponse;
    }

    public BaseResponse addOne(CacheRequest cacheRequest) {
       return zSortCacheRepository.addOne(cacheRequest);
    }
}
