package dat3.car.members;

import dat3.car.Entities.members.MemberRestricted;
import dat3.car.members.builders.TESTMemberBatchFactory;
import dat3.car.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MembersDbInitializor {

    public MembersDbInitializor(MemberRepository repository, TESTMemberBatchFactory batchFactory) {
        _repository = repository;
        _batchFactory = batchFactory;
    }

    public void init(){
        System.out.println("Init run");
        var members = _batchFactory.batch();
        _repository.saveAll(members);
    }

    public void clear(){
        System.out.println("Clear run");
        _repository.deleteAll();
    }

    public MemberRestricted randomMember()
    {
        var members = _batchFactory.batch();
        Collections.shuffle(members);
        return members.get(0);
    }

    private final MemberRepository _repository;
    private final TESTMemberBatchFactory _batchFactory;
}
