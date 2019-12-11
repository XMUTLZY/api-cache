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
    @JsonProperty("value_map")
    private Map<String, String> valueMap;
    @JsonProperty("operate_type")
    private String operateType = CacheConstans.OPERATE_TYPE_LEFT; // list 左或右操作
    @JsonProperty("start")
    private Integer start; // list 起始索引位置
    @JsonProperty("end")
    private Integer end; // list 最终索引位置
    @JsonProperty("index")
    private Integer index; // list 索引位置
    @JsonProperty("instead_value")
    private String insteadValue; // list 替换的值
    @JsonProperty("new_key")
    private String newKey; // map
    @JsonProperty("new_value")
    private String newValue; // map
    @JsonProperty("zsort_map")
    private Map<String, Double> zsortMap; // 有序集合map
    @JsonProperty("score")
    private Double score;  //有序集合score
    @JsonProperty("member_key_map")
    private Map<String, String> memberKeyMap; // pipelined (member,key) 形式作为新的key值
    @JsonProperty("member_key_value_map")
    private Map<Map<String, String>, String> memberKeyValueMap; // pipelined (member+key, value) 形式作为传入的key,value

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

    public Map<String, String> getMemberKeyMap() {
        return memberKeyMap;
    }

    public void setMemberKeyMap(Map<String, String> memberKeyMap) {
        this.memberKeyMap = memberKeyMap;
    }

    public Map<Map<String, String>, String> getMemberKeyValueMap() {
        return memberKeyValueMap;
    }

    public void setMemberKeyValueMap(Map<Map<String, String>, String> memberKeyValueMap) {
        this.memberKeyValueMap = memberKeyValueMap;
    }
}