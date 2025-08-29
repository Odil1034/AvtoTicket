package uz.pdp.AvtoTicket.entity.permission;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.AvtoTicket.entity.BaseEntity;
import uz.pdp.AvtoTicket.enums.permission.Action;
import uz.pdp.AvtoTicket.enums.permission.EntityType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "permissions")
public class Permission extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Action action;

    @Enumerated(EnumType.STRING)
    private EntityType entity;

    private String description;

}
