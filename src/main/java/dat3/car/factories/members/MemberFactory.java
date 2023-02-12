package dat3.car.factories.members;

import dat3.car.Entities.members.MemberUnrestricted;
import dat3.car.Entities.members.MemberRestricted;
import org.springframework.stereotype.Service;

@Service
public class MemberFactory {
    public MemberUnrestricted toUnrestricted(MemberRestricted member){
        var unrestricted = new MemberUnrestricted();
        unrestricted.setUsername(member.getUsername());
        unrestricted.setContactDetails(member.getContactDetails());
        unrestricted.setAddressDetails(member.getAddressDetails());
        unrestricted.setPersonalDetails(member.getPersonalDetails());
        return unrestricted;
    }

    public MemberUnrestricted toUnrestricted(MemberRestricted member, MemberUnrestricted unrestricted){
        unrestricted.setUsername(member.getUsername());
        unrestricted.setContactDetails(member.getContactDetails());
        unrestricted.setAddressDetails(member.getAddressDetails());
        unrestricted.setPersonalDetails(member.getPersonalDetails());
        return unrestricted;
    }
    public MemberRestricted toRestricted(MemberUnrestricted unrestricted)
    {
        var restricted = new MemberRestricted();
        restricted.setUsername(unrestricted.getUsername());
        restricted.setContactDetails(unrestricted.getContactDetails());
        restricted.setPersonalDetails(unrestricted.getPersonalDetails());
        restricted.setAddressDetails(unrestricted.getAddressDetails());
        restricted.setId(unrestricted.getId());
        return restricted;
    }
}
