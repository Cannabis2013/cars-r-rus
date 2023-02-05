package dat3.car.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeApi {
    @GetMapping("/")
    public String welcome()
    {
        return "Cars'r'rus web api v0.02a";
    }
}
