package dat3.car.members;

import dat3.car.Entities.members.Member;
import dat3.car.Entities.members.PersonalDetails;
import dat3.car.factories.members.MemberFactory;
import dat3.car.repository.MemberRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MembersCRUDTest {
    @Test
    @Order(1)
    public void addMemberToDatabase(){
        try {
        } catch (Exception e){

        }
    }

    private Member member()
    {
        var member = new Member();
        member.setUsername("Sega_Megadrive");
        member.getPersonalDetails().setFirstName("Carlos");
        member.getPersonalDetails().setLastName("Zeca");

    }

    @Autowired
    private MemberRepository _repository;
}
