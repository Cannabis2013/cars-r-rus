package dat3.car.members.builders;

import dat3.car.Entities.members.MemberUnrestricted;
import dat3.car.Entities.members.PersonalDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TESTMemberBatchFactory {
    public TESTMemberBatchFactory() {
        _builder = new MemberTestBuilder();
    }

    public List<MemberUnrestricted> batch()
    {
        var members = new ArrayList<MemberUnrestricted>() {
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
