package xyz.wsyzz.candy.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import xyz.wsyzz.candy.listener.RequestListener;

import java.net.InetAddress;
import java.util.Properties;

/**
 * Created by ${XC} on 2021/7/17.
 */
@Configuration
public class AdminServerApplicationConfiguration {

    @Value("${file.upload-dir:./uploads}")
    private String fileUploadPath;

    /**
     * swagger扫描配置
     * @return
     */
    @Bean
    public Docket api() throws Exception{
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("xyz.wsyzz.candy"))
                .paths(PathSelectors.any())
                .build();
                //.host("120.77.62.118");
    }

    /**
     * websocket容器配置
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    /**
     * swagger配置
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("糖果swagger-api文档")
                .description("swagger接入")
                //服务条款网址
                .termsOfServiceUrl("http://www.wsyzz.xyz")
                .version("1.0")
                .contact(new Contact("X.C", "http://www.wsyzz.xyz", "601455653@qq.com"))
                .build();
    }

    /**
     * 将监听器注册
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<RequestListener> servletListenerRegistrationBean(RequestListener requestListener) {
        ServletListenerRegistrationBean<RequestListener> listenerRegistrationBean = new ServletListenerRegistrationBean<RequestListener>();
        listenerRegistrationBean.setListener(requestListener);
        return listenerRegistrationBean;
    }

    /**
     * 多数据库相关配置
     * @return
     */
    @Bean
    public DatabaseIdProvider getDatabaseIdProvider(){
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties properties = new Properties();
        properties.setProperty("Oracle","oracle");
        properties.setProperty("MySQL","mysql");
        databaseIdProvider.setProperties(properties);
        return databaseIdProvider;
    }

    /**
     * druid数据源监控界面配置   地址:  IP:PORT/druid/index.html
     * @return
     */
    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        //先配置管理后台的servLet，访问的入口为/druid/
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                new StatViewServlet(), "/druid/*");
        // IP白名单 (没有配置或者为空，则允许所有访问)
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        // IP黑名单 (存在共同时，deny优先于allow)
        servletRegistrationBean.addInitParameter("deny", "");
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    /**
     * druid拦截器配置，做静态资源映射
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(
                new WebStatFilter());
        // 添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        // 添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(20);
        return threadPoolTaskScheduler;
    }

    public String getFileUploadPath() {
        return fileUploadPath;
    }

    public void setFileUploadPath(String fileUploadPath) {
        this.fileUploadPath = fileUploadPath;
    }
}
