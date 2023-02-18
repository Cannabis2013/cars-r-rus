package dat3.car.sla.Http;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IHttpResult<TResponse>{
    ResponseEntity<TResponse> ok();
    <TEntity> ResponseEntity<TResponse> ok(TEntity entity);
    <TEntity> ResponseEntity<TResponse> ok(List<TEntity> entities);
    <TEntity> ResponseEntity<TResponse> created(TEntity entity);
    ResponseEntity<TResponse> badRequest(String message);
    ResponseEntity<TResponse> notFound();
    ResponseEntity<TResponse> notFound(String message);
    ResponseEntity<TResponse> notUpdated();
    ResponseEntity<TResponse> notUpdated(String message);
}
