package dat3.car.shared.services.Http;

import org.springframework.http.ResponseEntity;

public interface IHttpNotUpdated<TResponse> {
    ResponseEntity<TResponse> notUpdated();
    ResponseEntity<TResponse> notUpdated(String message);
}
