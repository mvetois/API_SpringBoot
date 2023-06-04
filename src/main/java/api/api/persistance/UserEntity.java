package api.api.persistance;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users", schema = "APP")
public class UserEntity {
    @Id
    private Integer id;
    private String name;
    private String email;

    @Override
    public String toString() {
        return ("{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}');
    }
}
