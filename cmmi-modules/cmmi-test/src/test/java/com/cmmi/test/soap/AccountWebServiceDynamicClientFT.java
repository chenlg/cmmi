/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.cmmi.test.soap;

import static org.assertj.core.api.Assertions.*;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.cmmi.common.service.facade.soap.AccountSoapService;
import com.cmmi.common.service.response.soap.GetUserResult;
import com.cmmi.test.selenium.BaseFunctionalTestCase;

/**
 * AccountService Web服务的功能测试, 测试主要的接口调用.
 * 
 * 以用JAXWS的API, 根据AccountWebService接口自行创建.
 * 
 * 集中在Team相关接口.
 * 
 * @author calvin
 */
public class AccountWebServiceDynamicClientFT extends BaseFunctionalTestCase {

	public AccountSoapService creatClient() {
		String address = baseUrl + "/cxf/soap/accountservice";

		JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setAddress(address);
		proxyFactory.setServiceClass(AccountSoapService.class);
		AccountSoapService accountWebServiceProxy = (AccountSoapService) proxyFactory.create();

		// (可选)演示重新设定endpoint address.
		((BindingProvider) accountWebServiceProxy).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				address);

		// (可选)演示重新设定Timeout时间
		Client client = ClientProxy.getClient(accountWebServiceProxy);
		HTTPConduit conduit = (HTTPConduit) client.getConduit();
		HTTPClientPolicy policy = conduit.getClient();
		policy.setReceiveTimeout(600000);

		return accountWebServiceProxy;
	}
	
	   /**
     * 测试搜索用户
     */
    @Test
    public void getUser() {
        AccountSoapService accountWebService = creatClient();
        GetUserResult result = accountWebService.getUser(1);
    }

}
