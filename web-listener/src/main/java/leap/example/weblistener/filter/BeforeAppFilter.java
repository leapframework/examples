package leap.example.weblistener.filter;

import leap.core.AppContext;
import leap.lang.logging.Log;
import leap.lang.logging.LogFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by kael on 2016/12/23.
 */
public class BeforeAppFilter implements Filter {
    
    private static final Log log = LogFactory.get(BeforeAppFilter.class);
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        AppContext context = AppContext.current();
        log.info("init BeforeAppFilter filter, and context is inited : " + context.getName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        log.info("do filter : " + this.getClass().getName());
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info("destory filter : " + this.getClass().getName());
    }
}
