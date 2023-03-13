package dat3.car.members.builders;

import dat3.car.members.entities.Member;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class MemberTestBuilder {
    public Member carlosZeca()
    {
        var member = new Member("Sega_Megadrive","FCKZeca");
        updatePersonalDetails(member,"Carlos","Zeca");
        updateAddressDetails(member,"Østerbrogade 23","København","2200");
        member.getFavoriteColors().add("white");
        member.getFavoriteColors().add("blue");
        member.getContactDetails().setEmail("segaFCK2gmail.com");
        return member;
    }

    public Member rasmusFalk()
    {
        var member = new Member("Falken","ParkenIsGreat");
        updatePersonalDetails(member,"Rasmus","Falk");
        updateAddressDetails(member,"Falkonér Alle 23","Frederiksberg","2100");
        member.getFavoriteColors().add("white");
        member.getFavoriteColors().add("blue");
        member.getContactDetails().setEmail("falk@gmail.com");
        return member;
    }

    public Member LiderLone()
    {
        var member = new Member("LoneLiderlig1965","SexMedDyrErOk");
        updatePersonalDetails(member,"Lone","Frandsen");
        updateAddressDetails(member,"Øresundsvej 26B 3.th","Sundby","2300S");
        member.getContactDetails().setEmail("Lider_Lone@yahoo.dk");
        member.getContactDetails().setPhones(new HashMap<String,String>(){
            {
                put("Home","23432321");
                put("Swinger linjen", "43123243");
            }
        });
        member.getFavoriteColors().add("purple");
        member.getFavoriteColors().add("green");
        return member;
    }

    public Member bikerJens()
    {
        var member = new Member("HarleyRytteren","incorrect");
        updatePersonalDetails(member,"Jens","Romundstad");
        updateAddressDetails(member,"Halsøvej 23","Roskilde","4000");
        member.getContactDetails().setEmail("harley_rytteren@outlook.dk");
        member.getContactDetails().setPhones(new HashMap<>() {
            {
                put("Home", "54235423");
                put("work", "43231234");
            }
        });
        member.getFavoriteColors().add("black");
        member.getFavoriteColors().add("yellow");
        return member;
    }

    public Member mh2012(){
        var member = new Member("MH2012","xrpuofni");
        updatePersonalDetails(member,"Martin","Hansen");
        updateAddressDetails(member,"Hyben Alle 56 1.MF","Kastrup","2770");
        member.getContactDetails().setEmail("MH2012@outlook.dk");
        member.getContactDetails().setPhones(new HashMap<>() {
            {
                put("Home", "31165870");
            }
        });
        member.getFavoriteColors().add("white");
        member.getFavoriteColors().add("blue");
        return member;
    }

    private void updatePersonalDetails(Member member, String firstName, String lastName){
        member.getPersonalDetails().setFirstName(firstName);
        member.getPersonalDetails().setLastName(lastName);
    }

    private void updateAddressDetails(Member member, String street, String city, String zip)
    {
        member.getAddressDetails().setStreet(street);
        member.getAddressDetails().setZip(zip);
        member.getAddressDetails().setCity(city);
    }
}
