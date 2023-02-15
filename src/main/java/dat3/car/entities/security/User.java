package dat3.car.entities.security;

import dat3.car.entities.base.EntityModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class User extends EntityModel {

    @Column(unique = true)
    protected String username;
    @Column(nullable = false,columnDefinition = "varchar(255)  default '1234'")
    protected String password;
    protected String role;
    protected boolean enabled;
}