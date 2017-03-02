package leap.example.mvc.controller;

import leap.web.Request;
import leap.web.Response;
import leap.web.action.ControllerBase;
import leap.web.view.ViewData;

/**
 * Created by kael on 2016/12/27.
 * 
 * 默认的index控制器，控制器的访问根路径是{@code /},对应的视图目录是{@code WEB-INF/views/}
 * 
 */
public class HomeController extends ControllerBase {

    /**
     * 这个action的访问路径是 / 或 /index
     * action的视图是 WEB-INF/views/index.html 或 WEB-INF/views/index.jsp
     * ViewData是视图模型，视图变量可以放这里
     */
    public void index(ViewData vd){
        vd.put("path","HomeController.index");
    }


    /**
     * 这个action的访问路径是 /path
     * action的视图是 WEB-INF/views/path.html 或 WEB-INF/views/path.jsp
     */
    public void path(ViewData vd){
        vd.put("path","HomeController.path");
    }
    /**
     * 这个action的访问路径是 /new_path
     * action的视图是 WEB-INF/views/new_path.html 或 WEB-INF/views/new_path.jsp
     */
    public void newPath(){
        Request request = Request.current();
        ViewData vd = request.getResult().getViewData();
        if(vd != null){
            vd.put("path","HomeController.newPath");
        }
    }


    /**
     * 这个action的访问路径是 /specify_path
     * action的默认视图是 WEB-INF/views/specify_path.html 或 WEB-INF/views/specify_path.jsp
     * 这里通过指定视图使得这个action返回的视图为WEB-INF/views/specify/path.html
     */
    public String specifyPath(ViewData vd){
        vd.put("path","HomeController.specifyPath");
        // 多种方式指定视图
        // Results.renderView("view:/specify/path.html");
        return "view:/specify/path.html";
    }

    /**
     * 这个action的访问路径是/redirect，这里自动重定向到/index
     */
    public String redirect(Response response){
        // 多种方式重定向
        // response.sendRedirect("/");
        // Results.redirect("/");
        return "redirect:/";
    }
    
}
