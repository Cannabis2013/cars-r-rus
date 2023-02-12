package dat3.car.members;

import dat3.car.Entities.members.MemberRestricted;
import dat3.car.repository.MemberRepository;
import org.junit.jupiter.api.*;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MemberRepositoryTests {
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
        MemberRestricted saved = assertDoesNotThrow(() -> _repository.save(member));
    }
    @Test
    public void addMemberToDatabase(){
        var member = _builder.rasmusFalk();
        MemberRestricted saved = assertDoesNotThrow(() -> _repository.save(member));
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
        /*
            This is a lazy implementation and is due to a complex entity structure.

            Another implementation is needed as this may cause performance issues on a larger scale I assume
         */
        var zeca = _builder.carlosZeca();
        var fromMemory = _initializor.randomMember(); // Get a random member from memory
        var fromDb = _repository.findByUsernameLike(fromMemory.getUsername()).orElseThrow(AssertionFailedError::new); // Get the equivalent member from database
        fromDb.getPersonalDetails().setFirstName(zeca.getPersonalDetails().getFirstName());
        fromDb.getPersonalDetails().setLastName(zeca.getPersonalDetails().getLastName());
        _repository.delete(fromDb);
        MemberRestricted saved = _repository.save(fromDb);
        var updatedFromDb = _repository.findById(saved.getId()).orElseThrow(AssertionFailedError::new);
        assertEquals(zeca.getPersonalDetails().getFirstName(),updatedFromDb.getPersonalDetails().getFirstName());
        assertEquals(zeca.getPersonalDetails().getLastName(),updatedFromDb.getPersonalDetails().getLastName());
    }

    @Autowired
    private MemberRepository _repository;
    @Autowired
    private MembersDbInitializor _initializor;
    @Autowired
    private MemberTestBuilder _builder;
}
