package dat3.car.Entities.members;

import dat3.car.Entities.EntityModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "member")
public class Member extends EntityModel {
    public Member(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Member() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AddressDetails getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(AddressDetails details)
    {
        addressDetails = details;
    }

    public List<String> getFavoriteColors() {
        return favoriteColors;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

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

    @Column(unique = true)
    private String email;

    @Column(nullable = false,columnDefinition = "varchar(255)  default '1234'")
    private String password;
}
