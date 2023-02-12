package dat3.car.members;

import dat3.car.Entities.members.MemberUnrestricted;
import dat3.car.Entities.members.MemberRestricted;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberTestBuilder {
    public MemberUnrestricted carlosZeca()
    {
        var member = new MemberUnrestricted("Sega_Megadrive","FCKZeca");
        updatePersonalDetails(member,"Carlos","Zeca");
        updateAddressDetails(member,"Østerbrogade 23","København","2200");
        member.getContactDetails().setEmail("segaFCK2gmail.com");
        return member;
    }

    public MemberUnrestricted rasmusFalk()
    {
        var member = new MemberUnrestricted("Falken","ParkenIsGreat");
        updatePersonalDetails(member,"Rasmus","Falk");
        updateAddressDetails(member,"Falkonér Alle 23","Frederiksberg","2100");
        member.getContactDetails().setEmail("falk@gmail.com");
        return member;
    }

    private void updatePersonalDetails(MemberRestricted member, String firstName, String lastName){
        member.getPersonalDetails().setFirstName(firstName);
        member.getPersonalDetails().setLastName(lastName);
    }

    private void updateAddressDetails(MemberRestricted member, String street, String city, String zip)
    {
        member.getAddressDetails().setStreet(street);
        member.getAddressDetails().setZip(zip);
        member.getAddressDetails().setCity(city);
    }
}
