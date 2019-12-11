package sch.xmut.jake.cache.apicache;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ApiCacheApplicationTests {
    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        Map<Map<String, String>, String> map = new HashMap<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("WEB:CACHE_TEST_PROJECT_MEMBER", "TEST_BATCH1");
        map.put(map1, "value1");
        Map<String, String> map2 = new HashMap<>();
        map2.put("WEB:CACHE_TEST_PROJECT_MEMBER", "TEST_BATCH2");
        map.put(map2, "value2");
        String json = JSONObject.toJSONString(map);
        System.out.println(json);
    }
}
