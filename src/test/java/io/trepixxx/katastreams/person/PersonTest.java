package io.trepixxx.katastreams.person;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.trepixxx.katastreams.DataSetUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    private static final String SOURCE_PATH = "persons/dataset.csv";

    private static List<Person> persons;

    @BeforeAll
    static void initPersons() {
        persons = generate(SOURCE_PATH, PersonTest::from);
    }

    @Test
    void shouldReturnOnlyMale() {
        List<Person> malePersons = PersonService.getMales(persons);

        List<Person> expectedPersons = getById(SOURCE_PATH, PersonTest::from, asList(1,3,11,16,17,18,19,20));
        assertEquals(expectedPersons, malePersons);
    }

    @Test
    void shouldReturnPersonsWithEducativeAndNonProfitOrganizationEmails() {
        List<Person> personsWithEducativeAndNonProfitEmails = PersonService.getEducativeAndNonProfitEmails(PersonTest.persons);

        List<Person> expectedPersons = getById(SOURCE_PATH, PersonTest::from, asList(4,11,12,14));
        assertEquals(expectedPersons, personsWithEducativeAndNonProfitEmails);
    }

    @Test
    void shouldReturnPersonsWithShortNames() {
        //Consider 6 or more characters as non short name
        List<Person> personsWithShortName = PersonService.getShortNames(PersonTest.persons);

        List<Person> expectedPersons = getById(SOURCE_PATH, PersonTest::from, asList(2,3,8,9,10,12,16,17,18,19));
        assertEquals(expectedPersons, personsWithShortName);
    }


    @Test
    void shouldReturnSetOfIps() {
        Set<String> ips = PersonService.getIps(PersonTest.persons);

        Set<String> expectedIps = new HashSet<>(asList(
                "203.63.60.86","10.105.170.42","167.133.36.33","245.181.139.113","18.115.65.8","227.112.191.26"
        ));

        assertEquals(expectedIps, ips);
    }

    private static Person from(String line) {
        String[] splitLine = line.split(",");
        return new Person(splitLine[0], splitLine[1], splitLine[2], splitLine[3], splitLine[4], splitLine[5]);
    }
}
