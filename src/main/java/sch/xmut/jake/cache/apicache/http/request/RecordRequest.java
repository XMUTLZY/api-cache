package sch.xmut.jake.cache.apicache.http.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Jake.lin on 2019/12/24
 */
public class RecordRequest {
    @JsonProperty("project_member")
    private String projectMember;
    private String params;
    private String url;
    @JsonProperty("content_type")
    private String contentType;
    @JsonProperty("method_type")
    private String methodType;
    @JsonProperty("create_time")
    private String createTime;

    public String getProjectMember() {
        return projectMember;
    }

    public void setProjectMember(String projectMember) {
        this.projectMember = projectMember;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
