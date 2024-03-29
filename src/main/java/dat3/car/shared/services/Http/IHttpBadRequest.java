package dat3.car.shared.services.Http;

import org.springframework.http.ResponseEntity;

public interface IHttpBadRequest<TResponse> {
    ResponseEntity<TResponse> badRequest(String message);
}
