package dat3.car.dto.members;

public final class MemberDto {
    public MemberDto(String username, String email, String phone, String street, String zip, String city) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    private final String username;
    private final String email;
    private final String phone;
    private final String street;
    private final String zip;
    private final String city;
}
