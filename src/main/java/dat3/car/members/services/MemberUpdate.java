package dat3.car.members.services;

import dat3.car.members.dtos.MemberUpdateRequest;
import dat3.car.members.entities.AddressDetails;
import dat3.car.members.entities.ContactDetails;
import dat3.car.members.entities.Member;
import dat3.car.members.entities.PersonalDetails;
import org.springframework.stereotype.Service;

@Service
public class MemberUpdate {
    public Member update(MemberUpdateRequest updateDetails, Member member)
    {
        updateCredentials(updateDetails,member);
        updatePersonalDetails(updateDetails,member.getPersonalDetails());
        updateAddressDetails(updateDetails,member.getAddressDetails());
        updateContactDetails(updateDetails,member.getContactDetails());
        return null;
    }

    private void updateCredentials(MemberUpdateRequest updateDetails, Member member){
        if(updateDetails.getUsername() != null)
            member.setUsername(updateDetails.getUsername());
    }

    private void updateContactDetails(MemberUpdateRequest updateDetails, ContactDetails details)
    {
        if(updateDetails.getPhones() != null)
            details.setPhones(updateDetails.getPhones());
        if(updateDetails.getEmail() != null)
            details.setEmail(updateDetails.getEmail());
    }

    private void updatePersonalDetails(MemberUpdateRequest updateDetails, PersonalDetails details)
    {
        if(updateDetails.getFirstName() != null)
            details.setFirstName(updateDetails.getFirstName());
        if(updateDetails.getLastName() != null)
            details.setLastName(updateDetails.getLastName());
    }

    private void updateAddressDetails(MemberUpdateRequest updateDetails, AddressDetails details)
    {
        if(updateDetails.getStreet() != null)
            details.setStreet(updateDetails.getStreet());
        if(updateDetails.getZip() != null)
            details.setZip(updateDetails.getZip());
        if(updateDetails.getCity() != null)
            details.setCity(updateDetails.getCity());
    }
}
