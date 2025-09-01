package uz.pdp.AutoTicket.controller.admin;

import lombok.RequiredArgsConstructor;
import uz.pdp.AutoTicket.service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

}
