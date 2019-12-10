package sch.xmut.jake.cache.apicache.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.service.ZSortCacheService;
import sch.xmut.jake.cache.apicache.web.annotation.KeyRequired;

import javax.validation.Valid;

/**
 * Created by Jake.lin on 2019/12/10
 * @Tips: 有序集合  API
 */
@Controller
@RequestMapping(value = "/cache/zsort")
public class ZSortCacheController {
    @Autowired
    private ZSortCacheService zSortCacheService;

    /**
     * 添加一个有序集
     * @Params: member、key、zsort_map
     */
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse add(@RequestBody @Valid CacheRequest cacheRequest) {
        return zSortCacheService.add(cacheRequest);
    }

    /**
     * 插入一个元素
     * @Params: member、key、score、value
     */
    @RequestMapping(value = "/add-one", method = RequestMethod.PUT)
    @ResponseBody
    @KeyRequired
    public BaseResponse addOne(@RequestBody CacheRequest cacheRequest) {
        return zSortCacheService.addOne(cacheRequest);
    }
}
