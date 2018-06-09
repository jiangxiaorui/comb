package com.qhz.comb.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author jiangting
 * @since 1.0, 2018/4/27
 */
@Slf4j
@Component
public class TestFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 6;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
//        RequestContext requestContext = RequestContext.getCurrentContext();
//        HttpServletResponse servletResponse = requestContext.getResponse();
//        Map<String, List<String>> mm = requestContext.getRequestQueryParams();
//        mm.forEach((k, v) -> {
//            v.add("3");
//        });
//        requestContext.setRequestQueryParams(mm);
//        RequestContext requestContext1 = RequestContext.getCurrentContext();
//        Map<String, List<String>> cc =requestContext1.getRequestQueryParams();
        return null;
    }
}
