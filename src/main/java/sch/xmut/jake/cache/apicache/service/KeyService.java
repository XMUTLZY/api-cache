package sch.xmut.jake.cache.apicache.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.KeyResponse;
import sch.xmut.jake.cache.apicache.repository.KeyRepository;
import sch.xmut.jake.cache.apicache.service.serviceInterface.KeyServiceInterface;
import java.util.Map;

/**
 * Created by Jake.lin on 2019/12/05
 */
@Service
public class KeyService implements KeyServiceInterface {
    @Autowired
    private KeyRepository keyRepository;

    @Override
    public Map<String, Boolean> isExistsByKeyList(CacheRequest cacheRequest) {
        return keyRepository.isExistsByKeyList(cacheRequest.getMemberKeyList());
    }

    @Override
    public KeyResponse setTime(CacheRequest cacheRequest) {
        KeyResponse keyResponse = new KeyResponse();
        if (cacheRequest.getLifeTime() == null) {
            keyResponse.setMessage("the life time can't no be null.");
            return keyResponse;
        }
        return keyRepository.setTime(cacheRequest);
    }

    @Override
    public KeyResponse getTime(CacheRequest cacheRequest) {
        return keyRepository.getTime(cacheRequest);
    }
}
