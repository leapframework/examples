package leap.example.webbean.bean;

import leap.lang.logging.Log;
import leap.lang.logging.LogFactory;

/**
 * Created by kael on 2016/12/23.
 */
public class LazyInitBean {
    private static final Log log = LogFactory.get(NotLazyInitBean.class);

    public LazyInitBean() {
        log.info("create LazyInitBean when first use ....");
    }
}
