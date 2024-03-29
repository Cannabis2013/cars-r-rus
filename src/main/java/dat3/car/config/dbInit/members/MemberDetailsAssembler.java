package dat3.car.config.dbInit.members;

import dat3.car.members.entities.AddressDetails;
import dat3.car.members.entities.ContactDetails;
import dat3.car.members.entities.PersonalDetails;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MemberDetailsAssembler {
    static List<String> assembleColors(String... colors){
        return Arrays.stream(colors).toList();
    }
    static AddressDetails assembleAddress(String street, String zip, String city)
    {
        return new AddressDetails(){
            {
                setStreet(street);
                setZip(zip);
                setCity(city);
            }
        };
    }

    static ContactDetails assembleContactDetails(String email,Map<String,String> phones)
    {
        return new ContactDetails(){
            {
                setEmail(email);
                setPhones(phones);
            }
        };
    }

    static PersonalDetails assemblePersonalDetails(String firstName, String lastName)
    {
        return new PersonalDetails(){
            {
                setFirstName(firstName);
                setLastName(lastName);
            }
        };
    }
}
