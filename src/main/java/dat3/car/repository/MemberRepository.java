package dat3.car.repository;

import dat3.car.Entities.members.MemberCompleteDetails;
import dat3.car.Entities.members.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberCompleteDetails,String> {
    @Transactional
    @Modifying
    @Query("update MemberCompleteDetails m set m.personalDetails = ?1 where m.id like ?2")
    int updatePersonalDetailsByIdLike(PersonalDetails personalDetails, String id);
    Optional<MemberCompleteDetails> findByUsernameLike(String username);
}
