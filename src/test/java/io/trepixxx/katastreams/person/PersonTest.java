package io.trepixxx.katastreams.person;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import java.util.List;

import static io.trepixxx.katastreams.DataSetUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    private static final String SOURCE_PATH = "persons/dataset.csv";

    private static List<Person> persons;

    @BeforeAll
    static void initPersons() {
        persons = generate(SOURCE_PATH, PersonTest::from);
    }

    private static Person from(String line) {
        String[] splitLine = line.split(",");
        return new Person(
                splitLine[0],
                splitLine[1],
                splitLine[2],
                splitLine[3],
                splitLine[4],
                splitLine[5]
        );
    }

    @Test
    void shouldReturnOnlyMale() {
        List<Person> males = PersonService.filterByMale(persons);

        List<Person> expectedMales = getById(SOURCE_PATH, PersonTest::from, asList(1,3,11,16,17,18,19,20));
        assertEquals(expectedMales, males);
    }
}
