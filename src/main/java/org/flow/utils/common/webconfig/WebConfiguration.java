package org.flow.utils.common.webconfig;

import org.flow.utils.common.interceptor.LogInterceptor;
import org.flow.utils.common.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * 日志拦截器
     */
    @Autowired
    private LogInterceptor logInterceptor;
    @Autowired
    private TimeInterceptor timeInterceptor;

    /**
     * 重写添加拦截器方法并添加配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor).addPathPatterns("/**");
        //registry.addInterceptor(timeInterceptor);
    }

//    @Bean
//    public FilterRegistrationBean timeFilter(){
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        TimeFilter timeFilter = new TimeFilter();
//        registrationBean.setFilter(timeFilter);
//
//        List<String> urls = new ArrayList<>();
//        urls.add("/*");
//        registrationBean.setUrlPatterns(urls);
//        return registrationBean;
//    }

}
