package sch.xmut.jake.cache.apicache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;
import sch.xmut.jake.cache.apicache.repository.SetCacheRepository;

/**
 * Created by Jake.lin on 2019/12/09
 */
@Service
public class SetCacheService {
    @Autowired
    private SetCacheRepository setCacheRepository;

    public BaseResponse setAdd(CacheRequest cacheRequest) {
        BaseResponse baseResponse = new BaseResponse();
        if (CollectionUtils.isEmpty(cacheRequest.getValueList())) {
            baseResponse.setMessage("the value list can't no be null.");
        } else {
            return setCacheRepository.setAdd(cacheRequest);
        }
        return baseResponse;
    }

    public CacheResponse setGet(CacheRequest cacheRequest) {
        return setCacheRepository.setGet(cacheRequest);
    }
}
