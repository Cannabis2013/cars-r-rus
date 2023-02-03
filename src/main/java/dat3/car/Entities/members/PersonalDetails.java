package dat3.car.Entities.members;

import dat3.car.Entities.EntityModel;
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
