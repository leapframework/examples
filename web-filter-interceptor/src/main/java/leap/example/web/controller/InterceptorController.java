package leap.example.web.controller;

import leap.example.web.interceptor.AnnotationInterceptor;
import leap.web.annotation.InterceptedBy;

/**
 * Created by kael on 2016/12/23.
 */
public class InterceptorController {
    @InterceptedBy(AnnotationInterceptor.class)
    public String index(){
        return this.getClass().getName();
    }
}
