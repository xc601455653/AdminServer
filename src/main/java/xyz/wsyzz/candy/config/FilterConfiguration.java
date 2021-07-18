package xyz.wsyzz.candy.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.wsyzz.candy.filter.CorssFilter;

import java.math.BigDecimal;

/**
 * Created by xucan on 2019/12/7.
 */
@Configuration
public class FilterConfiguration {

    /**
     * 跨域相关配置
     * @return
     */
    @Bean
    public FilterRegistrationBean crossFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new CorssFilter());
        filterRegistrationBean.setOrder(BigDecimal.ONE.intValue());
        return filterRegistrationBean;
    }
}
