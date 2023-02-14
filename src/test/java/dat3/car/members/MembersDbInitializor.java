package dat3.car.members;

import dat3.car.Entities.members.MemberRestricted;
import dat3.car.members.builders.MemberTestBuilder;
import dat3.car.members.builders.TESTMemberBatchFactory;
import dat3.car.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.stereotype.Service;

import java.util.Collections;

public class MembersDbInitializor {

    public MembersDbInitializor() {
        _batchFactory = new TESTMemberBatchFactory();
    }

    public void init(MemberRepository repository){
        var members = _batchFactory.batch();
        repository.saveAll(members);
    }

    public void clear(MemberRepository repository){
        repository.deleteAll();
    }

    public MemberRestricted randomMember()
    {
        var members = _batchFactory.batch();
        Collections.shuffle(members);
        return members.get(0);
    }

    private final TESTMemberBatchFactory _batchFactory;
}
