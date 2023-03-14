package dat3.car.security.services.configuartion;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface HttpSecurityOptions {
    void setupOptions(HttpSecurity http) throws Exception;
}
