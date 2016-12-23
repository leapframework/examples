package leap.example.webbean.bean;

import leap.core.annotation.Bean;

/**
 * Created by kael on 2016/12/23.
 * 
 * use annotation to create bean
 * 
 */
@Bean(name = "bean3")
public class ServiceBean3 implements ServiceBean {
    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
