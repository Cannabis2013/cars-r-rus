package dat3.car.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.lang.annotation.Inherited;
import java.time.LocalDateTime;

@MappedSuperclass
public class EntityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    protected String id;

    @CreationTimestamp
    protected LocalDateTime created;

    @UpdateTimestamp
    protected LocalDateTime lastEdited;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
