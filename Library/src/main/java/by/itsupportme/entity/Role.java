package by.itsupportme.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends BaseEntity implements GrantedAuthority {

    public static final String ROLE_READER_CODE = "ROLE_READER";

    public static final String ROLE_LIBRARIAN_CODE = "ROLE_LIBRARIAN";

    @Column(name = "name", length = 20)
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> users = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return getName().toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(name, role.name);
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
