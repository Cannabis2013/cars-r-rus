package dat3.car.SLA.Http;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HttpResult<TResponse>{
    <TEntity>ResponseEntity<TResponse> ok();
    <TEntity>ResponseEntity<TResponse> ok(TEntity entity);
    <TEntity>ResponseEntity<TResponse> ok(List<TEntity> entities);
    <TEntity>ResponseEntity<TResponse> created(TEntity entity);
    ResponseEntity<TResponse> bad(String message);
    ResponseEntity<TResponse> notFound();
}
