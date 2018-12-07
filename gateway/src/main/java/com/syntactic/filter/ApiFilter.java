package com.syntactic.filter;

/**
 * @auther SyntacticSugar
 * @data 2018/12/5 0005下午 5:00
 */

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * zuul 通过继承过滤器 ZuulFilter
 * 进行统一拦截
 */
@Component
public class ApiFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        // 逻辑代码
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //  获取传递的参数、验证权限
        String token = request.getParameter("token");
        //
        if (!"123456".equals(token)) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(400);
            //  把提示信息显示到 页面
            try {
                currentContext.getResponse().getWriter().write("token is invalid");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
