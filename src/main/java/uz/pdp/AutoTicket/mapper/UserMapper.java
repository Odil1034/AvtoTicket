package uz.pdp.AutoTicket.mapper;

import org.mapstruct.Mapper;

import uz.pdp.AutoTicket.dto.request.UserCreateDTO;
import uz.pdp.AutoTicket.dto.request.UserUpdateDTO;
import uz.pdp.AutoTicket.dto.response.user.UserResponseDTO;
import uz.pdp.AutoTicket.entity.User;

@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface UserMapper
        extends GenericMapper<User, UserResponseDTO, UserCreateDTO, UserUpdateDTO> {

}
