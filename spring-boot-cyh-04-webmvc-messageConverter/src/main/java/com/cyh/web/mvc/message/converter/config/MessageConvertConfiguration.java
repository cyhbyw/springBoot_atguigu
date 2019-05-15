package com.cyh.web.mvc.message.converter.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 如果有配置文件继承了 DelegatingWebMvcConfiguration 或者 WebMvcConfigurationSupport
 * 或者配置文件有 @EnableWebMvc 那么 @EnableAutoConfiguration 中的 WebMvcAutoConfiguration 将不会被自动配置，
 * 而是使用 WebMvcConfigurationSupport 的配置
 *
 * @EnableWebMvc = WebMvcConfigurationSupport 使用 @EnableWebMvc 注解等于扩展 WebMvcConfigurationSupport 但是没有重写任何方法
 *
 * @author: yanhua.chen
 * @date: 2019/5/14 11:45
 */
@Configuration
public class MessageConvertConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private HttpMessageConverters httpMessageConverters;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        /*
         * "birthday": "2019-05-10T02:59:05.588Z"
         * 这样写了之后，需要按照上面的格式，否则会报错
         * 这种格式，应该也是默认的格式，不常用
         * 所以，一般的项目代码需要自定义一种格式，比如最常用的 yyyy-MM-dd hh:mm:ss
         */
        converters.addAll(httpMessageConverters.getConverters());
    }

    /**
     * 这里有个坑
     * 就是如果单独写个配置类去实现 org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter 并重写
     * 下面方法的话，其实不会生效！
     * 具体原因还不知道，但是感觉是和此处的 extends WebMvcConfigurationSupport 冲突了
     * 所以，将下面这个方法重写在这里
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new DateFormatInterceptor()).addPathPatterns("/**");
    }

}
