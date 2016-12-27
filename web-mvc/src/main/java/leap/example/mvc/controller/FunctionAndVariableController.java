package leap.example.mvc.controller;

import leap.web.annotation.Path;

/**
 * Created by kael on 2016/12/27.
 */
@Path("/fav")
public class FunctionAndVariableController {
    /**
     * 这个视图使用了环境变量和静态函数，看/WEB-INF/fav/index.html如何使用
     * conf/config.xml配置了静态函数
     * conf/beans.xml配置了环境变量
     */
    public void index(){
        
    }
    
}
