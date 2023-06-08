package org.example.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleAreaTest {

    @ParameterizedTest
    @CsvSource({"3,4,5,6", "8,11,13,43.81780460041329"})
    void testTriangle(int a, int b, int c, double result) throws IllegalTriangleException {
        Triangle triangle = new Triangle(a, b, c);
        Assertions.assertEquals(result, triangle.area());
    }

    @ParameterizedTest
    @CsvSource({"-3,4,5", "0,4,4", "5,3,8"})
    void testTriangleN(int a, int b, int c) {
        Assertions.assertThrows(IllegalTriangleException.class, () -> new Triangle(a, b, c));
    }
}
