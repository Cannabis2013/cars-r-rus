package dat3.car.entities.members;

import dat3.car.entities.base.EntityModel;
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
public class Member extends EntityModel {
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
    @Column(unique = true)
    private String username;

    private int ranking;

    @Column(nullable = false,columnDefinition = "varchar(255)  default '1234'")
    private String password;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime lastEdited;
}
