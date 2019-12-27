package sch.xmut.jake.cache.apicache.http.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jake.lin on 2019/12/03
 */
public class CacheResponse extends BaseResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String key;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String value;
    @JsonProperty("value_list")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> valueList;
    @JsonProperty("map_entry")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> mapEntry;
    @JsonProperty("value_set")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<String> valueSet;
    @JsonProperty("key_set")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<String> keySet;
    @JsonProperty("result_list")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Object> resultList;


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

    public Set<String> getValueSet() {
        return valueSet;
    }

    public void setValueSet(Set<String> valueSet) {
        this.valueSet = valueSet;
    }

    public Set<String> getKeySet() {
        return keySet;
    }

    public void setKeySet(Set<String> keySet) {
        this.keySet = keySet;
    }

    public List<Object> getResultList() {
        return resultList;
    }

    public void setResultList(List<Object> resultList) {
        this.resultList = resultList;
    }
}
