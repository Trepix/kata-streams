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


//    @Test
//    void shouldReturnMapLinkingEachGroupOfPersonsWithAnIp() {
//        Map<String, List<Person>> ips = PersonService.groupByIp(CarTest.cars);
//
//        Map<String, List<Person>> expectedIps = Collections.unmodifiableMap(new HashMap<String, List<Person>>() {
//            {
//                put("203.63.60.86", getByIds(1,2,14));
//                put("10.105.170.42", getByIds(3,5,8,10));
//                put("167.133.36.33", getByIds(4,6,15,16,17,19,20));
//                put("245.181.139.113", getByIds(7,9));
//                put("18.115.65.8", getByIds(11,12,13));
//                put("227.112.191.26", getByIds(18));
//            }
//        });
//
//        assertEquals(expectedIps, ips);
//    }

    private static Car createCar(String line) {
        String[] splitLine = line.split(",");
        return new Car(splitLine[0], splitLine[1], splitLine[2], splitLine[3]);
    }

    private static List<Car> getByIds(Integer... ids) {
        return getById(SOURCE_PATH, CarTest::createCar, asList(ids));

    }
}
