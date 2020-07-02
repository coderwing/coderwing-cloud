package com.coderwing.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class CloudZuulFilter extends ZuulFilter {

    /**
     * 返回过滤的类型
     * zuul中定义了4中不同的过滤类型：

     pre：路由之前
     routing：路由之时
     post： 路由之后
     error：发送错误调用

     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断是否要过滤，可以写逻辑
     * 这里直接写true
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤的具体国际
     * 可通过sql、nosql等形式，检查是否有对应的权限
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        // 获取请求参数token 进行检查
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                // 回写错误信息
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e){}
            return null;
        }
        log.info("ok");
        return null;
    }

}
