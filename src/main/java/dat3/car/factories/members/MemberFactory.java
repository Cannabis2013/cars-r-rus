package dat3.car.factories.members;

import dat3.car.dto.members.MemberAddRequest;
import dat3.car.dto.members.MemberResponse;
import dat3.car.entities.members.AddressDetails;
import dat3.car.entities.members.ContactDetails;
import dat3.car.entities.members.Member;
import dat3.car.entities.members.PersonalDetails;
import dat3.car.contracts.members.IMemberFactory;
import org.springframework.stereotype.Service;

@Service
public class MemberFactory implements IMemberFactory {
    @Override
    public Member fromAddRequest(MemberAddRequest addRequest){
        var member = new Member();
        updateCredentials(addRequest,member);
        updatePersonalDetails(addRequest,member.getPersonalDetails());
        updateAddressDetails(addRequest,member.getAddressDetails());
        updateContactDetails(addRequest,member.getContactDetails());
        return member;
    }

    @Override
    public MemberResponse toFetchResponse(Member member)
    {
        return MemberResponse.builder()
                .id(member.getId())
                .username(member.getUsername())
                .email(member.getContactDetails().getEmail())
                .phones(member.getContactDetails().getPhones())
                .firstName(member.getPersonalDetails().getFirstName())
                .lastName(member.getPersonalDetails().getLastName())
                .street(member.getAddressDetails().getStreet())
                .zip(member.getAddressDetails().getZip())
                .city(member.getAddressDetails().getCity())
                .build();
    }

    private void updateCredentials(MemberAddRequest addRequest, Member member){
        member.setUsername(addRequest.getUsername());
        member.setPassword(addRequest.getPassword());
    }

    private void updateContactDetails(MemberAddRequest addRequest, ContactDetails details)
    {
        details.setPhones(addRequest.getPhones());
        details.setEmail(addRequest.getEmail());

    }

    private void updatePersonalDetails(MemberAddRequest addRequest, PersonalDetails details)
    {
        details.setFirstName(addRequest.getFirstName());
        details.setLastName(addRequest.getLastName());
    }

    private void updateAddressDetails(MemberAddRequest addRequest, AddressDetails details)
    {
        details.setStreet(addRequest.getStreet());
        details.setZip(addRequest.getZip());
        details.setCity(addRequest.getCity());
    }
}
