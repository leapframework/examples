package leap.example.weblistener.listener;

import leap.core.annotation.Bean;
import leap.lang.logging.Log;
import leap.lang.logging.LogFactory;
import leap.web.App;
import leap.web.AppListener;
import leap.web.config.WebConfig;
import leap.web.config.WebConfigurator;

/**
 * Created by kael on 2016/12/23.
 */
@Bean
public class WebAppListener implements AppListener {
    
    private static final Log log = LogFactory.get(WebAppListener.class);

    /**
     * 执行应用配置开始前执行
     * @param app
     * @param c
     * @throws Throwable
     */
    @Override
    public void preAppConfigure(App app, WebConfigurator c) throws Throwable {
        log.info("pre app configure....");
    }

    /**
     * 执行应用配置后执行
     * @param app
     * @param c
     * @throws Throwable
     */
    @Override
    public void postAppConfigure(App app, WebConfig c) throws Throwable {
        log.info("post app configure....");
    }

    /**
     * 应用初始化前执行
     * @param app
     * @throws Throwable
     */
    @Override
    public void preAppInit(App app) throws Throwable {
        log.info("pre app init....");
    }

    /**
     * 应用初始化后执行
     * @param app
     * @throws Throwable
     */
    @Override
    public void postAppInit(App app) throws Throwable {
        log.info("post app init....");
    }

    /**
     * 应用启动前执行
     * @param app
     * @throws Throwable
     */
    @Override
    public void preAppStart(App app) throws Throwable {
        log.info("pre app start....");
    }

    /**
     * 应用启动后执行
     * @param app
     * @throws Throwable
     */
    @Override
    public void postAppStart(App app) throws Throwable {
        log.info("post app start....");
    }

    /**
     * 应用停止前执行
     * @param app
     * @throws Throwable
     */
    @Override
    public void preAppStop(App app) throws Throwable {
        log.info("pre app stop....");
    }

    /**
     * 应用停止后执行
     * @param app
     * @throws Throwable
     */
    @Override
    public void postAppStop(App app) throws Throwable {
        log.info("post app stop....");
    }
}
