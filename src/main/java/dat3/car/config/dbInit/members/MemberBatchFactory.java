package dat3.car.config.dbInit.members;

import dat3.car.entities.members.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberBatchFactory {
    public MemberBatchFactory(ConfigPredefinedMembers factory) {
        _factory = factory;
    }

    public List<Member> batch()
    {
        var members = new ArrayList<Member>() {
            {
                add(_factory.mh2012());
                add(_factory.bikerJens());
                add(_factory.loneLiderlig());
            }
        };
        return members;
    }

    private final ConfigPredefinedMembers _factory;
}
