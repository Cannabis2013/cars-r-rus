package dat3.car.members;

import dat3.car.Entities.members.Member;
import dat3.car.Entities.members.PersonalDetails;
import dat3.car.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MembersDbInitializor {

    public MembersDbInitializor(MemberRepository repository, MemberBatchFactory batchFactory) {
        _repository = repository;
        _batchFactory = batchFactory;
    }

    public void init(){
        var members = _batchFactory.batch();
        _repository.saveAll(members);
    }

    public Member randomMember()
    {
        var members = _batchFactory.batch();
        Collections.shuffle(members);
        return members.get(0);
    }

    public void clear(){
        _repository.deleteAll();
    }

    private final MemberRepository _repository;
    private final MemberBatchFactory _batchFactory;
}
