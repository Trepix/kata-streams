package io.trepixxx.katastreams.car;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.List;

@EqualsAndHashCode
@RequiredArgsConstructor
class CarManufacturer {
    private final String name;
    private final List<Car> cars;
}
