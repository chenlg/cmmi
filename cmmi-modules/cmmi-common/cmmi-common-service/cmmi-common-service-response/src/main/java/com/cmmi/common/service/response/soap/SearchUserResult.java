/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.cmmi.common.service.response.soap;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import com.cmmi.common.service.response.WsConstants;
import com.cmmi.common.service.response.soap.base.WSResult;
import com.cmmi.common.service.response.soap.dto.UserDTO;

/**
 * Reason:	 多用户收索返回类. 
 * 
 * @author chenlg
 * @version $Id: SearchUserResult.java, v 0.1 2014年3月18日 上午11:17:43 chenlg Exp $
 * @since    JDK 1.7
 */
@XmlType(name = "SearchUserResult", namespace = WsConstants.NS)
public class SearchUserResult extends WSResult {

    private List<UserDTO> userList;

    public SearchUserResult() {
    }

    public SearchUserResult(List<UserDTO> userList) {
        this.userList = userList;
    }

    @XmlElementWrapper(name = "userList")
    @XmlElement(name = "user")
    public List<UserDTO> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDTO> userList) {
        this.userList = userList;
    }
}
