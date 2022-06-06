/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2021/5/21
 * Time: 10:49
 **/
package com.trident.security.utils.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    
    private Integer code;
    private String message;
    private Object content;
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public Object getContent() {
        return content;
    }
    
    public void setContent(Object content) {
        this.content = content;
    }
}
