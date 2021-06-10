package com.example.mybatisplus.tenant.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {

        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 多租户插件
        interceptor.addInnerInterceptor(new TenantLineInnerInterceptor(new TenantLineHandler() {

            @Override
            public Expression getTenantId() {
                // 返回当前用户的租户ID
                LocalUser currentUser = CurrentUser.getCurrentUser();
                if (null == currentUser) {
                    throw new RuntimeException("Get CurrentTenantId Error!");
                }
                return new LongValue(currentUser.getTid());
            }


            @Override
            public String getTenantIdColumn() {
                return "tenant_id";
            }


            @Override
            public boolean ignoreTable(String tableName) {
                return false;
            }
        }));

        return interceptor;
    }
}
