package leap.example.web;

import leap.example.web.filter.RequestFilter;
import leap.example.web.interceptor.ActionInterceptor;
import leap.example.web.interceptor.RequestInterceptor;
import leap.lang.logging.Log;
import leap.lang.logging.LogFactory;
import leap.web.App;

/**
 * Created by kael on 2016/12/23.
 */
public class Global extends App{
    
    private static final Log log = LogFactory.get(Global.class);
    
    @Override
    protected void init() throws Throwable {
        log.info("web app init...");
        filters().add(new RequestFilter());
        interceptors().add(new RequestInterceptor());
        interceptors().add(new ActionInterceptor());
    }
}
