package dat3.car.config.dbInit.members;

import dat3.car.members.entities.Member;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

import static dat3.car.config.dbInit.members.MemberDetailsAssembler.*;

@Service
public class ConfigPredefinedMembers {
    public Member mh2012()
    {
        var member = new Member("MH2012",_encoder.encode("Elmer2012"));
        member.setRoles(new ArrayList<>(){{add("USER");}});
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
        var member = new Member("LoneLiderlig1964", _encoder.encode("SexMedDyrErOk"));
        member.setRoles(new ArrayList<>(){{add("USER");}});
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
        var member = new Member("BikerJens",_encoder.encode("HarleyRytteren"));
        member.setRoles(new ArrayList<>(){{add("USER");}});
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

    public Member chernobog(){
        var user = new Member();
        user.setUsername("Chernobog");
        user.setPassword(_encoder.encode("xrpuofni"));
        user.setRoles(new ArrayList<>(){{add("ADMIN");}});
        return user;
    }
    private final BCryptPasswordEncoder _encoder = new BCryptPasswordEncoder();
}
