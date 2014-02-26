/*package com.cmmi.main.soap;

import static org.junit.Assert.assertEquals;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
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

*//**
 * AccountService Web服务的功能测�? 测试主要的接口调�?
 * 
 * 使用在Spring applicaitonContext.xml中用<jaxws:client/>，根据AccountWebService接口创建的Client.
 * 
 * 集中在User相关接口.
 * 
 * @author calvin
 *//*
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(locations = { "/applicationContext-soap-client.xml" })
public class AccountWebServiceWithPredefineClient {

    @Autowired
    private AccountSoapService accountWebServiceClient;

    *//**
     * 测试获取用户.
     *//*
    @Test
    public void getUser() {
        GetUserResult response = accountWebServiceClient.getUser(1);
        assertEquals("admin", response.getUser().getUserAccount());
    }

    *//**
     * 测试创建用户.
     *//*
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
    }

}
*/