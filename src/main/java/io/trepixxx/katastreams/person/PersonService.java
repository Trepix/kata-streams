package io.trepixxx.katastreams.person;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

class PersonService {

    static List<Person> getMales(List<Person> persons) {
        return null;
    }

    static List<Person> getEducativeAndNonProfitEmails(List<Person> persons) {
        return null;
    }

    static List<Person> getShortNames(List<Person> persons) {
        return null;
    }

    static Set<String> getIps(List<Person> persons) {
        return null;
    }

    static Map<String, List<Person>> groupByIp(List<Person> persons) {
        return persons.stream().collect(groupingBy(Person::getIpAddress, toList()));
    }
}
