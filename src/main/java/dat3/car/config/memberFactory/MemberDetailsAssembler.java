package dat3.car.config.memberFactory;

import dat3.car.Entities.members.AddressDetails;
import dat3.car.Entities.members.PersonalDetails;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MemberDetailsAssembler {
    static List<String> assembleColors(String... colors){
        return Arrays.stream(colors).toList();
    }
    static AddressDetails assembleAddress(String street, String zip, String city, Map<String,String> phones)
    {
        return new AddressDetails(){
            {
                setStreet(street);
                setZip(zip);
                setCity(city);
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
