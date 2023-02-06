package dat3.car.factories.members;

import dat3.car.Entities.members.Member;
import dat3.car.dto.members.MemberRequest;
import dat3.car.dto.members.MemberResponse;
import org.springframework.stereotype.Service;

@Service
public class MemberFactory {
    public MemberFactory(MemberConverter converter, MemberUpdater updater) {
        _converter = converter;
        _updater = updater;
    }

    public Member fromRequest(MemberRequest request)
    {
        return _converter.fromRequest(request);
    }

    public MemberResponse toResponse(Member member)
    {
        return _converter.toResponse(member);
    }

    public Member fromUpdateRequest(MemberRequest request, Member member)
    {
        return _updater.updateDetails(request,member);
    }

    private final MemberConverter _converter;
    private final MemberUpdater _updater;
}
