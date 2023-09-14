import klmnkki.MathSystem;
import klmnkki.TaskMath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SystemIntegrationTest {

    public static final double STEP = 0.001;

    MathSystem system = new MathSystem(new TaskMath());

    @ParameterizedTest
    @ValueSource(doubles={-13*Math.PI/2, -9*Math.PI/2, -5*Math.PI/2, -Math.PI/2})
    void testSpecialPoints(double x) {
        double left = system.calculateFunction(x - STEP);
        double right = system.calculateFunction(x + STEP);
        double res = system.calculateFunction(x);
        System.out.println(left);
        System.out.println(res);
        System.out.println(right);
        assertTrue(res > left && res > right || res < left && res < right);
    }

    static Stream<Arguments> sysValues(){
        return Stream.of(
                Arguments.of(2, 0.009144061),
                Arguments.of(133, 3.1753658245631725E8),
                Arguments.of(45, 7411337.640),
                Arguments.of(-8, 0),
                Arguments.of(0.0025, -6.677770427370103E9),
                Arguments.of(-0.1274, 3.191967316898205E21),
                Arguments.of(-0.1249, 5.123153828718139E21),
                Arguments.of(-0.999, 2.4206581294)
        );
    }

    @ParameterizedTest
    @MethodSource("sysValues")
    void generalTest(double x, double expected) {
        assertEquals(expected, system.calculateFunction(x), BasicFunctionsUnitTest.ALLOWED_ACCURACY);
    }

}