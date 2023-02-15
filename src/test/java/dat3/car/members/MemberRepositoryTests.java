package dat3.car.members;

import dat3.car.members.builders.MemberTestBuilder;
import dat3.car.repository.MemberRepository;
import org.junit.jupiter.api.*;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class MemberRepositoryTests {

    @BeforeEach
    public void init(){
        _initializor.init(_repository);
    }

    @AfterEach
    public void cleanUp()
    {
        _initializor.clear(_repository);
    }

    @Test
    public void addMemberToDatabase(){
        var member = _builder.rasmusFalk();
        var saved = assertDoesNotThrow(() -> _repository.save(member));
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

    @Test
    public void updateMemberFromDatabase()
    {
        var zeca = _builder.carlosZeca();
        var fromMemory = _initializor.randomMember(); // Get a random member from memory
        var fromDb = _repository.findByUsernameLike(fromMemory.getUsername()).orElseThrow(AssertionFailedError::new); // Get the equivalent member from database
        fromDb.getPersonalDetails().setFirstName(zeca.getPersonalDetails().getFirstName());
        fromDb.getPersonalDetails().setLastName(zeca.getPersonalDetails().getLastName());
        var saved = _repository.save(fromDb);
        var updatedFromDb = _repository.findById(saved.getId()).orElseThrow(AssertionFailedError::new);
        assertEquals(zeca.getPersonalDetails().getFirstName(),updatedFromDb.getPersonalDetails().getFirstName());
        assertEquals(zeca.getPersonalDetails().getLastName(),updatedFromDb.getPersonalDetails().getLastName());
    }

    @Autowired
    private MemberRepository _repository;

    private final MembersDbInitializor _initializor = new MembersDbInitializor();

    private final MemberTestBuilder _builder = new MemberTestBuilder();
}
