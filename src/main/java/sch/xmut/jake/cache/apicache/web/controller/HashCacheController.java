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
import sch.xmut.jake.cache.apicache.service.HashCacheService;
import sch.xmut.jake.cache.apicache.web.annotation.KeyRequired;
import javax.validation.Valid;

/**
 * Created by Jake.lin on 2019/12/10
 * @Tips: 数据类型Hash  API
 */
@Controller
@RequestMapping(value = "/cache/hash")
public class HashCacheController {
    @Autowired
    private HashCacheService hashCacheService;

    /**
     * 添加一个hash
     * @Params: member、key、value_map
     */
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse hashAdd(@RequestBody @Valid CacheRequest cacheRequest) {
        return hashCacheService.hashAdd(cacheRequest);
    }

    /**
     * 往Hash插入一个元素(key, value)
     * @Params: member、key、new_key、new_value
     */
    @RequestMapping(value = "/add-one", method = RequestMethod.PUT)
    @ResponseBody
    @KeyRequired
    public BaseResponse hashAddOne(@RequestBody CacheRequest cacheRequest) {
        return hashCacheService.hashAddOne(cacheRequest);
    }

    /**
     * 获取Hash所有的元素
     * @Params: member、key
     */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    @KeyRequired
    public CacheResponse get(@RequestBody CacheRequest cacheRequest) {
        return hashCacheService.get(cacheRequest);
    }
}
