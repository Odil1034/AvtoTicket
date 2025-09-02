package uz.pdp.AutoTicket.mapper;

import org.mapstruct.Mapper;

import uz.pdp.AutoTicket.config.CustomUserDetails;
import uz.pdp.AutoTicket.dto.request.UserCreateDTO;
import uz.pdp.AutoTicket.dto.request.UserUpdateDTO;
import uz.pdp.AutoTicket.dto.response.UserResponseDTO;
import uz.pdp.AutoTicket.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper
        extends GenericMapper<User, UserResponseDTO, UserCreateDTO, UserUpdateDTO> {

//    CustomUserDetails toCustomUserDetails(User user);

}
