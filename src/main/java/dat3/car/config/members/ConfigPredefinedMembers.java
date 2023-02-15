package dat3.car.config.members;

import dat3.car.entities.members.Member;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static dat3.car.config.members.MemberDetailsAssembler.*;

@Service
public class ConfigPredefinedMembers {
    public Member mh2012()
    {
        var member = new Member("MH2012","xrpuofni");
        var colors = assembleColors("white","blue");
        member.getFavoriteColors().addAll(colors);
        var address = assembleAddress("Hyben Alle 56 1.MF","2770","Kastrup");
        var personal = assemblePersonalDetails("Martin","Hansen");
        var phones = new HashMap<String,String>(){{put("Mobile","31165870");}};
        var contact = assembleContactDetails("MH2012@outlook.dk",phones);
        member.setContactDetails(contact);
        member.setAddressDetails(address);
        member.setPersonalDetails(personal);
        return member;
    }

    public Member loneLiderlig(){
        var member = new Member("LoneLiderlig1964", "SexMedDyrErOk");
        var colors = assembleColors("red","purple","black","green");
        member.getFavoriteColors().addAll(colors);
        var address = assembleAddress("Højdevej 110 (du ved, nede i kælderen)","2300S","Sundby");
        var personal = assemblePersonalDetails("Lone","Frandsen");
        var phones = new HashMap<String,String>(){{put("Mobile","23235454");put("Work","66666666");}};
        var contact = assembleContactDetails("Lider_Lone1965@outlook.dk",phones);
        member.setContactDetails(contact);
        member.setAddressDetails(address);
        member.setPersonalDetails(personal);
        return member;
    }

    public Member bikerJens(){
        var member = new Member("BikerJens","HarleySucks");
        var colors = assembleColors("gray","black");
        member.getFavoriteColors().addAll(colors);
        var address = assembleAddress("Tjærevej 52","4000","Roskilde");
        var personal = assemblePersonalDetails("Jens","Hansen");
        var contact = assembleContactDetails("bikerjens@outlook.dk",new HashMap<>(){
            {
                put("Mobile","23235454");put("Work","66666666");
            }
        });
        member.setContactDetails(contact);
        member.setAddressDetails(address);
        member.setPersonalDetails(personal);
        return member;
    }
}
