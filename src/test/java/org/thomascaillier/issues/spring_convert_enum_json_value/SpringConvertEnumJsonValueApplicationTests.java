package org.thomascaillier.issues.spring_convert_enum_json_value;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
class SpringConvertEnumJsonValueApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void findUsersByUserTypes() {
        webTestClient.get().uri("/users?type=admin")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(User.class)
                .hasSize(1)
                .contains(
                        new User("Alice", UserType.ADMIN)
                );
    }

    @Test
    void findUsersByUserTypes_wrongParameterCase() {
        webTestClient.get().uri("/users?type=ADMIN")
                .exchange()
                .expectStatus().isBadRequest();
    }

}
