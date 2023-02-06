package dat3.car.Entities.members;

import dat3.car.Entities.EntityModel;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.MapKeyColumn;
import java.util.HashMap;
import java.util.Map;

@Entity
public class AddressDetails extends EntityModel {
    public AddressDetails(String street, String city, String zip) {
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public AddressDetails() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhones(Map<String, String> phones) {
        this.phones = phones;
    }

    public Map<String, String> getPhones() {
        return phones;
    }

    @ElementCollection
    @MapKeyColumn(name = "description")
    @Column(name = "phone_number")
    private Map<String,String> phones = new HashMap<>();

    private String street;
    private String city;
    private String zip;
}
