package uz.pdp.avtoticket.mapper;

import org.mapstruct.Mapper;

import uz.pdp.avtoticket.dto.request.UserCreateDTO;
import uz.pdp.avtoticket.dto.request.UserUpdateDTO;
import uz.pdp.avtoticket.dto.response.user.UserResponseDTO;
import uz.pdp.avtoticket.entity.User;

@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface UserMapper
        extends GenericMapper<User, UserResponseDTO, UserCreateDTO, UserUpdateDTO> {

}
