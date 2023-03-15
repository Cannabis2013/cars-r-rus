package dat3.car.security.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TokenLoginResponse {
  public TokenLoginResponse(String userName, String token, List<String> roles) {
    this.username = userName;
    this.token = token;
    this.roles = roles;
  }
  private String username;
  private String token;
  private List<String> roles;
}