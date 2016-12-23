package leap.example.web.interceptor;

import leap.core.validation.Validation;
import leap.lang.intercepting.State;
import leap.lang.logging.Log;
import leap.lang.logging.LogFactory;
import leap.web.action.ActionContext;
import leap.web.action.ActionExecution;

/**
 * Created by kael on 2016/12/23.
 */
public class AnnotationInterceptor implements leap.web.action.ActionInterceptor {
    
    private static final Log log = LogFactory.get(AnnotationInterceptor.class);
    
    @Override
    public State preExecuteAction(ActionContext context, Validation validation) throws Throwable {
        log.info("do AnnotationInterceptor.preExecuteAction");
        return State.CONTINUE;
    }

    @Override
    public State postExecuteAction(ActionContext context, Validation validation,
                                   ActionExecution execution) throws Throwable {
        log.info("do AnnotationInterceptor.postExecuteAction");
        return State.CONTINUE;
    }

    @Override
    public State onActionFailure(ActionContext context, Validation validation,
                                 ActionExecution execution) throws Throwable {
        log.info("do AnnotationInterceptor.onActionFailure");
        return State.CONTINUE;
    }

    @Override
    public void completeExecuteAction(ActionContext context, Validation validation,
                                      ActionExecution execution) throws Throwable {
        log.info("do AnnotationInterceptor.completeExecuteAction");
    }
}
