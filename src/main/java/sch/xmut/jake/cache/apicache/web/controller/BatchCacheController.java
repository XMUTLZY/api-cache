package sch.xmut.jake.cache.apicache.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.http.response.CacheResponse;
import sch.xmut.jake.cache.apicache.service.BatchCacheService;
import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by Jake.lin on 2019/12/11
 * @Tips: 批量操作  使用管道技术
 */
@RequestMapping(value = "/cache/batch")
@Controller
public class BatchCacheController {
    @Resource
    private BatchCacheService batchCacheService;

    /**
     * 批量添加数据
     * @Params: member、key_value_map
     */
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse add(@RequestBody @Valid CacheRequest cacheRequest) {
        return batchCacheService.add(cacheRequest);
    }

    /**
     * 批量读取数据
     * @Params: member、key_list
     */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public CacheResponse get(@RequestBody @Valid CacheRequest cacheRequest) {
        return batchCacheService.get(cacheRequest);
    }
}
