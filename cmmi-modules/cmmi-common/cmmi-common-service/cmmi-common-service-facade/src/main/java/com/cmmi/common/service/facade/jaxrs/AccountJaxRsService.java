/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.cmmi.common.service.facade.jaxrs;

import javax.ws.rs.PathParam;

import com.cmmi.common.service.response.jaxrs.dto.UserDTO;
import com.cmmi.common.shared.annotation.Description;

/**
 * Reason:	 该接口主要用户描述接口具体调用.对与其他无效果. 
 * 
 * @author chenlg
 * @version $Id: AccountJaxRsService.java, v 0.1 2014年2月25日 下午2:58:26 chenlg Exp $
 * @since    JDK 1.7
 * @see
 */
@Description
public interface AccountJaxRsService {
    
    /**
     * http://localhost:8080/cmmi-server/cxf/jaxrs/user/1.xml
     * 
     * @param id
     * @return
     */
    public UserDTO getAsXml(@PathParam("id") Integer id);

    /**
     * http://localhost:8080/cmmi-server/cxf/jaxrs/user/1.json
     * 
     * @param id
     * @return
     */
    public UserDTO getAsJson(@PathParam("id") Integer id) ;
}
