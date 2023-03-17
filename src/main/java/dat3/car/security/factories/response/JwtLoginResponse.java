package dat3.car.security.factories.response;

import dat3.car.security.dto.LoginRequest;
import dat3.car.security.dto.TokenLoginResponse;
import dat3.car.security.entities.User;
import dat3.car.security.services.MyUserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class JwtLoginResponse implements LoginResponse<LoginRequest, TokenLoginResponse> {
    public JwtLoginResponse(AuthenticationManager authenticationManager, JwtEncoder encoder) {
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
    }

    @Override
    public TokenLoginResponse fromRequest(LoginRequest request) {
        User user;
        try {
            user = authenticateCredentials(request);
        } catch (BadCredentialsException e){
            return null;
        }
        var claims = userClaims(user);
        var token = generateToken(claims);
        return new TokenLoginResponse(user.getUsername(),token,user.getRoles());
    }

    private User authenticateCredentials(LoginRequest request){
        var uat = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        var authentication = authenticationManager.authenticate(uat);
        var ud = (MyUserDetails) authentication.getPrincipal();
        return ud.getUser();
    }

    private JwtClaimsSet userClaims(User user){
        var authorities = String.join(" ", user.getRoles());
        var now = Instant.now();
        return JwtClaimsSet.builder()
                .issuer(tokenIssuer)  //Only this for simplicity
                .issuedAt(now)
                .audience(List.of("not used"))
                .expiresAt(now.plusSeconds(tokenExpiration))
                .subject(user.getUsername())
                .claim("roles",authorities)
                .build();
    }

    private String generateToken(JwtClaimsSet claims){
        var jwsHeader = JwsHeader.with(() -> "HS256").type("JWT").build();
        var headerParameters = JwtEncoderParameters.from(jwsHeader, claims);
        return encoder.encode(headerParameters).getTokenValue();
    }

    @Value("${app.token.issuer}")
    private String tokenIssuer;

    @Value("${app.token.expiration}")
    private long tokenExpiration;
    private final AuthenticationManager authenticationManager;

    private final JwtEncoder encoder;
}
