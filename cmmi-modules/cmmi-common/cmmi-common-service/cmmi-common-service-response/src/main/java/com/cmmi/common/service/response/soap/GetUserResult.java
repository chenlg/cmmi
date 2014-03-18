/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.cmmi.common.service.response.soap;

import javax.xml.bind.annotation.XmlType;

import com.cmmi.common.service.response.WsConstants;
import com.cmmi.common.service.response.soap.base.WSResult;
import com.cmmi.common.service.response.soap.dto.UserDTO;

/**
 * Reason:   单用户返回类. 
 * 
 * @author chenlg
 * @version $Id: SearchUserResult.java, v 0.1 2014年3月18日 上午11:17:43 chenlg Exp $
 * @since    JDK 1.7
 */
@XmlType(name = "GetUserResult", namespace = WsConstants.NS)
public class GetUserResult extends WSResult {
	private UserDTO user;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
