package dat3.car.security.services.configuartion;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.CorsFilter;

@Service
public class LooseHttpSecurityOptions implements HttpSecurityOptions {
    @Override
    public void setupOptions(HttpSecurity http) throws Exception {
        /*
            Enable h2 console ui
         */
        //http.headers().frameOptions().disable();
        /*
            Disable xss and cross site forgery attack
         */
        http.cors().and().csrf().disable();
    }
}
