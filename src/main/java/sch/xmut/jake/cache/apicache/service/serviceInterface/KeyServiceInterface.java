package sch.xmut.jake.cache.apicache.service.serviceInterface;

import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.KeyResponse;
import java.util.Map;

/**
 * Created by jake.lin on 2019/12/27
 */
public interface KeyServiceInterface {
    Map<String, Boolean> isExistsByKeyList(CacheRequest cacheRequest);
    KeyResponse setTime(CacheRequest cacheRequest);
    KeyResponse getTime(CacheRequest cacheRequest);
}
