package dat3.car.shared.services.Http;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IHttpOk<TResponse> {
    ResponseEntity<TResponse> ok();
    <TEntity> ResponseEntity<TResponse> ok(TEntity entity);
    <TEntity> ResponseEntity<TResponse> ok(List<TEntity> entities);
}
