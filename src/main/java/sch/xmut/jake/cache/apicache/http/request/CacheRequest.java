package sch.xmut.jake.cache.apicache.http.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import sch.xmut.jake.cache.apicache.constants.CacheConstans;
import sch.xmut.jake.cache.apicache.constants.CommonConstants;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Map;

/**
 * Created by Jake.lin on 2019/12/03
 */
public class CacheRequest {
    @NotNull
    @JsonProperty("member")
    private String member;
    @Pattern(regexp = CommonConstants.KEY_PATTERN, message = "只允许大写字母和_")
    @JsonProperty("key")
    private String key;
    @JsonProperty("value")
    private String value;
    @JsonProperty("value_list")
    private List<String> valueList;
    @JsonProperty("map_entry")
    private Map<String, String> mapEntry;
    @JsonProperty("operate_type")
    private String operateType = CacheConstans.OPERATE_TYPE_LEFT;

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

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

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }
}