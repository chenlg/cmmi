/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.cmmi.test.soap;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.cmmi.common.service.facade.soap.AccountSoapService;
import com.cmmi.common.service.response.soap.GetUserResult;
import com.cmmi.common.service.response.soap.base.IdResult;
import com.cmmi.common.service.response.soap.dto.UserDTO;
import com.cmmi.test.unit.BaseUnitTestCase;
import com.cmmi.test.unit.category.Smoke;

/**
 * Reason:	  AccountService Web服务的功能测试, 测试主要的接口调用.
 * 
 * 使用在Spring applicaitonContext.xml中用<jaxws:client/>，根据AccountWebService接口创建的Client.
 * 
 * 集中在User相关接口.
 *  @author chenlg
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(locations = { "/soap-client.xml" })
public class PredefineClientFT extends BaseUnitTestCase {

    @Autowired
    private AccountSoapService accountWebServiceClient;

    /**
     * 测试获取用户.
     */
    @Test
    @Category(Smoke.class)
    public void getUser() {
        GetUserResult response = accountWebServiceClient.getUser(1);
        assertEquals("admin", response.getUser().getUserAccount());
    }

    /**
     * 测试创建用户.
     */
    @Test
    public void createUser() {
        UserDTO user = new UserDTO();
        user.setUserName("admin");
        user.setUserPwd("123456");
        user.setUserEmail("lingang.chen@gmail.com");
        user.setUserAccount("admin");
        user.setSalt("avcdegsgs");
        user.setStatus(false);

        IdResult response = accountWebServiceClient.createUser(user);
        Assert.assertNull("Id", response.getId());
    }
}
