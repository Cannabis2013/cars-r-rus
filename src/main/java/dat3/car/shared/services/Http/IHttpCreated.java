package dat3.car.shared.services.Http;

import org.springframework.http.ResponseEntity;

public interface IHttpCreated<TResponse> {
    <TEntity> ResponseEntity<TResponse> created();
    <TEntity> ResponseEntity<TResponse> created(TEntity entity);
}
