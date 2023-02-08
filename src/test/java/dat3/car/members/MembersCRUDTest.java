package dat3.car.members;

import dat3.car.Entities.members.Member;
import dat3.car.repository.MemberRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MembersCRUDTest {
    @Test
    @Order(1)
    public void addMemberToDatabase(){
        var member = _builder.carlosZeca();
        final Member[] saved = {null};
        assertDoesNotThrow(() -> saved[0] =  _repository.save(member));
        var subject = _repository.findById(saved[0].getId());
        assertEquals(subject.get().getId(), saved[0].getId());
    }

    @Test
    public void removeMemberFromRepository()
    {
        var member = _repository.findAll().stream().findFirst().orElseThrow(Assertions::fail);
        assertDoesNotThrow(() -> _repository.delete(member));
        var found = _repository.findById(member.getId());
        assertFalse(found.isPresent());
    }

    @Autowired
    private MemberRepository _repository;
    @Autowired
    private MemberTestBuilder _builder;
}
