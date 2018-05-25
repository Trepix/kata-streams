package io.trepixxx.katastreams.car;

import io.trepixxx.katastreams.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
class Car implements Identifiable {
    private final String id;
    private final String model;
    private final String manufacturer;
    private final String year;
}
