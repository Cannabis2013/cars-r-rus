package dat3.car.factories.members;

import dat3.car.Entities.members.AddressDetails;
import dat3.car.Entities.members.Member;
import dat3.car.Entities.members.PersonalDetails;
import dat3.car.dto.members.MemberRequest;
import dat3.car.dto.members.MemberResponse;
import org.springframework.stereotype.Service;

@Service
public class MemberConverter {
    Member fromRequest(MemberRequest request)
    {
        var member = new Member();
        member.setId(request.getMemberId());
        updateUserDetails(request,member);
        updateAddressDetails(request,member);
        return member;
    }

    MemberResponse toResponse(Member member)
    {
        var response = new MemberResponse();
        response.setMemberId(member.getId());
        updateUserDetails(response, member);
        updateAddressDetails(response, member);
        return response;
    }

    private void updateUserDetails(MemberResponse response, Member member)
    {
        response.setFirstName(member.getPersonalDetails().getFirstName());
        response.setLastName(member.getPersonalDetails().getLastName());
        response.setUsername(member.getUsername());
        response.setEmail(member.getEmail());
    }

    private void updateUserDetails(MemberRequest request, Member member)
    {
        var personalDetails = new PersonalDetails(request.getFirstName(),request.getLastName());
        member.setPassword(request.getPassword());
        member.setPersonalDetails(personalDetails);
        member.setUsername(member.getUsername());
        member.setEmail(member.getEmail());
    }

    private void updateAddressDetails(MemberResponse response, Member member)
    {
        response.setPhones(member.getAddressDetails().getPhones());
        response.setStreet(member.getAddressDetails().getStreet());
        response.setCity(member.getAddressDetails().getCity());
        response.setZip(member.getAddressDetails().getZip());
    }

    private void updateAddressDetails(MemberRequest response, Member member)
    {
        var addressDetails = new AddressDetails(response.getStreet(),response.getCity(),response.getZip());
        addressDetails.setPhones(response.getPhones());
        member.setAddressDetails(addressDetails);
        member.setAddressDetails(addressDetails);
    }
}
