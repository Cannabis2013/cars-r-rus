package dat3.car.config.dbInit.members;

import dat3.car.members.entities.Member;
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
        return new ArrayList<Member>() {
            {
                add(_factory.mh2012());
                add(_factory.bikerJens());
                add(_factory.loneLiderlig());
                add(_factory.chernobog());
            }
        };
    }

    private final ConfigPredefinedMembers _factory;
}
