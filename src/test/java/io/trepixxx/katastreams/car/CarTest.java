package io.trepixxx.katastreams.car;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.trepixxx.katastreams.DataSetUtils.generate;
import static io.trepixxx.katastreams.DataSetUtils.getById;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    private static final String SOURCE_PATH = "cars/dataset.csv";

    private static List<Car> cars;

    @BeforeAll
    static void initPersons() {
        cars = generate(SOURCE_PATH, CarTest::createCar);
    }

    @Test
    void shouldReturnBMWCarManufacturer() {
        CarManufacturer bmwCarManufacturer = CarService.getBMWCars(cars);

        List<Car> expectedCars = getByIds(17,19,27);
        CarManufacturer expectedCarManufacturer = new CarManufacturer("BMW", expectedCars);
        assertEquals(expectedCarManufacturer, bmwCarManufacturer);
    }

    @Test
    void shouldReturnCarsSortedByYear() {
        List<Car> sortedCars = CarService.getCarsSortedByYear(cars);

        List<Car> expectedSortedCars = getByIds(4,26,8,17,1,10,11,13,3,14,16,24,2,23,25,5,27,9,18,15,21,7,28,20,22,29,30,12,19,6);
        assertEquals(expectedSortedCars, sortedCars);
    }

    @Test
    void shouldReturnCarsPost2000() {
        Integer cardsPost2000Count = CarService.countPost2000Cars(cars);

        assertEquals(Integer.valueOf(17), cardsPost2000Count);
    }

    private static Car createCar(String line) {
        String[] splitLine = line.split(",");
        return new Car(splitLine[0], splitLine[1], splitLine[2], splitLine[3]);
    }

    private static List<Car> getByIds(Integer... ids) {
        return getById(SOURCE_PATH, CarTest::createCar, asList(ids));

    }
}
