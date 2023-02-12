package dat3.car.members;

import dat3.car.Entities.members.MemberRestricted;
import dat3.car.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MembersDbInitializor {

    public MembersDbInitializor(MemberRepository repository, TESTMemberBatchFactory batchFactory) {
        _repository = repository;
        _batchFactory = batchFactory;
    }

    public void init(){
        var members = _batchFactory.batch();
        _repository.saveAll(members);
    }

    public MemberRestricted randomMember()
    {
        var members = _batchFactory.batch();
        Collections.shuffle(members);
        return members.get(0);
    }

    public void clear(){
        _repository.deleteAll();
    }

    private final MemberRepository _repository;
    private final TESTMemberBatchFactory _batchFactory;
}
