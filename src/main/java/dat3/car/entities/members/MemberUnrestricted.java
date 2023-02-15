package dat3.car.entities.members;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "member")
public class MemberUnrestricted extends MemberRestricted {
    public MemberUnrestricted(String username, String password) {
        super(username);
        this.password = password;
    }

    public MemberUnrestricted() {
    }

    private int ranking;

    @Column(nullable = false,columnDefinition = "varchar(255)  default '1234'")
    private String password;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime lastEdited;
}
