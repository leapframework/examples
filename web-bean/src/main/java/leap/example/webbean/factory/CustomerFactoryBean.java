package leap.example.webbean.factory;

import leap.core.BeanFactory;
import leap.core.ioc.FactoryBean;
import leap.example.webbean.bean.CustomerBean;

/**
 * Created by kael on 2016/12/27.
 */
public class CustomerFactoryBean implements FactoryBean<CustomerBean> {
    
    private static CustomerBean bean;
    
    @Override
    public CustomerBean getBean(BeanFactory beanFactory, Class<CustomerBean> type) {
        if(bean == null){
            bean = new CustomerBean();
        }
        return bean;
    }

    @Override
    public CustomerBean getBean(BeanFactory beanFactory, Class<CustomerBean> type, String name) {
        return getBean(beanFactory,type);
    }
}
