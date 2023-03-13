package dat3.car.members.services;

import dat3.car.shared.services.Http.IHttpResult;
import dat3.car.members.factories.IMemberFactory;
import dat3.car.members.dtos.MemberAddRequest;
import dat3.car.members.dtos.MemberUpdateRequest;
import dat3.car.members.repositories.IMemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Members {
    public Members(IMemberFactory factory, MemberUpdate update, IMemberRepository repository, IHttpResult<String> response) {
        _factory = factory;
        _update = update;
        _repository = repository;
        _response = response;
    }

    public ResponseEntity<String> all()
    {
        var unRestrictedMembers = _repository.findAll();
        var restrictedMembers = unRestrictedMembers.stream().map(_factory::toFetchResponse).toList();
        return _response.ok(restrictedMembers);
    }

    public ResponseEntity<String> get(String id)
    {
        var optional = _repository.findById(id);
        if(optional.isEmpty())
            return _response.notFound();
        var response = _factory.toFetchResponse(optional.get());
        return _response.ok(response);
    }
    public ResponseEntity<String> add(MemberAddRequest member)
    {

        var internal = _factory.fromAddRequest(member);
        try {
            _repository.save(internal);
        } catch (Exception e){
            return _response.badRequest(e.getMessage());
        }
        return _response.created(member);
    }

    public ResponseEntity<String> remove(String id)
    {
        try {
            _repository.deleteById(id);
        } catch (Exception e){
            return _response.badRequest("Failed to remove resource");
        }
        return _response.ok();
    }

    public ResponseEntity<String> update(MemberUpdateRequest request)
    {
        var optional = _repository.findById(request.getId());
        if(optional.isEmpty())
            return _response.notFound();
        var updated = _update.update(request,optional.get());
        try {
            _repository.save(updated);
        } catch (Exception e){
            return _response.notUpdated();
        }
        return _response.ok();
    }

    private final IMemberFactory _factory;
    private final MemberUpdate _update;
    private final IMemberRepository _repository;
    private final IHttpResult<String> _response;
}