package leap.example.webbean.controller;

import leap.core.BeanFactory;
import leap.core.annotation.Inject;
import leap.example.webbean.bean.CustomerBean;
import leap.example.webbean.bean.LazyInitBean;
import leap.example.webbean.bean.ServiceBean;
import leap.lang.logging.Log;
import leap.lang.logging.LogFactory;
import leap.web.action.ControllerBase;
import leap.web.view.ViewData;

import java.util.List;

/**
 * Created by kael on 2016/12/23.
 */
public class HomeController extends ControllerBase {
    
    private static final Log log = LogFactory.get(HomeController.class);
    
    // inject system bean
    @Inject
    private BeanFactory factory;
    
    // inject customer bean and bean list
    @Inject
    private ServiceBean[] serviceBeans;
    @Inject(name = "bean1")
    private ServiceBean bean1;
    @Inject(name = "bean2")
    private ServiceBean bean2;
    @Inject(name = "bean3")
    private ServiceBean bean3;
    
    // custom factory
    @Inject
    private CustomerBean customerBean;
    
    public void index(ViewData vd){
        
        vd.put("serviceBeans",serviceBeans);
        vd.put("bean1",bean1);
        vd.put("bean2",bean2);
        vd.put("bean3",bean3);
        
        vd.put("customerBean",customerBean);
        // first use LazyInitBean
        LazyInitBean lazyInitBean = factory.getBean(LazyInitBean.class);

        log.info(lazyInitBean.getClass().getName() + " has been created!");
    }
}
