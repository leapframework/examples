package leap.example.weblistener;

import leap.lang.logging.Log;
import leap.lang.logging.LogFactory;
import leap.web.App;
import leap.web.config.WebConfigurator;

/**
 * Created by kael on 2016/12/23.
 */
public class Global extends App{
    
    private static final Log log = LogFactory.get(Global.class);

    /**
     * 启动前的配置修改和设置
     * @param c
     */
    @Override
    protected void configure(WebConfigurator c) {
        log.info("app configure ...");
    }

    /**
     * 应用初始化
     * @throws Throwable
     */
    @Override
    protected void init() throws Throwable {
        log.info("web app init...");
    }

    /**
     * 应用启动
     * @throws Throwable
     */
    @Override
    protected void start() throws Throwable {
        log.info("app start ...");
    }

    /**
     * 应用停止
     * @throws Throwable
     */
    @Override
    protected void stop() throws Throwable {
        log.info("app stop ...");
    }
}
