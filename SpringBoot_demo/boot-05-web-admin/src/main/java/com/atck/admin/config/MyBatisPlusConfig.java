package com.atck.admin.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfig
{
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.H2);

        //设置请求的页面大于最大页后的操作，true返回首页，false继续请求，默认false
        paginationInnerInterceptor.setOverflow(true);

        //设置最大单页限制数量，默认500条，-1不受限制
        paginationInnerInterceptor.setMaxLimit(500L);

        //开启count的join优化，只针对left join

        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }
}
