package uz.pdp.AutoTicket.controller;

import lombok.RequiredArgsConstructor;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.user.UserCreateDTO;
import uz.pdp.AutoTicket.dto.user.UserResponseDTO;
import uz.pdp.AutoTicket.dto.user.UserUpdateDTO;
import uz.pdp.AutoTicket.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        UserResponseDTO userById = userService.getById(id);
        return ResponseEntity.ok(userById);
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO dto) {
        UserResponseDTO userResponseDTO = userService.create(dto);
        return ResponseEntity.ok(userResponseDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        boolean delete = userService.delete(id);
        return ResponseEntity.ok(delete);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id,
                                                      @RequestBody UserUpdateDTO userDTO) {
        UserResponseDTO user = userService.update(id, userDTO);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Response<List<UserResponseDTO>>> getAll() {
        return userService.findAll();
    }

}
