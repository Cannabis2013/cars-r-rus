package dat3.car.security.factories.httpResult;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HttpLoginResult implements IHttpAuthResult<String> {
    @Override
    public ResponseEntity<String> wrongCredentials() {
        return new ResponseEntity<>("Username or password wrong", HttpStatus.UNAUTHORIZED);
    }

    @Override
    public <TEntity> ResponseEntity<String> authenticated(TEntity entity) {
        var json = new JSONObject(entity).toString();
        return new ResponseEntity<>(json,HttpStatus.OK);
    }

}
