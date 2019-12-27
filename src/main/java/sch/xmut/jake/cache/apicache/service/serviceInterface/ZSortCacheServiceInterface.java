package sch.xmut.jake.cache.apicache.service.serviceInterface;

import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;

public interface ZSortCacheServiceInterface {
    BaseResponse add(CacheRequest cacheRequest);
    BaseResponse addOne(CacheRequest cacheRequest);
}
