package dat3.car.security.services.configuartion;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface HttpSecurityServices {
    public void setupServices(HttpSecurity http) throws Exception;
}
