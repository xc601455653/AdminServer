package xyz.wsyzz.candy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
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

@MapperScan("xyz.wsyzz.candy.mapper")
@ServletComponentScan
@Configuration
@EnableSwagger2
@SpringBootApplication
public class AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServerApplication.class, args);
	}

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
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}

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


}
