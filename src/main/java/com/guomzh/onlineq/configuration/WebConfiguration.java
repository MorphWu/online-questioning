package com.guomzh.onlineq.configuration;

import com.guomzh.onlineq.intercepter.LoginRequiredInterceptor;
import com.guomzh.onlineq.intercepter.PassportInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zgm
 * @date 2018/9/6 16:47
 */
@Component
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Autowired
    private PassportInterceptor passportInterceptor;

    @Autowired
    private LoginRequiredInterceptor loginRequiredInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(passportInterceptor);
        registry.addInterceptor(loginRequiredInterceptor).addPathPatterns("/user/*");
        super.addInterceptors(registry);
    }
}
