package uz.pdp.AvtoTicket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.AvtoTicket.dto.request.create.UserCreateDTO;
import uz.pdp.AvtoTicket.dto.response.UserDTO;
import uz.pdp.AvtoTicket.dto.request.update.UserUpdateDTO;
import uz.pdp.AvtoTicket.service.userService.UserService;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userById = userService.getById(id);
        return ResponseEntity.ok(userById);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserCreateDTO dto) {
        System.out.println(dto);
        UserDTO userDTO = userService.create(dto);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        boolean delete = userService.delete(id);
        return ResponseEntity.ok(delete);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id,
                                              @RequestBody UserUpdateDTO userDTO) {
        UserDTO user = userService.update(id, userDTO);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> all = userService.getAll();
        return ResponseEntity.ok(all);
    }

}
