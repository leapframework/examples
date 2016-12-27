package leap.example.mvc.controller;

import leap.web.annotation.Path;
import leap.web.annotation.http.DELETE;
import leap.web.annotation.http.GET;
import leap.web.annotation.http.POST;
import leap.web.view.ViewData;

/**
 * Created by kael on 2016/12/27.
 * 
 * Controller默认的访问路径是/mvc
 * 
 */
public class MvcController {
    /**
     * index是controller默认的action，所以这个action默认的访问路径是/mvc 或 /mvc/index
     */
    public void index(ViewData vd){
        vd.put("path", "MvcController.index");
    }
    /**
     * 这个action的访问路径是/mvc/new_path， 默认视图路径是/WEB-INF/views/mvc/new_path.html
     */
    public void newPath(ViewData vd){
        vd.put("path","MvcController.newPath");
    }


    /**
     * 这个action的访问路径是/specify， 默认视图路径是/WEB-INF/views/specify.html
     * 这里@Path使用了/开头，因此路径是相对顶级上下文的路径，如果不以/开头，则是相对controller的路径
     * 如：
     * @Path("specify")表示的访问路径是/mvc/specify
     * @Path是可以用在Controller上的
     */
    @Path("/specify")
    public void specifyPath(ViewData vd){
        vd.put("path","MvcController.specifyPath");
    }

    /**
     * 只接受GET类型的请求
     */
    @GET
    public String get(ViewData vd){
        vd.put("method","get");
        return "view:/mvc/method.html";
    }
    /**
     * 只接受POST类型的请求
     */
    @POST
    public String post(ViewData vd){
        vd.put("method","post");
        return "view:/mvc/method.html";
    }
    /**
     * 只接受DELETE类型的请求
     */
    @DELETE
    public String delete(ViewData vd){
        vd.put("method","delete");
        return "view:/mvc/method.html";
    }
}
