package dat3.car.members;

import dat3.car.Entities.members.Member;
import dat3.car.Entities.members.PersonalDetails;
import dat3.car.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MembersInitializor {

    public MembersInitializor(MemberRepository repository) {
        _repository = repository;
    }

    public void init(){
        var members = _build();
        _repository.saveAll(members);
    }

    public void clear(){
        _repository.deleteAll();
    }

    private List<Member> _build()
    {
        var members = new ArrayList<Member>() {
            {
                add(new Member("MH2012", "MH2012@outlook.dk", "xrpuofni"));
                add(new Member("Biker_Jens_1983", "Biker@gmail.com", "1234"));
                add(new Member("Lider_Lone", "SwingerLone@outlook.dk", "SexMedDyrErOk"));
            }
        };
        updateWithFavoriteColors(members);
        updateWithPhoneNumbers(members);
        updateWithPersonalDetails(members);
        return members;
    }

    private void updateWithFavoriteColors(List<Member> members){
        members.get(0).getFavoriteColors().add("red");
        members.get(0).getFavoriteColors().add("blue");
        members.get(1).getFavoriteColors().add("purple");
        members.get(2).getFavoriteColors().add("magenta");
        members.get(2).getFavoriteColors().add("black");
        members.get(2).getFavoriteColors().add("gray");
    }

    private void updateWithPhoneNumbers(List<Member> members)
    {
        members.get(0).getAddressDetails().getPhones().put("Mobile","31165870");
        members.get(0).getAddressDetails().getPhones().put("Work","32519881");
    }

    private void updateWithPersonalDetails(List<Member> members)
    {
        members.get(0).setPersonalDetails(new PersonalDetails("Martin","Hansen"));
        members.get(1).setPersonalDetails(new PersonalDetails("Jens","Peter"));
        members.get(2).setPersonalDetails(new PersonalDetails("Lone","Liderlig"));
    }

    private final MemberRepository _repository;
}
