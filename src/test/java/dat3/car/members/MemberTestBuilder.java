package dat3.car.members;

import dat3.car.Entities.members.Member;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MemberTestBuilder {
    public Member carlosZeca()
    {
        var member = new Member();
        updateUserDetails(member,"Sega_Megadrive","elmer1234","segaFCK2gmail.com");
        updatePersonalDetails(member,"Carlos","Zeca");
        updateAddressDetails(member,"Østerbrogade 23","København","2200");
        return member;
    }

    public Member rasmusFalk()
    {
        var member = new Member();
        updateUserDetails(member,"Falken","falk1234","falk2gmail.com");
        updatePersonalDetails(member,"Carlos","Zeca");
        updateAddressDetails(member,"Falkonér Alle 23","Frederiksberg","2100");
        return member;
    }

    private void updateUserDetails(Member member, String username, String password, String email)
    {
        member.setUsername(username);
        member.setPassword(password);
        member.setEmail(email);
    }

    private void updatePersonalDetails(Member member,String firstName, String lastName){
        member.getPersonalDetails().setFirstName(firstName);
        member.getPersonalDetails().setLastName(lastName);
    }

    private void updateAddressDetails(Member member, String street, String city, String zip)
    {
        member.getAddressDetails().setStreet(street);
        member.getAddressDetails().setZip(zip);
        member.getAddressDetails().setCity(city);
        var phones = new HashMap<String,String>(){
            {
                put("Home","12345678");
                put("Work","87654321");
            }
        };
        member.getAddressDetails().setPhones(phones);
    }
}
