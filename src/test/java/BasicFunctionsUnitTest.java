import klmnkki.BasicFunctions;
import klmnkki.TaskMath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicFunctionsUnitTest {

    public static final double ALLOWED_ACCURACY = 0.01;

    private static Stream<Arguments> sinArgumentsProvider(){
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(PI/2,    1),
                Arguments.of(PI,      0),
                Arguments.of(PI/6,    0.5),
                Arguments.of(PI/4,    sqrt(2)/2),
                Arguments.of(PI/3,    sqrt(3)/2),
                Arguments.of(2*PI/3,  sqrt(3)/2),
                Arguments.of(3*PI/4,  sqrt(2)/2),
                Arguments.of(5*PI/6,  0.5),
                Arguments.of(7*PI/6,  -0.5),
                Arguments.of(5*PI/4,  -sqrt(2)/2),
                Arguments.of(4*PI/3,  -sqrt(3)/2),
                Arguments.of(3*PI/2,  -1),
                Arguments.of(5*PI/3,  -sqrt(3)/2),
                Arguments.of(7*PI/4,  -sqrt(2)/2),
                Arguments.of(11*PI/6, -0.5),
                Arguments.of(2*PI,     0)
        );
    }

    private static Stream<Arguments> logArgumentsProvider(){
        return Stream.of(
                Arguments.of(Math.exp(3), 3),
                Arguments.of(Math.exp(5), 5),
                Arguments.of(Math.exp(8), 8),
                Arguments.of(1, 0),
                Arguments.of(Math.exp(10), 10),
                Arguments.of(Math.exp(0.1), 0.1),
                Arguments.of(0, Double.NaN),
                Arguments.of(-5, Double.NaN),
                Arguments.of(-1, Double.NaN),
                Arguments.of(-0.5, Double.NaN)
        );
    }

    @ParameterizedTest
    @MethodSource("sinArgumentsProvider")
    void testPositiveArgsSin(double x, double expected){
        assertEquals(expected, BasicFunctions.sin(x), ALLOWED_ACCURACY);
    }

    @ParameterizedTest
    @MethodSource("sinArgumentsProvider")
    void testNegativeArgsSin(double x, double expected) {
        assertEquals(-expected, BasicFunctions.sin(-x), ALLOWED_ACCURACY);
    }

    @ParameterizedTest
    @MethodSource("logArgumentsProvider")
    void testLogarithm(double x, double expected){
        assertEquals(expected, BasicFunctions.ln(x), ALLOWED_ACCURACY);
    }

    @Test
    void testBorderValuesSin(){
        TaskMath math = new TaskMath();
        assertEquals(Double.NaN, math.sin(Double.NaN));
        assertEquals(Double.NaN, math.sin(Double.NEGATIVE_INFINITY));
        assertEquals(Double.NaN, math.sin(Double.POSITIVE_INFINITY));
    }

}