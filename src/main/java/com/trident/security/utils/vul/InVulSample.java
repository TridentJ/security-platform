/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/5/21
 * Time: 14:36
 **/
package com.trident.security.utils.vul;

public class InVulSample {
    
    private Long id;
    private String name;
    private String title;
    private String serialNum;
    private String vulType;
    private Integer risk;
    private Integer isNeedFix;
    private Integer fixStatus;
    private String createTime;
    private String expectTime;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getSerialNum() {
        return serialNum;
    }
    
    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }
    
    public String getVulType() {
        return vulType;
    }
    
    public void setVulType(String vulType) {
        this.vulType = vulType;
    }
    
    public Integer getRisk() {
        return risk;
    }
    
    public void setRisk(Integer risk) {
        this.risk = risk;
    }
    
    public Integer getIsNeedFix() {
        return isNeedFix;
    }
    
    public void setIsNeedFix(Integer isNeedFix) {
        this.isNeedFix = isNeedFix;
    }
    
    public Integer getFixStatus() {
        return fixStatus;
    }
    
    public void setFixStatus(Integer fixStatus) {
        this.fixStatus = fixStatus;
    }
    
    public String getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
    public String getExpectTime() {
        return expectTime;
    }
    
    public void setExpectTime(String expectTime) {
        this.expectTime = expectTime;
    }
}
