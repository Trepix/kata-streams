package io.trepixxx.katastreams.person;

import io.trepixxx.katastreams.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
class Person implements Identifiable {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String gender;
    private final String ipAddress;

}
