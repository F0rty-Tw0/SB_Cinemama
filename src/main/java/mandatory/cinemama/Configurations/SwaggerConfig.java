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

@Configuration
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
        "- This is a Mandatory School project, designed by the team <b>PIE</b>.<br><br><em>Contributed by:</em><br><br><b>Artiom Tofan<br>Nikolai Lenander<br>Paweł Stępień<br>Tom Billington</b><br><br><em>All rights reserved.</em>"
      )
      .version("1.0")
      .build();
  }

  private ApiKey apiKey() {
    return new ApiKey("jwtToken", "Authorization", "header");
  }
}
