package com.cmmi.common.service.response.soap;

import javax.xml.bind.annotation.XmlType;

import com.cmmi.common.service.response.WsConstants;
import com.cmmi.common.service.response.soap.base.WSResult;
import com.cmmi.common.service.response.soap.dto.UserDTO;

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
