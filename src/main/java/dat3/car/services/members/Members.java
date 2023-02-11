package dat3.car.services.members;

import dat3.car.Entities.members.Member;
import dat3.car.SLA.Http.HttpResult;
import dat3.car.dto.members.MemberRequest;
import dat3.car.factories.members.MemberFactory;
import dat3.car.repository.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Members {
    public Members(MemberFactory factory, MemberRepository repository, HttpResult<String> response) {
        _factory = factory;
        _repository = repository;
        _response = response;
    }

    public ResponseEntity<String> all()
    {
        var memberDetails = _repository.findAll();
        var members = memberDetails.stream().map(m -> (Member) m).toList();
        return _response.ok(members);
    }

    public ResponseEntity<String> get(String id)
    {
        var member = _repository.findById(id);
        return member.isPresent()  ? _response.ok((Member) member.get()) : _response.notFound();
    }
    public ResponseEntity<String> add(MemberRequest request)
    {
        var member = _factory.fromRequest(request);
        try {
            _repository.save(member);
        } catch (Exception e){
            return _response.bad(e.getMessage());
        }
        return _response.created(member);
    }

    public ResponseEntity<String> remove(String id)
    {
        try {
            _repository.deleteById(id);
        } catch (Exception e){
            return _response.bad("Failed to remove resource");
        }
        return _response.ok();
    }

    public ResponseEntity<String> update(MemberRequest request)
    {
        var optional = _repository.findById(request.getMemberId());
        if(optional.isEmpty())
            return _response.notFound();
        var updatedMember = _factory.fromUpdateRequest(request,optional.get());
        try {
            _repository.deleteById(request.getMemberId());
            _repository.save(updatedMember);
        } catch (Exception e){
            return _response.notUpdated();
        }
        return _response.ok();
    }

    private final MemberFactory _factory;
    private final MemberRepository _repository;
    private final HttpResult<String> _response;
}
