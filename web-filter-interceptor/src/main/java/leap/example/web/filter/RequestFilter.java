package leap.example.web.filter;

import leap.lang.logging.Log;
import leap.lang.logging.LogFactory;
import leap.web.Filter;
import leap.web.FilterChain;
import leap.web.Request;
import leap.web.Response;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by kael on 2016/12/23.
 */
public class RequestFilter implements Filter {

    private static final Log log = LogFactory.get(RequestFilter.class);
    
    @Override
    public void doFilter(Request request, Response response,
                         FilterChain filterChain) throws ServletException, IOException {
        log.info("execute " + this.getClass().getName());
        filterChain.doFilter(request,response);
    }
}
