package sch.xmut.jake.cache.apicache.repository;

import org.springframework.stereotype.Repository;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;

/**
 * Created by Jake.lin on 2019/12/03
 */
@Repository
public class CacheRepository {
    public BaseResponse add(CacheRequest cacheRequest) {
        return new BaseResponse();
    }

    public CacheResponse get(CacheRequest cacheRequest) {
        return new CacheResponse();
    }
}
