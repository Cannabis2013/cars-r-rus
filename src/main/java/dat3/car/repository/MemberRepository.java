package dat3.car.repository;

import dat3.car.Entities.members.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,String> {
    Optional<Member> findByUsernameLike(String username);
}
