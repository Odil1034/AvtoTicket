package uz.pdp.AvtoTicket.entity.permission;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.AvtoTicket.entity.BaseEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "permissions")
public class Permission extends BaseEntity {

    @Column(name = "permission_name", unique = true, nullable = false)
    private String name;

//    private String description;

}
