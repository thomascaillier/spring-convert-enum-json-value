package org.thomascaillier.issues.spring_convert_enum_json_value;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum UserType {

    ADMIN("admin"),
    USER("user"),
    GUEST("guest");

    @JsonValue
    private final String value;

    @JsonCreator
    public static UserType fromValue(String value) {
        return Arrays.stream(UserType.values())
                .filter(state -> state.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown user type: " + value));
    }

}
