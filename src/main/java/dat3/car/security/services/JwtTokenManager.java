package dat3.car.security.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenManager implements HttpSecretsManager {

    @Override
    public String tokenSecret() {
        return tokenSecret;
    }

    @Value("${app.secret.key}")
    public String tokenSecret;

}
