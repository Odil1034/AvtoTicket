package uz.pdp.AutoTicket.mapper;

import org.mapstruct.Mapper;

import uz.pdp.AutoTicket.config.CustomUserDetails;
import uz.pdp.AutoTicket.dto.user.UserCreateDTO;
import uz.pdp.AutoTicket.dto.user.UserResponseDTO;
import uz.pdp.AutoTicket.dto.user.UserUpdateDTO;
import uz.pdp.AutoTicket.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper
        extends GenericMapper<User, UserResponseDTO, UserCreateDTO, UserUpdateDTO> {

    CustomUserDetails toCustomUserDetails(User user);

}
