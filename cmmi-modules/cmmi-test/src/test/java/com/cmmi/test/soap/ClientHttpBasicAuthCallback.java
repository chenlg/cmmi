/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.cmmi.test.soap;
import java.io.IOException;  

import javax.security.auth.callback.Callback;  
import javax.security.auth.callback.CallbackHandler;  
import javax.security.auth.callback.UnsupportedCallbackException;  
  
import org.apache.ws.security.WSPasswordCallback;  
/**
 * Reason:	 TODO ADD REASON. 
 * 
 * @author chenlg
 * @version $Id: ClientHttpBasicAuthCallback.java, v 0.1 2014年2月28日 上午10:42:03 chenlg Exp $
 * @since    JDK 1.7
 * @see
 */
public class ClientHttpBasicAuthCallback implements CallbackHandler {  
  
    @Override  
    public void handle(Callback[] callbacks) throws IOException,  
            UnsupportedCallbackException {  
        if (callbacks != null && callbacks.length > 0) {  
            Callback callback = callbacks[0];  
              
            // 设置用户密码,供服务端验证,可以从配置文件或者数据库里面读取  
            WSPasswordCallback wsc = (WSPasswordCallback) callback;  
            wsc.setPassword("123");  
        }  
    }  

}
