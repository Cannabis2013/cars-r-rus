package dat3.car.members.repositories;

import dat3.car.members.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMemberRepository extends JpaRepository<Member,String> {
    Optional<Member> findByUsernameLike(String username);
}
