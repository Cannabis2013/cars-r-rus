package dat3.car.security.api;

import dat3.car.security.dto.LoginRequest;
import dat3.car.security.dto.TokenLoginResponse;
import dat3.car.security.factories.httpResult.IHttpAuthResult;
import dat3.car.security.factories.response.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://cars-frontend.mh2012.dk")
@RestController
@RequestMapping("/api/auth/")
public class AuthenticationController {
  public AuthenticationController(LoginResponse<LoginRequest, TokenLoginResponse> loginResponse, IHttpAuthResult result) {
    _loginResponse = loginResponse;
    _result = result;
  }

  @GetMapping("authenticated")
  @PreAuthorize("hasRole('USER')")
  public ResponseEntity<String> isAuthenticated(){
    return ResponseEntity.ok().body("Is authenticated");
  }

  @PostMapping("login")
  public ResponseEntity<String> login(@RequestBody LoginRequest request) {
    var response = _loginResponse.fromRequest(request);
    if(response == null)
      return _result.wrongCredentials();
    return _result.authenticated(response);
  }

  private final LoginResponse<LoginRequest, TokenLoginResponse> _loginResponse;
  private final IHttpAuthResult<String> _result;
}


