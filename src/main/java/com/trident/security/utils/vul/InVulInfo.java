/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/5/29
 * Time: 14:09
 **/
package com.trident.security.utils.vul;


public class InVulInfo {
    
    private Long id;
    private Integer systemId;
    private String title;
    private String cve;
    private Integer vulType;
    private Integer risk;
    private Integer isNeedFix;
    private String url;
    private String content;
    private String affect;
    private String fix;
    private String mitigation;
    private Integer vulStatus;
    private Integer fixStatus;
    private String expectTime;
    private String fixedTime;
    private Long securityUser;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getSystemId() {
        return systemId;
    }
    
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getCve() {
        return cve;
    }
    
    public void setCve(String cve) {
        this.cve = cve;
    }
    
    public Integer getVulType() {
        return vulType;
    }
    
    public void setVulType(Integer vulType) {
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
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getAffect() {
        return affect;
    }
    
    public void setAffect(String affect) {
        this.affect = affect;
    }
    
    public String getFix() {
        return fix;
    }
    
    public void setFix(String fix) {
        this.fix = fix;
    }
    
    public String getMitigation() {
        return mitigation;
    }
    
    public void setMitigation(String mitigation) {
        this.mitigation = mitigation;
    }
    
    public Integer getVulStatus() {
        return vulStatus;
    }
    
    public void setVulStatus(Integer vulStatus) {
        this.vulStatus = vulStatus;
    }
    
    public Integer getFixStatus() {
        return fixStatus;
    }
    
    public void setFixStatus(Integer fixStatus) {
        this.fixStatus = fixStatus;
    }
    
    public String getExpectTime() {
        return expectTime;
    }
    
    public void setExpectTime(String expectTime) {
        this.expectTime = expectTime;
    }
    
    public String getFixedTime() {
        return fixedTime;
    }
    
    public void setFixedTime(String fixedTime) {
        this.fixedTime = fixedTime;
    }
    
    public Long getSecurityUser() {
        return securityUser;
    }
    
    public void setSecurityUser(Long securityUser) {
        this.securityUser = securityUser;
    }
}
