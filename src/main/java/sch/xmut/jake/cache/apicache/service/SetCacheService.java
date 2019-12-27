package sch.xmut.jake.cache.apicache.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;
import sch.xmut.jake.cache.apicache.repository.SetCacheRepository;
import sch.xmut.jake.cache.apicache.service.serviceInterface.SetCacheServiceInterface;

/**
 * Created by Jake.lin on 2019/12/09
 */
@Service
public class SetCacheService implements SetCacheServiceInterface {
    @Autowired
    private SetCacheRepository setCacheRepository;

    @Override
    public BaseResponse setAdd(CacheRequest cacheRequest) {
        BaseResponse baseResponse = new BaseResponse();
        if (CollectionUtils.isEmpty(cacheRequest.getValueList())) {
            baseResponse.setMessage("the value list can't no be null.");
        } else {
            return setCacheRepository.setAdd(cacheRequest);
        }
        return baseResponse;
    }

    @Override
    public CacheResponse setGet(CacheRequest cacheRequest) {
        return setCacheRepository.setGet(cacheRequest);
    }
}
