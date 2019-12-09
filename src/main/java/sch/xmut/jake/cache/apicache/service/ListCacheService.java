package sch.xmut.jake.cache.apicache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;
import sch.xmut.jake.cache.apicache.repository.ListCacheRepository;

/**
 * Created by Jake.lin on 2019/12/05
 */
@Service
public class ListCacheService {
    @Autowired
    private ListCacheRepository listCacheRepository;

    public BaseResponse add(CacheRequest cacheRequest) {
        BaseResponse baseResponse = new BaseResponse();
        if (CollectionUtils.isEmpty(cacheRequest.getValueList())) {
            baseResponse.setMessage("the value list can't no be null.");
        } else {
            return listCacheRepository.add(cacheRequest);
        }
        return baseResponse;
    }

    public CacheResponse listGetRange(CacheRequest cacheRequest) {
        CacheResponse cacheResponse = new CacheResponse();
         if (cacheRequest.getStart() == null || cacheRequest.getEnd() == null) {
            cacheResponse.setMessage("no find start and end.");
        } else {
            return listCacheRepository.listGetRange(cacheRequest);
        }
        return cacheResponse;
    }

    public CacheResponse listGetOne(CacheRequest cacheRequest) {
        return listCacheRepository.listGetOne(cacheRequest);
    }

    public BaseResponse listUpdateByIndex(CacheRequest cacheRequest) {
        BaseResponse baseResponse = new BaseResponse();
        if (cacheRequest.getIndex() == null) {
            baseResponse.setMessage("the index can't no be null");
        } else if (!StringUtils.hasText(cacheRequest.getInsteadValue())) {
            baseResponse.setMessage("the instead value can't no be null");
        } else {
            return listCacheRepository.listUpdateByIndex(cacheRequest);
        }
        return baseResponse;
    }

    public CacheResponse listGetByIndex(CacheRequest cacheRequest) {
        CacheResponse cacheResponse = new CacheResponse();
        if (cacheRequest.getIndex() == null) {
            cacheResponse.setMessage("the index can't no be null");
        } else {
            return listCacheRepository.listGetByIndex(cacheRequest);
        }
        return cacheResponse;
    }
}
