package leap.example.web.interceptor;

import leap.lang.intercepting.State;
import leap.lang.logging.Log;
import leap.lang.logging.LogFactory;
import leap.web.Request;
import leap.web.RequestExecution;
import leap.web.Response;
import leap.web.action.ActionContext;
import leap.web.route.Route;

/**
 * Created by kael on 2016/12/23.
 */
public class RequestInterceptor implements leap.web.RequestInterceptor {
    
    private static final Log log = LogFactory.get(RequestInterceptor.class);
    
    @Override
    public State preHandleRequest(Request request, Response response) throws Throwable {
        log.info("do RequestInterceptor.preHandleRequest");
        return State.CONTINUE;
    }

    @Override
    public State handleRoute(Request request, Response response, Route route, ActionContext ac) throws Throwable {
        log.info("do RequestInterceptor.handleRoute");
        return State.CONTINUE;
    }

    @Override
    public State handleNoRoute(Request request, Response response) throws Throwable {
        log.info("do RequestInterceptor.handleNoRoute");
        return State.CONTINUE;
    }

    @Override
    public State postHandleRequest(Request request, Response response, RequestExecution execution) throws Throwable {
        log.info("do RequestInterceptor.handleNoRoute");
        return State.CONTINUE;
    }

    @Override
    public State onRequestFailure(Request request, Response response, RequestExecution execution) throws Throwable {
        log.info("do RequestInterceptor.handleNoRoute");
        return State.CONTINUE;
    }

    @Override
    public void completeHandleRequest(Request request, Response response, RequestExecution execution) throws Throwable {
        log.info("do RequestInterceptor.handleNoRoute");
    }
}
