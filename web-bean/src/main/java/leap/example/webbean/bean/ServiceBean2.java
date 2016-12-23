package leap.example.webbean.bean;

/**
 * Created by kael on 2016/12/23.
 * 
 * config bean in beans/service.xml
 * 
 */
public class ServiceBean2 implements ServiceBean {
    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
