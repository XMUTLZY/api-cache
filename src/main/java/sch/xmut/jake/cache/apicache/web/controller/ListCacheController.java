package sch.xmut.jake.cache.apicache.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.BaseResponse;
import sch.xmut.jake.cache.apicache.service.ListCacheService;
import javax.validation.Valid;

/**
 * Created by Jake.lin on 2019/12/05
 * @Tips: 数据类型List  API
 */
@Controller
@RequestMapping(value = "/cache/list")
public class ListCacheController {
    @Autowired
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
     *
     */
}
