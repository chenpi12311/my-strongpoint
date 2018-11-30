package com.czp.mystrongpoint.interceptor;

import com.czp.mystrongpoint.constant.WebConstants;
import com.czp.mystrongpoint.model.Rouge;
import com.czp.mystrongpoint.service.RougeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private RougeService rougeService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String uri = request.getRequestURI();
        String remoteHost = request.getRemoteHost();
        log.info("Request url: [{}] from [{}]", uri, remoteHost);
        // 非admin路径不拦截
        if (!StringUtils.startsWith(uri, "/admin")) {
            return true;
        }
        HttpSession session = request.getSession();
        if (Objects.isNull(session)
                || Objects.isNull(session.getAttribute(WebConstants.WEB_LOGIN_USER))) {
            // session获取不到用户，看cookie能不能获取到
            String uid = getCookieId(request);
            if (Objects.isNull(uid)) {
                // 如果cookie为空
                response.sendRedirect(request.getContextPath() + "/index");
                return false;
            }
            // cookieId不为空，用cookieId获取数据库中的用户
            Rouge rouge = rougeService.getRouge(uid);
            if (Objects.isNull(rouge)) {
                // 无效用户
                response.sendRedirect(request.getContextPath() + "/index");
                return false;
            }
            // 设置session
            request.getSession().setAttribute(WebConstants.WEB_LOGIN_USER, rouge);
        }

        Rouge rouge = (Rouge) session.getAttribute(WebConstants.WEB_LOGIN_USER);
        log.info("The operator: [{}] go towards the uri: [{}]", rouge.getName(), uri);

        return true;
    }

    private String getCookieId(HttpServletRequest request) {
        if (!Objects.isNull(request)) {
            Cookie[] cookies = request.getCookies();
            if (cookies == null || cookies.length < 1) {
                return null;
            }
            for (Cookie cookie : cookies) {
                if (WebConstants.WEB_USER_ID_COOKIE.equals(cookie.getName())) {
                    // TODO 之后cookie要加密
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

}
