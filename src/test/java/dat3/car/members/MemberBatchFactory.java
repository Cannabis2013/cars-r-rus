package dat3.car.members;

import dat3.car.Entities.members.MemberCompleteDetails;
import dat3.car.Entities.members.PersonalDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberBatchFactory {
    public List<MemberCompleteDetails> batch()
    {
        var members = new ArrayList<MemberCompleteDetails>() {
            {
                add(new MemberCompleteDetails("MH2012", "MH2012@outlook.dk", "xrpuofni"));
                add(new MemberCompleteDetails("Biker_Jens_1983", "Biker@gmail.com", "1234"));
                add(new MemberCompleteDetails("Lider_Lone", "SwingerLone@outlook.dk", "SexMedDyrErOk"));
            }
        };
        updateWithFavoriteColors(members);
        updateWithPhoneNumbers(members);
        updateWithPersonalDetails(members);
        return members;
    }

    private void updateWithFavoriteColors(List<MemberCompleteDetails> members){
        members.get(0).getFavoriteColors().add("red");
        members.get(0).getFavoriteColors().add("blue");
        members.get(1).getFavoriteColors().add("purple");
        members.get(2).getFavoriteColors().add("magenta");
        members.get(2).getFavoriteColors().add("black");
        members.get(2).getFavoriteColors().add("gray");
    }

    private void updateWithPhoneNumbers(List<MemberCompleteDetails> members)
    {
        members.get(0).getAddressDetails().getPhones().put("Mobile","31165870");
        members.get(0).getAddressDetails().getPhones().put("Work","32519881");
    }

    private void updateWithPersonalDetails(List<MemberCompleteDetails> members)
    {
        members.get(0).setPersonalDetails(new PersonalDetails("Martin","Hansen"));
        members.get(1).setPersonalDetails(new PersonalDetails("Jens","Peter"));
        members.get(2).setPersonalDetails(new PersonalDetails("Lone","Liderlig"));
    }
}
