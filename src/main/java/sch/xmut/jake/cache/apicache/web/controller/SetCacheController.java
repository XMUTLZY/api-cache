package sch.xmut.jake.cache.apicache.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;
import sch.xmut.jake.cache.apicache.service.SetCacheService;
import javax.validation.Valid;

/**
 * Created by Jake.lin on 2019/12/09
 * @Tips: 数据类型Set  API
 */
@Controller
@RequestMapping(value = "/cache/set")
public class SetCacheController {
    @Autowired
    private SetCacheService setCacheService;

    /**
     * 添加一个set
     * @Params: member、key、value_list
     */
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse setAdd(@RequestBody @Valid CacheRequest cacheRequest) {
        return setCacheService.setAdd(cacheRequest);
    }

    /**
     * 获取key对应的所有元素
     * @Params: member、key
     */
    @RequestMapping(value = "/get-by-key", method = RequestMethod.POST)
    @ResponseBody
    public CacheResponse setGetByKey(@RequestBody @Valid CacheRequest cacheRequest) {
        return setCacheService.setGetByKey(cacheRequest);
    }
}