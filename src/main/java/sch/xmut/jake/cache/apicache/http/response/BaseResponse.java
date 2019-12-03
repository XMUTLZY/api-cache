package sch.xmut.jake.cache.apicache.http.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Jake.lin on 2019/12/03
 */
public class BaseResponse {
    public static final Integer SUCCESS_CODE = 200;
    public static final Integer FAILD_CODE = 404;
    public static final String SUCCESS_STATUS = "success";
    public static final String FAILD_STATUS = "error";
    @JsonProperty("status_code")
    private Integer statusCode = SUCCESS_CODE;
    @JsonProperty("status")
    private String status = SUCCESS_STATUS;
    @JsonProperty("message")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    public BaseResponse(Integer statusCode, String status) {
        this.statusCode = statusCode;
        this.status = status;
    }

    public BaseResponse() {

    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
