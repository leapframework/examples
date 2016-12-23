package leap.example.web;

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
    }
}
