package dat3.car.members;

import dat3.car.entities.members.Member;
import dat3.car.members.builders.TESTMemberBatchFactory;
import dat3.car.repository.IMemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collections;

public class MembersDbInitializor {

    public MembersDbInitializor() {
        _batchFactory = new TESTMemberBatchFactory();
    }

    public void init(IMemberRepository repository){
        var members = _batchFactory.batch();
        repository.saveAll(members);
    }

    public void clear(IMemberRepository repository){
        repository.deleteAll();
    }

    public Member randomMember()
    {
        var members = _batchFactory.batch();
        Collections.shuffle(members);
        return members.get(0);
    }

    public Member randomMember(JpaRepository<Member,String> repository){
        var members = repository.findAll();
        Collections.shuffle(members);
        return members.get(0);
    }

    private final TESTMemberBatchFactory _batchFactory;
}
