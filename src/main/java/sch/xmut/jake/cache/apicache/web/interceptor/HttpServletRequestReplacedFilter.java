package sch.xmut.jake.cache.apicache.web.interceptor;

import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Jake.lin on 2019/12/09
 */
@Component
public class HttpServletRequestReplacedFilter implements Filter {
    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        if(request instanceof HttpServletRequest) {
            requestWrapper = new MyHttpServletRequestWrapper((HttpServletRequest) request);
        }
        if(requestWrapper == null) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, response);
        }
    }
    @Override
    public void init(FilterConfig arg0) {}
}