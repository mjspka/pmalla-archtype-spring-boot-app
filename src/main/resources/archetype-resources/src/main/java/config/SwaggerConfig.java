package ${package}.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The purpose of this class is to define swagger configuration. The swagger api is accessible from http://localhost:8080/swagger-ui.html
 * 
 * @author Praveen Malla
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.apis(RequestHandlerSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("${package}"))
				.paths(PathSelectors.any())
				.build();
	}
}