package io.trepixxx.katastreams;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataSetUtils {

    @SneakyThrows
    public static <T> List<T> generate(String path, Function<String, T> function) {
        ClassLoader classLoader = DataSetUtils.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line;
        List<T> result = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            result.add(function.apply(line));
        }
        reader.close();

        return result;
    }



    @SneakyThrows
    public static <T extends Identifiable> List<T> getById(String path, Function<String, T> function, List<Integer> ids) {
        List<String> stringIds = ids.stream().map(String::valueOf).collect(Collectors.toList());
        return generate(path, function).stream().filter(x -> stringIds.contains(x.getId())).collect(Collectors.toList());
    }

}
