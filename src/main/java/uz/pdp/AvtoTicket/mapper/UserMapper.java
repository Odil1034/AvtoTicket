package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.*;
import uz.pdp.AvtoTicket.dto.auth.SignUpDTO;
import uz.pdp.AvtoTicket.dto.user.UserCreateDTO;
import uz.pdp.AvtoTicket.dto.user.UserResponseDTO;
import uz.pdp.AvtoTicket.dto.user.UserUpdateDTO;
import uz.pdp.AvtoTicket.entity.role.Role;
import uz.pdp.AvtoTicket.entity.user.User;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserCreateDTO dto);

    User toEntity(SignUpDTO dto);

    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRolesToNames")
    UserResponseDTO toDTO(User user);

    List<UserResponseDTO> toDTOList(List<User> user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toUpdate(@MappingTarget User user, UserUpdateDTO dto);

    @Named("mapRolesToNames")
    default List<String> mapRolesToNames(Set<Role> roles) {
        if (roles == null) return List.of();
        return roles.stream()
                .map(Role::getName)
                .toList();
    }

}
