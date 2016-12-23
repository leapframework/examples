package leap.example.web.controller;

import leap.core.validation.Validation;
import leap.lang.intercepting.State;
import leap.lang.logging.Log;
import leap.lang.logging.LogFactory;
import leap.web.action.ActionContext;
import leap.web.action.ActionExecution;
import leap.web.action.ActionInterceptor;
import leap.web.annotation.NonAction;

/**
 * Created by kael on 2016/12/23.
 */
public class HomeController implements ActionInterceptor{
    
    private static final Log log = LogFactory.get(HomeController.class);
    
    public void index(){
        log.info("index...");
    }
    @NonAction
    @Override
    public State preExecuteAction(ActionContext context, Validation validation) throws Throwable {
        log.info("do HomeController.preExecuteAction");
        return State.CONTINUE;
    }
    @NonAction
    @Override
    public State postExecuteAction(ActionContext context, Validation validation,
                                   ActionExecution execution) throws Throwable {
        log.info("do HomeController.postExecuteAction");
        return State.CONTINUE;
    }
    @NonAction
    @Override
    public State onActionFailure(ActionContext context, Validation validation,
                                 ActionExecution execution) throws Throwable {
        log.info("do HomeController.onActionFailure");
        return State.CONTINUE;
    }
    @NonAction
    @Override
    public void completeExecuteAction(ActionContext context, Validation validation,
                                      ActionExecution execution) throws Throwable {
        log.info("do HomeController.completeExecuteAction");
    }
}
