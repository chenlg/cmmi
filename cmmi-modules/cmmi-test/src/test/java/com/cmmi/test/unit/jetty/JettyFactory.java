/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.cmmi.test.unit.jetty;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppClassLoader;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Reason:	 创建Jetty Server的工厂类.
 * 
 * @author chenlg
 */
public class JettyFactory {

    public static final String DEFAULT_WEBAPP_PATH = "../../cmmi-server/src/main/webapp";

    public static final String CONTEXT_PATH        = "/cmmi";

    /**
     * 创建用于开发运行调试的Jetty Server, 以src/main/webapp为Web应用目录.
     */
    public static Server createServerInSource(int port) {
        Server server = new Server();
        // 设置在JVM退出时关闭Jetty的钩子。
        server.setStopAtShutdown(true);

        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(port);
        // 解决Windows下重复启动Jetty居然不报告端口冲突的问题.
        connector.setReuseAddress(false);
        server.setConnectors(new Connector[] { connector });

        WebAppContext webContext = new WebAppContext(DEFAULT_WEBAPP_PATH, CONTEXT_PATH);

        server.setHandler(webContext);

        return server;
    }

    /**
     * 快速重新启动application，重载所有target/classes与target/test-classes.
     */
    public static void reloadContext(Server server) throws Exception {
        WebAppContext context = (WebAppContext) server.getHandler();

        System.out.println("[INFO] Application reloading");
        context.stop();

        WebAppClassLoader classLoader = new WebAppClassLoader(context);
        //        
        //运行需要的模块
        classLoader.addClassPath(CMMI_BIZ_PROCESS_DAEMON);
        classLoader.addClassPath(CMMI_BIZ_PROCESS_SERCURITY);
        classLoader.addClassPath(CMMI_BIZ_SERVICE_ESCAPE);
        classLoader.addClassPath(CMMI_BIZ_SERVICE_LOGIC);
        classLoader.addClassPath(CMMI_BIZ_SHARED);
        classLoader.addClassPath(CMMI_COMMON_SERVICE_FACADE);
        classLoader.addClassPath(CMMI_COMMON_SERVICE_REMOTE);
        classLoader.addClassPath(CMMI_COMMON_SERVICE_RESPONSE);
        classLoader.addClassPath(CMMI_COMMON_SHARED);
        classLoader.addClassPath(CMMI_COMMON_UTILS);
        classLoader.addClassPath(CMMI_CORE_DOMAIN);
        classLoader.addClassPath(CMMI_CORE_PERSISTANT_PO);
        classLoader.addClassPath(CMMI_CORE_PERSISTANT_REPOSITORY);
        classLoader.addClassPath(CMMI_CORE_PROCESS_CACHE);
        classLoader.addClassPath(CMMI_CORE_PROCESS_EXTENSION);
        classLoader.addClassPath(CMMI_CORE_SHARED);

        //当前
        classLoader.addClassPath("target/classes");
        classLoader.addClassPath("target/test-classes");
        context.setClassLoader(classLoader);

        context.start();

        System.out.println("[INFO] Application reloaded");
    }

    public static final String CMMI_BIZ_PROCESS_DAEMON         = "../../cmmi-modules/cmmi-biz/cmmi-biz-process/cmmi-biz-process-daemon/target/classes";
    public static final String CMMI_BIZ_PROCESS_SERCURITY      = "../../cmmi-modules/cmmi-biz/cmmi-biz-process/cmmi-biz-process-sercurity/target/classes";
    public static final String CMMI_BIZ_SERVICE_ESCAPE         = "../../cmmi-modules/cmmi-biz/cmmi-biz-service/cmmi-biz-service-escape/target/classes";
    public static final String CMMI_BIZ_SERVICE_LOGIC          = "../../cmmi-modules/cmmi-biz/cmmi-biz-service/cmmi-biz-service-logic/target/classes";
    public static final String CMMI_BIZ_SHARED                 = "../../cmmi-modules/cmmi-biz/cmmi-biz-shared/target/classes";
    public static final String CMMI_COMMON_SERVICE_FACADE      = "../../cmmi-modules/cmmi-common/cmmi-common-service/cmmi-common-service-facade/target/classes";
    public static final String CMMI_COMMON_SERVICE_REMOTE      = "../../cmmi-modules/cmmi-common/cmmi-common-service/cmmi-common-service-remote/target/classes";
    public static final String CMMI_COMMON_SERVICE_RESPONSE    = "../../cmmi-modules/cmmi-common/cmmi-common-service/cmmi-common-service-response/target/classes";
    public static final String CMMI_COMMON_SHARED              = "../../cmmi-modules/cmmi-common/cmmi-common-shared/target/classes";
    public static final String CMMI_COMMON_UTILS               = "../../cmmi-modules/cmmi-common/cmmi-common-utils/target/classes";
    public static final String CMMI_CORE_DOMAIN                = "../../cmmi-modules/cmmi-core/cmmi-core-domain/target/classes";
    public static final String CMMI_CORE_PERSISTANT_PO         = "../../cmmi-modules/cmmi-core/cmmi-core-persistant/cmmi-core-persistant-po/target/classes";
    public static final String CMMI_CORE_PERSISTANT_REPOSITORY = "../../cmmi-modules/cmmi-core/cmmi-core-persistant/cmmi-core-persistant-repository/target/classes";
    public static final String CMMI_CORE_PROCESS_CACHE         = "../../cmmi-modules/cmmi-core/cmmi-core-process/cmmi-core-process-cache/target/classes";
    public static final String CMMI_CORE_PROCESS_EXTENSION     = "../../cmmi-modules/cmmi-core/cmmi-core-process/cmmi-core-process-extension/target/classes";
    public static final String CMMI_CORE_SHARED                = "../../cmmi-modules/cmmi-core/cmmi-core-shared/target/classes";

}
