package com.cmmi.common.service.response.jaxrs.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.cmmi.common.service.response.WsConstants;

/**
 * Web Service传输User信息的DTO.
 * 
 * 只传输外部接口需要的属性.使用JAXB 2.0的annotation标注JAVA-XML映射,尽量使用默认约定.
 * 
 * @author calvin
 */
@XmlRootElement
@XmlType(name = "User", namespace = WsConstants.NS)
public class UserDTO {

    private Integer userId;
    private String  userName;
    private String  userAccount;
    private String  userPwd;
    private String  salt;
    private String  userEmail;
    private boolean status;
    private String  permissions;

    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    /**
     * 重新实现toString()函数方便在日志中打印DTO信息.
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
