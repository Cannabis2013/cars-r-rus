package dat3.car.entities.members;

import dat3.car.entities.base.EntityModel;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class PersonalDetails extends EntityModel {
    public PersonalDetails(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonalDetails() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @OneToOne(mappedBy = "personalDetails")
    private Member member;

    private String firstName;
    private String lastName;
}
