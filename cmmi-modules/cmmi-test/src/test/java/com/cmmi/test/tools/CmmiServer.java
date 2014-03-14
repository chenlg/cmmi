/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.cmmi.test.tools;

import org.eclipse.jetty.server.Server;

import com.cmmi.test.tools.jetty.JettyFactory;
import com.cmmi.test.tools.spring.Profiles;

/**
 * 使用Jetty运行调试Web应用, 在Console快速重载应用.
 * 
 * @author chenlg
 */
public class CmmiServer {
    public static final int      PORT          = 8080;
    public static final String   CONTEXT       = "c:\\oneself/cmmi/cmmi";
    public static final String[] TLD_JAR_NAMES = new String[] { "sitemesh", "spring-webmvc"};

    public static void main(String[] args) throws Exception {
        // 设定Spring的profile
        Profiles.setProfileAsSystemProperty(Profiles.DEVELOPMENT);

        // 启动Jetty
        Server server = JettyFactory.createServerInSource(PORT, CONTEXT);
        JettyFactory.setTldJarNames(server, TLD_JAR_NAMES);

        try {
            System.out.println("[HINT] Don't forget to set -XX:MaxPermSize=128m");

            server.start();
            System.out.println("Server running at http://localhost:" + PORT + CONTEXT);
            System.out.println("[HINT] Hit Enter to reload the application quickly");

            // 等待用户输入回车重载应用.
            while (true) {
                char c = (char) System.in.read();
                if (c == '\n') {
                    JettyFactory.reloadContext(server);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
