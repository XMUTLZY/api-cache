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
    private String member;
    @Pattern(regexp = CommonConstants.KEY_PATTERN, message = "只允许大写字母和_")
    private String key;
    private String value;
    @JsonProperty("key_list")
    private List<String> keyList;
    @JsonProperty("value_list")
    private List<String> valueList;
    @JsonProperty("value_map")
    private Map<String, String> valueMap;
    @JsonProperty("operate_type")
    private String operateType = CacheConstans.OPERATE_TYPE_LEFT; // list 左或右操作
    private Integer start; // list 起始索引位置
    private Integer end; // list 最终索引位置
    private Integer index; // list 索引位置
    @JsonProperty("instead_value")
    private String insteadValue; // list 替换的值
    @JsonProperty("new_key")
    private String newKey; // map
    @JsonProperty("new_value")
    private String newValue; // map
    @JsonProperty("zsort_map")
    private Map<String, Double> zsortMap; // 有序集合map
    private Double score;  //有序集合score
    @JsonProperty("key_value_map")
    private Map<String, String> keyValueMap; // pipelined (key, value) 形式作为传入的key,value
    @JsonProperty("life_time")
    private Double lifeTime;

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

    public Map<String, String> getValueMap() {
        return valueMap;
    }

    public void setValueMap(Map<String, String> valueMap) {
        this.valueMap = valueMap;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getInsteadValue() {
        return insteadValue;
    }

    public void setInsteadValue(String insteadValue) {
        this.insteadValue = insteadValue;
    }

    public String getNewKey() {
        return newKey;
    }

    public void setNewKey(String newKey) {
        this.newKey = newKey;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public Map<String, Double> getZsortMap() {
        return zsortMap;
    }

    public void setZsortMap(Map<String, Double> zsortMap) {
        this.zsortMap = zsortMap;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Map<String, String> getKeyValueMap() {
        return keyValueMap;
    }

    public void setKeyValueMap(Map<String, String> keyValueMap) {
        this.keyValueMap = keyValueMap;
    }

    public List<String> getKeyList() {
        return keyList;
    }

    public void setKeyList(List<String> keyList) {
        this.keyList = keyList;
    }

    public Double getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(Double lifeTime) {
        this.lifeTime = lifeTime;
    }
}