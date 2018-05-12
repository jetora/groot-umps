package org.flow.utils.common.fastjsonconfiguration;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
*
* Spring 5 FastJson配置
* WriteNullListAsEmpty  ：List字段如果为null,输出为[],而非null
* WriteNullStringAsEmpty ： 字符类型字段如果为null,输出为"",而非null
* DisableCircularReferenceDetect ：消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
* WriteNullBooleanAsFalse：Boolean字段如果为null,输出为false,而非null
* WriteMapNullValue：是否输出值为null的字段,默认为false。
*/
@Configuration
public class FastJsonConfiguration implements WebMvcConfigurer{
    @Bean
    public HttpMessageConverters customConverters(){
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteDateUseDateFormat
        );
        converter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(converter);
    }

}
