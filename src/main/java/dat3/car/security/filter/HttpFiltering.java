package dat3.car.security.filter;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface HttpFiltering {
    void setupFilter(HttpSecurity http) throws Exception;
}
