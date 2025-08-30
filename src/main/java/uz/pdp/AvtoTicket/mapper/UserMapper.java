package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.*;
import uz.pdp.AvtoTicket.dto.response.UserDTO;
import uz.pdp.AvtoTicket.entity.role.Role;
import uz.pdp.AvtoTicket.entity.user.User;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper extends EntityMapper<UserDTO, User> {

    @Override
    @Mapping(source = "roles", target = "roles", qualifiedByName = "roleToName")
    User toEntity(UserDTO dto);

    @Override
    @Mapping(source = "roles", target = "roles", qualifiedByName = "roleToName")
    UserDTO toDto(User entity);

    @Override
    List<User> toEntity(List<UserDTO> list);

    @Override
    List<UserDTO> toDto(List<User> list);

    @Named("roleToName")
    default String roleToName(Role role) {
        return role == null ? null : role.getName();
    }

}