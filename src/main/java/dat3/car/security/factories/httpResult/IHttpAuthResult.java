package dat3.car.security.factories.httpResult;

import org.springframework.http.ResponseEntity;

public interface IHttpAuthResult<TResponse> {
    ResponseEntity<TResponse> wrongCredentials();
    <TEntity> ResponseEntity<TResponse> authenticated(TEntity entity);
}
