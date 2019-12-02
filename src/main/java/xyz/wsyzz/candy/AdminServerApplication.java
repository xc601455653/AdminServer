package xyz.wsyzz.candy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import xyz.wsyzz.candy.listener.RequestListener;


@MapperScan("xyz.wsyzz.candy.mapper")
@ServletComponentScan
@Configuration
@EnableSwagger2
@SpringBootApplication
public class AdminServerApplication {
	@Autowired
    RequestListener requestListener;
	public static void main(String[] args) {
		SpringApplication.run(AdminServerApplication.class, args);
	}

    /**
     * swagger扫描配置
     * @return
     */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				// 自行修改为自己的包路径
				.apis(RequestHandlerSelectors.basePackage("xyz.wsyzz.candy"))
				.paths(PathSelectors.any())
				.build();
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
    public ServletListenerRegistrationBean<RequestListener> servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<RequestListener> listenerRegistrationBean = new ServletListenerRegistrationBean<RequestListener>();
        listenerRegistrationBean.setListener(requestListener);
        return listenerRegistrationBean;
    }


}
