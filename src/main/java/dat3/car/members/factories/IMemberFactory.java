package dat3.car.members.factories;

import dat3.car.members.dtos.MemberAddRequest;
import dat3.car.members.dtos.MemberResponse;
import dat3.car.members.entities.Member;

public interface IMemberFactory {
    Member fromAddRequest(MemberAddRequest addRequest);

    MemberResponse toFetchResponse(Member member);
}
