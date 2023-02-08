package dat3.car.members;

import dat3.car.Entities.members.Member;
import dat3.car.repository.MemberRepository;
import org.junit.jupiter.api.*;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MembersCRUDTest {
    @BeforeEach
    public void init(){
        _initializor.init();
    }

    @AfterEach
    public void cleanUp()
    {
        _initializor.clear();
    }
    @BeforeEach
    public void setup()
    {
        var member = _builder.carlosZeca();
        Member saved = assertDoesNotThrow(() -> _repository.save(member));
    }
    @Test
    public void addMemberToDatabase(){
        var member = _builder.rasmusFalk();
        Member saved = assertDoesNotThrow(() -> _repository.save(member));
        var id = saved.getId();
        var subject = _repository.findById(id).orElseThrow(AssertionFailedError::new);
        assertEquals(subject.getId(), saved.getId());
    }

    @Test
    public void removeMemberFromRepository()
    {
        var member = _repository.findAll().stream().findFirst().orElseThrow(AssertionFailedError::new);
        assertDoesNotThrow(() -> _repository.delete(member));
        var found = _repository.findByUsernameLike(member.getUsername());
        assertFalse(found.isPresent());
    }

    @Autowired
    private MemberRepository _repository;
    @Autowired
    private MembersInitializor _initializor;
    @Autowired
    private MemberTestBuilder _builder;
}
