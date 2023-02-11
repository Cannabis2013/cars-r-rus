package dat3.car.config.memberFactory;

import dat3.car.Entities.members.MemberCompleteDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static dat3.car.config.memberFactory.MemberDetailsAssembler.*;

@Service
public class ConfigPredefinedMembers {
    public MemberCompleteDetails mh2012()
    {
        var member = new MemberCompleteDetails("MH2012","MH2012@outlook.dk","xrpuofni");
        var colors = assembleColors("white","blue");
        member.getFavoriteColors().addAll(colors);
        var phones = new HashMap<String,String>(){{put("Mobile","31165870");}};
        var address = assembleAddress("Hyben Alle 56 1.MF","2770","Kastrup",phones);
        var personal = assemblePersonalDetails("Martin","Hansen");
        member.setAddressDetails(address);
        member.setPersonalDetails(personal);
        return member;
    }

    public MemberCompleteDetails loneLiderlig(){
        var member = new MemberCompleteDetails("LoneLiderlig1964", "SwingerLone@outlook.dk", "SexMedDyrErOk");
        var colors = assembleColors("red","purple","black","green");
        member.getFavoriteColors().addAll(colors);
        var address = assembleAddress("Højdevej 110 (du ved, nede i kælderen)","2300S","Sundby",
                new HashMap<>(){{put("Mobile","23235454");put("Work","66666666");}});
        var personal = assemblePersonalDetails("Lone","Frandsen");
        member.setAddressDetails(address);
        member.setPersonalDetails(personal);
        return member;
    }

    public MemberCompleteDetails bikerJens(){
        var member = new MemberCompleteDetails("BikerJens","HogRidersAndShow@outlook.dk","HarleySucks");
        var colors = assembleColors("gray","black");
        member.getFavoriteColors().addAll(colors);
        var address = assembleAddress("Tjærevej 52","4000","Roskilde",
                new HashMap<>(){{put("Mobile","ukendt");}});
        var personal = assemblePersonalDetails("Jens","Hansen");
        member.setAddressDetails(address);
        member.setPersonalDetails(personal);
        return member;
    }
}
