package uz.pdp.AvtoTicket.service.userService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.dto.register.LoginDTO;
import uz.pdp.AvtoTicket.dto.register.SignUpDTO;
import uz.pdp.AvtoTicket.dto.user.UserCreateDTO;
import uz.pdp.AvtoTicket.dto.user.UserResponseDTO;
import uz.pdp.AvtoTicket.dto.user.UserUpdateDTO;
import uz.pdp.AvtoTicket.entity.user.User;
import uz.pdp.AvtoTicket.exceptions.IsDeletedException;
import uz.pdp.AvtoTicket.exceptions.NotFoundException;
import uz.pdp.AvtoTicket.exceptions.WrongPassword;
import uz.pdp.AvtoTicket.mapper.UserMapper;
import uz.pdp.AvtoTicket.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {


    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserResponseDTO login(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.email())
                .orElseThrow(() -> new NotFoundException("User not found by email : " + loginDTO.email()));
        if (passwordEncoder.matches(loginDTO.password(), user.getPassword())) {
            return userMapper.toDTO(user);
        } else {
            throw new WrongPassword("Password is wrong, try again");
        }
    }

    @Override
    public UserResponseDTO signUp(SignUpDTO dto) {
        User entity = userMapper.toEntity(dto);
        entity.setPassword(passwordEncoder.encode(dto.password()));
        User save = userRepository.save(entity);
        return userMapper.toDTO(save);
    }

    @Override
    public UserResponseDTO create(UserCreateDTO dto) {
        User entity = userMapper.toEntity(dto);
        entity.setPassword(passwordEncoder.encode(dto.password()));
        User save = userRepository.save(entity);
        return userMapper.toDTO(save);
    }

    @Override
    public UserResponseDTO getById(Long id) {
        User byId = findById(id);
        return userMapper.toDTO(byId);
    }

    @Override
    public List<UserResponseDTO> getAll() {
        List<User> all = userRepository.findAll();
        return userMapper.toDTOList(all);
    }

    @Override
    public boolean delete(Long id) {
        User byId = findById(id);
        byId.setDeleted(true);
        userRepository.save(byId);
        return true;
    }

    @Override
    public UserResponseDTO update(Long userId, UserUpdateDTO dto) {
        User byId = findById(userId);
        userMapper.toUpdate(byId, dto);

        if (dto.password() != null) {
            byId.setPassword(passwordEncoder.encode(dto.password()));
        }

        User save = userRepository.save(byId);
        return userMapper.toDTO(save);
    }

    @Override
    public User findById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id : " + userId));
        if (!user.isDeleted()) {
            return user;
        } else {
            throw new IsDeletedException("User is deleted with id = " + userId);
        }
    }
}
