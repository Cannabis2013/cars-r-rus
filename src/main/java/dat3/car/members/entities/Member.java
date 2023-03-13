package dat3.car.members.entities;

import dat3.car.security.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "member")
public class Member extends User {
    public Member(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Member() {
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private ContactDetails contactDetails = new ContactDetails();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_id",referencedColumnName = "id")
    private PersonalDetails personalDetails = new PersonalDetails();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressDetails addressDetails = new AddressDetails();

    @ElementCollection
    @JoinColumn(name = "member_favorite_color",referencedColumnName = "member_id")
    private final List<String> favoriteColors = new ArrayList<>();

    private int ranking;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime lastEdited;
}
