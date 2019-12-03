package sch.xmut.jake.cache.apicache.http.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;
import java.util.Map;

/**
 * Created by Jake.lin on 2019/12/03
 */
public class CacheResponse extends BaseResponse{
    @JsonProperty("key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String key;
    @JsonProperty("value")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String value;
    @JsonProperty("value_list")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> valueList;
    @JsonProperty("map_entry")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> mapEntry;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getValueList() {
        return valueList;
    }

    public void setValueList(List<String> valueList) {
        this.valueList = valueList;
    }

    public Map<String, String> getMapEntry() {
        return mapEntry;
    }

    public void setMapEntry(Map<String, String> mapEntry) {
        this.mapEntry = mapEntry;
    }
}
