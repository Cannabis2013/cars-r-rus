package dat3.car.shared.services.Http;

public abstract class IHttpResult<TResponse> implements IHttpOk<TResponse>,
        IHttpNotFound<TResponse>,
        IHttpCreated<TResponse>,
        IHttpBadRequest<TResponse>,
        IHttpNotUpdated<TResponse>
{
}
