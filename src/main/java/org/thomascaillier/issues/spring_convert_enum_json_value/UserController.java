package org.thomascaillier.issues.spring_convert_enum_json_value;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public Flux<User> findUsers(@RequestParam("type") UserType userType) {
        return userService.findByUserType(userType);
    }

}
