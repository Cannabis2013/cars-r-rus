package dat3.car.contracts.Http;

import org.springframework.http.ResponseEntity;

public interface IHttpNotUpdated<TResponse> {
    ResponseEntity<TResponse> notUpdated();
    ResponseEntity<TResponse> notUpdated(String message);
}
