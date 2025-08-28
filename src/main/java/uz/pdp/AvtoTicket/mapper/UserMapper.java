package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import uz.pdp.AvtoTicket.dto.register.SignUpDTO;
import uz.pdp.AvtoTicket.dto.user.UserCreateDTO;
import uz.pdp.AvtoTicket.dto.user.UserResponseDTO;
import uz.pdp.AvtoTicket.dto.user.UserUpdateDTO;
import uz.pdp.AvtoTicket.entity.user.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserCreateDTO dto);

    User toEntity(SignUpDTO dto);

    UserResponseDTO toDTO(User user);

    List<UserResponseDTO> toDTOList(List<User> user);

    UserMapper usermapper = Mappers.getMapper(UserMapper.class);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toUpdate(@MappingTarget User user, UserUpdateDTO dto);
}
