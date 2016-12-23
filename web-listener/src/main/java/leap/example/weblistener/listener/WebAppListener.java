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
    
    @Override
    public void preAppConfigure(App app, WebConfigurator c) throws Throwable {
        log.info("pre app configure....");
    }

    @Override
    public void postAppConfigure(App app, WebConfig c) throws Throwable {
        log.info("post app configure....");
    }

    @Override
    public void preAppInit(App app) throws Throwable {
        log.info("pre app init....");
    }

    @Override
    public void postAppInit(App app) throws Throwable {
        log.info("post app init....");
    }

    @Override
    public void preAppStart(App app) throws Throwable {
        log.info("pre app start....");
    }

    @Override
    public void postAppStart(App app) throws Throwable {
        log.info("post app start....");
    }

    @Override
    public void preAppStop(App app) throws Throwable {
        log.info("pre app stop....");
    }

    @Override
    public void postAppStop(App app) throws Throwable {
        log.info("post app stop....");
    }
}
