package dat3.car.security;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.source.ImmutableSecret;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import dat3.car.security.filter.HttpFiltering;
import dat3.car.security.services.HttpSecretsManager;
import dat3.car.security.services.configuartion.HttpSecurityOptions;
import dat3.car.security.services.configuartion.HttpSecurityServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    public SecurityConfiguration(HttpFiltering filtering, HttpSecurityServices servicesConfig, HttpSecretsManager secrets, HttpSecurityOptions options) {
        _filtering = filtering;
        _config = servicesConfig;
        _secrets = secrets;
        _options = options;
    }

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        _options.setupOptions(http);
        _config.setupServices(http);
        _filtering.setupFilter(http);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtEncoder jwtEncoder() throws JOSEException {
        SecretKey key = new SecretKeySpec(_secrets.tokenSecret().getBytes(), "HmacSHA256");
        JWKSource<SecurityContext> immutableSecret = new ImmutableSecret<SecurityContext>(key);
        return new NimbusJwtEncoder(immutableSecret);
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKey originalKey = new SecretKeySpec(_secrets.tokenSecret().getBytes(), "HmacSHA256");
        NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withSecretKey(originalKey).build();
        return jwtDecoder;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    private final HttpFiltering _filtering;
    private final HttpSecurityOptions _options;
    private final HttpSecurityServices _config;
    private final HttpSecretsManager _secrets;
}