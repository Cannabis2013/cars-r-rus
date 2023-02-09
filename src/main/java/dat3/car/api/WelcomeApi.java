package dat3.car.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class WelcomeApi {
    @GetMapping("/")
    public RedirectView welcome()
    {
        return new RedirectView("/swagger-ui/index.html");
    }

}
