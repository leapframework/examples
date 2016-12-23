package leap.example.webbean.bean;

import leap.lang.logging.Log;
import leap.lang.logging.LogFactory;

/**
 * Created by kael on 2016/12/23.
 */
public class NotLazyInitBean {
    
    private static final Log log = LogFactory.get(NotLazyInitBean.class);
    
    public NotLazyInitBean() {
        log.info("create NotLazyInitBean when load ....");
    }
    
}
