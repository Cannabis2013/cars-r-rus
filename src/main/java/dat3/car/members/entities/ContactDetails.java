package dat3.car.members.entities;

import dat3.car.shared.entities.EntityModel;
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
    private Member member;

    @ElementCollection
    @MapKeyColumn(name = "description")
    @Column(name = "phone_number")
    private Map<String,String> phones = new HashMap<>();

    private String email;
}
