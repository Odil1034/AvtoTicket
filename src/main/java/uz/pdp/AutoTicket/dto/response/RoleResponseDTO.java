package uz.pdp.AutoTicket.dto.response;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.AutoTicket.dto.marker.Response;
import uz.pdp.AutoTicket.entity.Permission;

@Getter
@Setter
public class RoleResponseDTO implements Response {
    Long id;
    String name;
    Set<String> permissions;

    public RoleResponseDTO(Long id, String name, Set<Permission> permissions) {
        this.id = id;
        this.name = name;
        for (Permission p : permissions) {
            this.permissions.add(p.getAccess());
        }
    }
}
