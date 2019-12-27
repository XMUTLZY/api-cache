package sch.xmut.jake.cache.apicache.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.repository.ZSortCacheRepository;
import sch.xmut.jake.cache.apicache.service.serviceInterface.ZSortCacheServiceInterface;

/**
 * Created by Jake.lin on 2019/12/10
 */
@Service
public class ZSortCacheService implements ZSortCacheServiceInterface {
    @Autowired
    private ZSortCacheRepository zSortCacheRepository;

    @Override
    public BaseResponse add(CacheRequest cacheRequest) {
        BaseResponse baseResponse = new BaseResponse();
        if (CollectionUtils.isEmpty(cacheRequest.getZsortMap())) {
            baseResponse.setMessage("the zsort map can't no be null.");
        } else {
            baseResponse = zSortCacheRepository.add(cacheRequest);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse addOne(CacheRequest cacheRequest) {
       return zSortCacheRepository.addOne(cacheRequest);
    }
}
