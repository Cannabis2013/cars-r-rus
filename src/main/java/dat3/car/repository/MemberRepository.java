package dat3.car.repository;

import dat3.car.Entities.members.MemberUnrestricted;
import dat3.car.Entities.members.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberUnrestricted,String> {
    @Transactional
    @Modifying
    @Query("update MemberUnrestricted m set m.personalDetails = ?1 where m.id like ?2")
    int updatePersonalDetailsByIdLike(PersonalDetails personalDetails, String id);
    Optional<MemberUnrestricted> findByUsernameLike(String username);
}
