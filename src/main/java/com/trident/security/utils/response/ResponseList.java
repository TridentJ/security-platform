/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2021/5/21
 * Time: 10:56
 **/
package com.trident.security.utils.response;

public class ResponseList {
    
    private Integer code;
    private String message;
    private Integer start;
    private Integer end;
    private Integer num;
    private Integer pageNum;
    private Object content;
    
    
    public Integer getPageNum() {
        return pageNum;
    }
    
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
    
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
    
    public Integer getNum() {
        return num;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }
    
    public Object getContent() {
        return content;
    }
    
    public void setContent(Object content) {
        this.content = content;
    }
}
