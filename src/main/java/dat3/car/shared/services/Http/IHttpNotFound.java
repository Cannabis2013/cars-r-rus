package dat3.car.shared.services.Http;

import org.springframework.http.ResponseEntity;

public interface IHttpNotFound<TResponse> {
    ResponseEntity<TResponse> notFound();
    ResponseEntity<TResponse> notFound(String message);
}
