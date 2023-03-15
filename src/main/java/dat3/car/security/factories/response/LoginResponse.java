package dat3.car.security.factories.response;

public interface LoginResponse<TRequest, TResponse> {
    TResponse fromRequest(TRequest request);
}
