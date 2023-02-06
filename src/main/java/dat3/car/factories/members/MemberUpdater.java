package dat3.car.factories.members;

import dat3.car.Entities.members.Member;
import dat3.car.dto.members.MemberRequest;
import org.springframework.stereotype.Service;

@Service
public class MemberUpdater {
    Member updateDetails(MemberRequest request, Member member)
    {
        updateUserDetails(request,member);
        updatePersonalDetails(request,member);
        updateAddressDetails(request,member);
        return member;
    }

    private void updateUserDetails(MemberRequest request, Member member)
    {
        if(!request.getPassword().isEmpty())
            member.setPassword(request.getPassword());
        member.setUsername(request.getUsername());
        member.setEmail(request.getEmail());
    }

    private void updatePersonalDetails(MemberRequest request, Member member)
    {
        member.getPersonalDetails().setFirstName(request.getFirstName());
        member.getPersonalDetails().setLastName(request.getLastName());
    }

    private void updateAddressDetails(MemberRequest request, Member member)
    {
        member.getAddressDetails().setPhones(request.getPhones());
        member.getAddressDetails().setStreet(request.getStreet());
        member.getAddressDetails().setCity(request.getCity());
        member.getAddressDetails().setZip(request.getZip());
    }
}
