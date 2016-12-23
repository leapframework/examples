package leap.example.webbean.bean;

/**
 * Created by kael on 2016/12/23.
 * 
 * config bean in beans.xml
 * 
 */
public class ServiceBean1 implements ServiceBean {
    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
