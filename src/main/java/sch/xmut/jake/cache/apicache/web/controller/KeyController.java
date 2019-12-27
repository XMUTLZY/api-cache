package sch.xmut.jake.cache.apicache.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sch.xmut.jake.cache.apicache.http.request.CacheRequest;
import sch.xmut.jake.cache.apicache.http.response.KeyResponse;
import sch.xmut.jake.cache.apicache.service.KeyService;
import sch.xmut.jake.cache.apicache.web.annotation.KeyRequired;
import sch.xmut.jake.cache.apicache.web.utils.SystemUtils;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;

/**
 * Created by Jake.lin on 2019/12/13
 * @Tips: 对key操作
 */
@Controller
@RequestMapping(value = "/key")
public class KeyController {
    @Resource
    private KeyService keyService;

    /**
     * 判断键值是否存在
     * @Params: member、key
     */
    @RequestMapping(value = "/is-exist", method = RequestMethod.POST)
    @ResponseBody
    public KeyResponse isExist(@RequestBody @Valid CacheRequest cacheRequest) {
        KeyResponse keyResponse = new KeyResponse();
        cacheRequest.setMemberKeyList(Arrays.asList(SystemUtils.buildKey(cacheRequest.getMember(), cacheRequest.getKey())));
        keyResponse.setIsExistMap(keyService.isExistsByKeyList(cacheRequest));
        return keyResponse;
    }

    /**
     * 设置键的生存时间(s)
     * @Params: member、key、life_time
     */
    @RequestMapping(value = "/set-time", method = RequestMethod.POST)
    @ResponseBody
    @KeyRequired
    public KeyResponse setTime(@RequestBody CacheRequest cacheRequest) {
        return keyService.setTime(cacheRequest);
    }

    /**
     * 获取键剩余的生存时间(s)
     * @Params: member、key
     */
    @RequestMapping(value = "/get-time", method = RequestMethod.POST)
    @ResponseBody
    @KeyRequired
    public KeyResponse getTime(@RequestBody CacheRequest cacheRequest) {
        return keyService.getTime(cacheRequest);
    }

}
