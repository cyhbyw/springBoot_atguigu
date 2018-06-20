package com.cyh.config;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.miemiedev.mybatis.paginator.OffsetLimitInterceptor;
import com.github.miemiedev.mybatis.paginator.dialect.MySQLDialect;

@Configuration
public class Config {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    /**
     * 注意，返回的对象是 SqlSessionFactory 而不是 SqlSessionFactoryBean
     * 方法名用 sqlSessionFactory 或者 sqlSessionFactoryBean 都是可以的，甚至是任意名字（如下所示）
     * @return SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory_CYH() {
        try {
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(dataSource());
            Resource[] resources =
                    new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml");
            sessionFactoryBean.setMapperLocations(resources);
            /* 注意：没有配置 mybatis-config.xml 文件 */

            OffsetLimitInterceptor offsetLimitInterceptor = new OffsetLimitInterceptor();
            offsetLimitInterceptor.setDialectClass(MySQLDialect.class.getName());
            // 分页插件
            sessionFactoryBean.setPlugins(new Interceptor[] {offsetLimitInterceptor});
            return sessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
