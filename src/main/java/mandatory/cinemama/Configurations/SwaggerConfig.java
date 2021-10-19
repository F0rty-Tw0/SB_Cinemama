package mandatory.cinemama.Configurations;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
      .useDefaultResponseMessages(false)
      .select()
      .apis(RequestHandlerSelectors.basePackage("mandatory.cinemama"))
      .paths(PathSelectors.any())
      .build()
      .apiInfo(apiInfo())
      .securitySchemes(Arrays.asList(apiKey()));
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
      .title("Movie Theater REST Api")
      .description(
        "This is a Mandatory School project, designed by the team PIE."
      )
      .version("1.0")
      .build();
  }

  private ApiKey apiKey() {
    return new ApiKey("jwtToken", "Authorization", "header");
  }
}
