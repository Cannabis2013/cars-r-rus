package dat3.car.contracts.members;

import dat3.car.dto.members.MemberAddRequest;
import dat3.car.dto.members.MemberResponse;
import dat3.car.entities.members.Member;

public interface IMemberFactory {
    Member fromAddRequest(MemberAddRequest addRequest);

    MemberResponse toFetchResponse(Member member);
}
