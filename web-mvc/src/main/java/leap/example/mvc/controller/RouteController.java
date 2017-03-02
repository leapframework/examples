package leap.example.mvc.controller;

import leap.core.annotation.Inject;
import leap.web.App;
import leap.web.annotation.Path;
import leap.web.route.Route;

/**
 * Created by kael on 2017/2/17.
 */
public class RouteController {
    @Inject
    private App app;

    /**
     * 这里假设传一个url参数过来，找到对应的route并返回json
     * @param url
     * @return
     */
    public Route getRoute(String url){
        for (Route route : app.routes()){
            if(route.getPathTemplate().matches(url)){
                Path p = route.getAction().getAnnotation(Path.class);
                if(p != null){
                    return route;
                }
            }
        }
        return null;
    }
}
