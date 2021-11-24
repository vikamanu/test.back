package ru.manuvika.tests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.manuvika.utils.MathUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MathUtilTest {

    private static Stream<Arguments> getDataForSumTest() {
        return Stream.of(
                arguments(10, 7, 17),
                arguments(15, 10, 25),
                arguments(1, 2, 3)
        );
    }

//    @Parameterized.Parameters(name = "{index}:sumOf({0}+{1})={2}")
//    public static Iterable<Object[]> dataForTest() {
//        return Arrays.asList(new Object[][]{
//                {1, 1, 2},
//                {2, 6, 8},
//                {18, 2, 20},
//                {13, 15, 28},
//                {1, 5, 6}
//        });
//    }
    @BeforeEach
    void setUp() {
//        a = getRandomInt(10, 100);
//        b = getRandomInt(10, 100);
    }
    @AfterEach
    void tearDown() {
    }
    @ParameterizedTest
    @DisplayName("Тест суммы двух чисел")
    @MethodSource("getDataForSumTest")
    void sumTest(int a, int b, int expected) {
        int actually = MathUtil.sum(a, b);
        assertEquals(expected, actually);
    }

    @Test
    @DisplayName("Тест на создание временного файла")
    void fileCreationTest(@TempDir Path path) throws IOException {
        Path file = Files.createFile(path.resolve("test.txt"));
        Files.write(file, "Hello world!".getBytes(StandardCharsets.UTF_8));
        assertTrue(Files.exists(file));
    }

    private int getRandomInt(int from, int to) {
        int length = abs(to - from);
        return (int) (from + Math.random() * length);
    }

}

