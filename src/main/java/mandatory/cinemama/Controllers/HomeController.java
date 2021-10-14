package mandatory.cinemama.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

@Controller
public class HomeController {

  @ApiIgnore
  @GetMapping("/")
  public RedirectView index() {
    return new RedirectView("swagger-ui/index.html");
  }
}
