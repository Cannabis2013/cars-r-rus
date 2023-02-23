package dat3.car.repository;

import dat3.car.entities.members.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMemberRepository extends JpaRepository<Member,String> {
    Optional<Member> findByUsernameLike(String username);
}
