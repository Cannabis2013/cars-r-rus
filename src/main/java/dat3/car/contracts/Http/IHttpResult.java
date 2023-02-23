package dat3.car.contracts.Http;

import org.springframework.http.ResponseEntity;

public abstract class IHttpResult<TResponse> implements IHttpOk<TResponse>,
        IHttpNotFound<TResponse>,
        IHttpCreated<TResponse>,
        IHttpBadRequest<TResponse>,
        IHttpNotUpdated<TResponse>
{
}
