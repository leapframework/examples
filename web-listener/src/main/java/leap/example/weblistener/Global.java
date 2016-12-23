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

    @Override
    protected void configure(WebConfigurator c) {
        log.info("app configure ...");
    }

    @Override
    protected void init() throws Throwable {
        log.info("web app init...");
    }

    @Override
    protected void start() throws Throwable {
        log.info("app start ...");
    }

    @Override
    protected void stop() throws Throwable {
        log.info("app stop ...");
    }
}
