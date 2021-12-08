package com.atck.boot.config;

import com.atck.boot.bean.Pet;
import com.atck.boot.converter.MyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.List;

@Configuration
public class WebConfig /*implements WebMvcConfigurer*/ //第一种写法
{
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter()
    {
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam("_m");
        return hiddenHttpMethodFilter;
    }

    // @Override
    // public void configurePathMatch(PathMatchConfigurer configurer)
    // {
    //     UrlPathHelper urlPathHelper = new UrlPathHelper();
    //
    //     //设置不移除分号及其后面的内容
    //     urlPathHelper.setRemoveSemicolonContent(false);
    //
    //     configurer.setUrlPathHelper(urlPathHelper);
    // }


    //第二种写法
    @Bean
    public WebMvcConfigurer webMvcConfigurer()
    {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer()
        {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer)
            {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer)
            {
                //为内容协商策略中添加一种可以处理的媒体类型，让其与format后的参数值对应
                configurer.mediaType("atck", new MediaType("application", "x-atck"));
            }

            @Override
            public void addFormatters(FormatterRegistry registry)
            {
                registry.addConverter(new Converter<String, Pet>()
                {
                    @Override
                    public Pet convert(String source)
                    {
                        //阿猫,3
                        if (!StringUtils.isEmpty(source))
                        {
                            Pet pet = new Pet();
                            String[] split = source.split(",");
                            pet.setName(split[0]);
                            pet.setAge(split[1]);
                            return pet;
                        }
                        return null;
                    }
                });
            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters)
            {
                converters.add(new MyMessageConverter());
            }
        };


        return webMvcConfigurer;
    }

}
