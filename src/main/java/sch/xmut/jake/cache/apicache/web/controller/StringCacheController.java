package sch.xmut.jake.cache.apicache.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.service.StringCacheService;
import sch.xmut.jake.cache.apicache.web.annotation.KeyRequired;
import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by Jake.lin on 2019/12/03
 * @Tips: 数据类型String  API
 */
@Controller
@RequestMapping(value = "/cache/string")
public class StringCacheController {
    @Resource
    private StringCacheService stringCacheService;

    /**
     * 添加缓存数据
     * @Params: member、key、value
     */
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse stringAdd(@RequestBody @Valid CacheRequest cacheRequest) {
        return stringCacheService.add(cacheRequest);
    }

    /**
     * 获取缓存数据
     * @Params: member、key
     */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    @KeyRequired
    public BaseResponse stringGet(@RequestBody CacheRequest cacheRequest) {
        return stringCacheService.get(cacheRequest);
    }

    /**
     * 根据key值删除缓存数据
     * @Params: member、key
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @KeyRequired
    public BaseResponse stringDelete(@RequestBody CacheRequest cacheRequest) {
        return stringCacheService.delete(cacheRequest);
    }

}
