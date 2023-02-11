package dat3.car.Entities.members;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "member")
public class MemberCompleteDetails extends Member {
    public MemberCompleteDetails(String username, String email, String password) {
        super(username, email, password);
    }

    public MemberCompleteDetails() {
    }

    @CreationTimestamp
    protected LocalDateTime created;

    @UpdateTimestamp
    protected LocalDateTime lastEdited;
}
