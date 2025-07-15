package org.thomascaillier.issues.spring_convert_enum_json_value;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class UserService {

    List<User> users = List.of(
            new User("Alice", UserType.ADMIN),
            new User("Bob", UserType.USER),
            new User("Charlie", UserType.GUEST)
    );

    Flux<User> findByUserType(UserType userType) {
        return Flux.fromIterable(users)
                .filter(user -> user.userType().equals(userType));
    }

}
