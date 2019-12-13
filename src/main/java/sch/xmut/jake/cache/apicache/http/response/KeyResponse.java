package sch.xmut.jake.cache.apicache.http.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Set;

/**
 * Created by jake.lin on 2019/12/13
 */
public class KeyResponse extends BaseResponse{
    @JsonProperty("is_exist_map")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Map<String, Boolean> isExistMap;
    @JsonProperty("key_set")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<String> keySet;
    @JsonProperty("life_time")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double lifeTime;

    public Map<String, Boolean> getIsExistMap() {
        return isExistMap;
    }

    public void setIsExistMap(Map<String, Boolean> isExistMap) {
        this.isExistMap = isExistMap;
    }

    public Set<String> getKeySet() {
        return keySet;
    }

    public void setKeySet(Set<String> keySet) {
        this.keySet = keySet;
    }

    public Double getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(Double lifeTime) {
        this.lifeTime = lifeTime;
    }
}
