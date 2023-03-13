package dat3.car.security.entities;

import dat3.car.shared.entities.EntityModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@MappedSuperclass
public class User extends EntityModel {

    @Column(unique = true)
    protected String username;
    @Column(nullable = false,columnDefinition = "varchar(255)  default '1234'")
    protected String password;
    @ElementCollection(fetch = FetchType.EAGER)
    protected List<String> roles;
    protected boolean enabled;
}