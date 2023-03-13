package dat3.car.members.builders;

import dat3.car.members.entities.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TESTMemberBatchFactory {
    public TESTMemberBatchFactory() {
        _builder = new MemberTestBuilder();
    }

    public List<Member> batch()
    {
        var members = new ArrayList<Member>() {
            {
                add(_builder.mh2012());
                add(_builder.bikerJens());
                add(_builder.LiderLone());
            }
        };
        return members;
    }

    private final MemberTestBuilder _builder;
}
