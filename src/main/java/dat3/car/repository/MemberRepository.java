package dat3.car.repository;

import dat3.car.Entities.members.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member,String> {
}
