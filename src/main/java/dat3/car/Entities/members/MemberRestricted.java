package dat3.car.Entities.members;

import dat3.car.Entities.base.EntityModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@Getter
@Setter
public class MemberRestricted extends EntityModel {
    public MemberRestricted(String username) {
        this.username = username;
    }

    public MemberRestricted() {
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    protected ContactDetails contactDetails = new ContactDetails();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_id",referencedColumnName = "id")
    protected PersonalDetails personalDetails = new PersonalDetails();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    protected AddressDetails addressDetails = new AddressDetails();

    @ElementCollection
    @JoinColumn(name = "member_favorite_color",referencedColumnName = "member_id")
    protected final List<String> favoriteColors = new ArrayList<>();
    @Column(unique = true)
    private String username;
}
