package dat3.car.services.members;

import dat3.car.Entities.members.MemberRestricted;
import dat3.car.SLA.Http.IHttpResult;
import dat3.car.factories.members.MemberFactory;
import dat3.car.repository.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Members {
    public Members(MemberFactory factory, MemberRepository repository, IHttpResult<String> response) {
        _factory = factory;
        _repository = repository;
        _response = response;
    }

    public ResponseEntity<String> all()
    {
        var unRestrictedMembers = _repository.findAll();
        var restrictedMembers = unRestrictedMembers.stream().map(_factory::toRestricted).toList();
        return _response.ok(restrictedMembers);
    }

    public ResponseEntity<String> get(String id)
    {
        var member = _repository.findById(id);
        if(member.isEmpty())
            return _response.notFound();
        return _response.ok((MemberRestricted) member.get());
    }
    public ResponseEntity<String> add(MemberRestricted member)
    {
        var internal = _factory.toUnrestricted(member);
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

    public ResponseEntity<String> update(MemberRestricted member)
    {
        var optional = _repository.findById(member.getId());
        if(optional.isEmpty())
            return _response.notFound();
        var updated = _factory.toUnrestricted(member,optional.get());
        try {
            _repository.save(updated);
        } catch (Exception e){
            return _response.notUpdated();
        }
        return _response.ok();
    }

    private final MemberFactory _factory;
    private final MemberRepository _repository;
    private final IHttpResult<String> _response;
}
