package dat3.car.services.members;

import dat3.car.sla.Http.IHttpResult;
import dat3.car.dto.members.MemberAddRequest;
import dat3.car.dto.members.MemberUpdateRequest;
import dat3.car.repository.MemberRepository;
import dat3.car.sla.members.IMemberFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Members {
    public Members(IMemberFactory factory, MemberUpdate update, MemberRepository repository, IHttpResult<String> response) {
        _factory = factory;
        _update = update;
        _repository = repository;
        _result = response;
    }

    public ResponseEntity<String> all()
    {
        var members = _repository.findAll();
        var response = members.stream().filter(m -> !m.getRole().equals("ADMIN")).map(_factory::toFetchResponse).toList();
        return _result.ok(response);
    }

    public ResponseEntity<String> get(String id)
    {
        var member = _repository.findById(id);
        if(member.isEmpty())
            return _result.notFound();
        return _result.ok(member.get());
    }
    public ResponseEntity<String> add(MemberAddRequest request)
    {
        var member = _factory.fromAddRequest(request);
        try {
            _repository.save(member);
        } catch (Exception e){
            return _result.badRequest(e.getMessage());
        }
        return _result.created(member);
    }

    public ResponseEntity<String> remove(String id)
    {
        try {
            var member = _repository.findById(id).orElse(null);
            if(member == null)
                return _result.notFound("No member with given id found");
            _repository.deleteById(id);
        } catch (Exception e){
            return _result.badRequest("Failed to remove resource");
        }
        return _result.ok();
    }

    public ResponseEntity<String> update(MemberUpdateRequest contactDetails)
    {
        var member = _repository.findById(contactDetails.getId()).orElse(null);
        if(member == null)
            return _result.notFound();
        var updated = _update.update(contactDetails,member);
        try {
            _repository.save(updated);
        } catch (Exception e){
            return _result.notUpdated();
        }
        return _result.ok();
    }

    private final IMemberFactory _factory;
    private final MemberUpdate _update;
    private final MemberRepository _repository;
    private final IHttpResult<String> _result;
}
