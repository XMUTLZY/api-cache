package sch.xmut.jake.cache.apicache.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.service.CacheService;
import javax.validation.Valid;

/**
 * Created by Jake.lin on 2019/12/03
 */
@Controller
@RequestMapping(value = "/cache")
public class CacheController {
    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse add(@RequestBody @Valid CacheRequest cacheRequest) {
        return cacheService.add(cacheRequest);
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse get(@RequestBody @Valid CacheRequest cacheRequest) {
        return cacheService.get(cacheRequest);
    }
}
