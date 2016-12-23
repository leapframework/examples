package leap.example.web.controller;

import leap.web.action.ControllerBase;
import leap.web.view.ViewData;

/**
 * Created by kael on 2016/12/23.
 */
public class HomeController extends ControllerBase {
    public void index(ViewData vd){
        vd.put("hello","hello leap!");
    }
}
