package dat3.car.config.memberFactory;

import dat3.car.Entities.members.MemberCompleteDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberBatchFactory {
    public MemberBatchFactory(ConfigPredefinedMembers factory) {
        _factory = factory;
    }

    public List<MemberCompleteDetails> batch()
    {
        var members = new ArrayList<MemberCompleteDetails>() {
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
