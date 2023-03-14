package dat3.car.security.filter;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Service;

@Service
public class DefaultHttpFiltering implements HttpFiltering {
    @Override
    public void setupFilter(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.POST,"/api/auth/login").permitAll()
                .requestMatchers("/").permitAll()
                .anyRequest()
                .authenticated());
    }
}
