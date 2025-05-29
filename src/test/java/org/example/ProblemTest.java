package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ProblemTest {

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(402, 20, 10),
                Arguments.of(542324, 20, 0),
                Arguments.of(0, 10, 40),
                Arguments.of(4343, 0, 40),
                Arguments.of(746345, 20, 40)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void testProblemBehavior(int seed, int n, int capacity) {
        Problem problem = new Problem(n, seed);
        Result result = problem.solve(capacity);
        Result resultDanzig = problem.solveDantzig(capacity);

        if (seed == 402 && n == 20 && capacity == 10) {
            // At least one item should fit
            assertNotEquals(0, result.getItems().size());
            assertNotEquals(0, resultDanzig.getItems().size());
        }

        if (seed == 542324 && n == 20 && capacity == 0) {
            // No items should fit
            assertEquals(0, result.getItems().size());
            assertEquals(0, resultDanzig.getItems().size());
        }

        if (seed == 0 && n == 10 && capacity == 40) {
            // Expected deterministic result
            List<Integer> expectedItems = List.of(0, 8, 3, 5, 7, 1, 6, 9);
            int expectedValue = 42;
            int expectedWeight = 38;

            for (int item : expectedItems) {
                assertTrue(result.getItems().contains(item));
            }

            assertEquals(expectedWeight, result.getSumWeight());
            assertEquals(expectedValue, result.getSumValue());
        }

        if (seed == 4343 && n == 0 && capacity == 40) {
            assertEquals(0, result.getSumWeight());
            assertEquals(0, result.getSumValue());
            assertEquals(0, result.getItems().size());
            assertEquals(0, resultDanzig.getSumWeight());
            assertEquals(0, resultDanzig.getSumValue());
            assertEquals(0, resultDanzig.getItems().size());
        }

        if (seed == 746345 && n == 20 && capacity == 40) {
            for (Item item : problem.items) {
                assertTrue(item.getWeight() > 0 && item.getWeight() <= 10);
                assertTrue(item.getValue() > 0 && item.getValue() <= 10);
            }
        }
    }
}
