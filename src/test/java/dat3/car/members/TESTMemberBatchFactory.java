package dat3.car.members;

import dat3.car.Entities.members.MemberUnrestricted;
import dat3.car.Entities.members.PersonalDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TESTMemberBatchFactory {
    public List<MemberUnrestricted> batch()
    {
        var members = new ArrayList<MemberUnrestricted>() {
            {
                add(new MemberUnrestricted("MH2012", "xrpuofni"));
                add(new MemberUnrestricted("Biker_Jens_1983", "1234"));
                add(new MemberUnrestricted("Lider_Lone", "SexMedDyrErOk"));
            }
        };
        updateWithFavoriteColors(members);
        updateWithPhoneNumbers(members);
        updateWithPersonalDetails(members);
        return members;
    }

    private void updateWithFavoriteColors(List<MemberUnrestricted> members){
        members.get(0).getFavoriteColors().add("red");
        members.get(0).getFavoriteColors().add("blue");
        members.get(1).getFavoriteColors().add("purple");
        members.get(2).getFavoriteColors().add("magenta");
        members.get(2).getFavoriteColors().add("black");
        members.get(2).getFavoriteColors().add("gray");
    }

    private void updateWithPhoneNumbers(List<MemberUnrestricted> members)
    {
        members.get(0).getContactDetails().getPhones().put("Mobile","31165870");
        members.get(0).getContactDetails().getPhones().put("Work","32519881");
    }

    private void updateWithPersonalDetails(List<MemberUnrestricted> members)
    {
        members.get(0).setPersonalDetails(new PersonalDetails("Martin","Hansen"));
        members.get(1).setPersonalDetails(new PersonalDetails("Jens","Peter"));
        members.get(2).setPersonalDetails(new PersonalDetails("Lone","Liderlig"));
    }
}
