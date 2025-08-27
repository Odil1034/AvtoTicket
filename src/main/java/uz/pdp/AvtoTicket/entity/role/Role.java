package uz.pdp.AvtoTicket.entity.role;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.AvtoTicket.entity.BaseEntity;
import uz.pdp.AvtoTicket.entity.permission.Permission;
import uz.pdp.AvtoTicket.entity.user.User;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

//    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions = new HashSet<>();

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

}
