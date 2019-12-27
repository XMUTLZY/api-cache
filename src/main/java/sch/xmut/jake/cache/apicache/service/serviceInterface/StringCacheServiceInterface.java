package sch.xmut.jake.cache.apicache.service.serviceInterface;

import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;

/**
 * Created by jake.lin on 2019/12/27
 */
public interface StringCacheServiceInterface {
    BaseResponse add(CacheRequest cacheRequest);
    CacheResponse get(CacheRequest cacheRequest);
    BaseResponse delete(CacheRequest cacheRequest);
}
