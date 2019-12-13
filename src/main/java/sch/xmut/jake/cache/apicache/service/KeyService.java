package sch.xmut.jake.cache.apicache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.KeyResponse;
import sch.xmut.jake.cache.apicache.repository.KeyRepository;
import java.util.List;
import java.util.Map;

/**
 * Created by Jake.lin on 2019/12/05
 */
@Service
public class KeyService {
    @Autowired
    private KeyRepository keyRepository;

    public Map<String, Boolean> isExistsByKeyList(List<String> keyList) {
        return keyRepository.isExistsByKeyList(keyList);
    }

    public KeyResponse setTime(CacheRequest cacheRequest) {
        KeyResponse keyResponse = new KeyResponse();
        if (cacheRequest.getLifeTime() == null) {
            keyResponse.setMessage("the life time can't no be null.");
            return keyResponse;
        }
        return keyRepository.setTime(cacheRequest);
    }

    public KeyResponse getTime(CacheRequest cacheRequest) {
        return keyRepository.getTime(cacheRequest);
    }
}
