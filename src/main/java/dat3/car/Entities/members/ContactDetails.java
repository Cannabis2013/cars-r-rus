package dat3.car.Entities.members;

import dat3.car.Entities.base.EntityModel;
import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
public class ContactDetails extends EntityModel {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhones(Map<String, String> phones) {
        this.phones = phones;
    }

    public Map<String, String> getPhones() {
        return phones;
    }

    @OneToOne(mappedBy = "contactDetails")
    private MemberUnrestricted member;

    @ElementCollection
    @MapKeyColumn(name = "description")
    @Column(name = "phone_number")
    private Map<String,String> phones = new HashMap<>();

    private String email;
}
