package sch.xmut.jake.cache.apicache.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;
import sch.xmut.jake.cache.apicache.service.ListCacheService;
import sch.xmut.jake.cache.apicache.web.annotation.KeyRequired;
import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by Jake.lin on 2019/12/05
 * @Tips: 数据类型List  API
 */
@Controller
@RequestMapping(value = "/cache/list")
public class ListCacheController {
    @Resource
    private ListCacheService listCacheService;

    /**
     * 添加一个List或向插入元素
     * @Params: member、key、value_list、operate_type(左或右)
     */
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse listAdd(@RequestBody @Valid CacheRequest cacheRequest) {
        return listCacheService.add(cacheRequest);
    }

    /**
     * 获取对应区间的元素
     * @Params: member、key、start(起始)、end(终止)
     */
    @RequestMapping(value = "/get-range", method = RequestMethod.POST)
    @ResponseBody
    @KeyRequired
    public CacheResponse listGetRange(@RequestBody CacheRequest cacheRequest) {
        return listCacheService.listGetRange(cacheRequest);
    }

    /**
     * 出栈元素
     * @Params: member、key、operate_type(左或右)
     */
    @RequestMapping(value = "/get-one", method = RequestMethod.POST)
    @ResponseBody
    @KeyRequired
    public CacheResponse listGetOne(@RequestBody CacheRequest cacheRequest) {
        return listCacheService.listGetOne(cacheRequest);
    }

    /**
     * 修改key对应list指定下标index的元素
     * @Params: member、key、index、instead_value(替代的元素)
     */
    @RequestMapping(value = "/update-by-index", method = RequestMethod.POST)
    @ResponseBody
    @KeyRequired
    public BaseResponse listUpdateByIndex(@RequestBody CacheRequest cacheRequest) {
        return listCacheService.listUpdateByIndex(cacheRequest);
    }

    /**
     * 获取key对应list指定下标index的元素
     * @Params: member、key、index
     */
    @RequestMapping(value = "/get-by-index", method = RequestMethod.POST)
    @ResponseBody
    @KeyRequired
    public CacheResponse listGetByIndex(@RequestBody CacheRequest cacheRequest) {
        return listCacheService.listGetByIndex(cacheRequest);
    }
}
