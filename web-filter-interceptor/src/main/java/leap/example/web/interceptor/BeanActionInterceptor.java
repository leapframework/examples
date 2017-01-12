package leap.example.web.interceptor;

import leap.core.annotation.Bean;
import leap.core.validation.Validation;
import leap.lang.intercepting.State;
import leap.lang.logging.Log;
import leap.lang.logging.LogFactory;
import leap.web.action.ActionContext;
import leap.web.action.ActionExecution;

/**
 * Created by kael on 2017/1/6.
 */
@Bean
public class BeanActionInterceptor implements leap.web.action.ActionInterceptor {
    private static final Log log = LogFactory.get(BeanActionInterceptor.class);

    @Override
    public State preExecuteAction(ActionContext context, Validation validation) throws Throwable {
        log.info("do BeanActionInterceptor.preExecuteAction");
        return State.CONTINUE;
    }

    @Override
    public State postExecuteAction(ActionContext context, Validation validation,
                                   ActionExecution execution) throws Throwable {
        log.info("do BeanActionInterceptor.postExecuteAction");
        return State.CONTINUE;
    }

    @Override
    public State onActionFailure(ActionContext context, Validation validation,
                                 ActionExecution execution) throws Throwable {
        log.info("do BeanActionInterceptor.onActionFailure");
        return State.CONTINUE;
    }

    @Override
    public void completeExecuteAction(ActionContext context, Validation validation,
                                      ActionExecution execution) throws Throwable {
        log.info("do BeanActionInterceptor.completeExecuteAction");
    }
}
