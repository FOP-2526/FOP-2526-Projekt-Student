package hProjekt.model.grid;

import static hProjekt.Project_TestP.assertSetEquals;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.contextBuilder;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.tutor.general.assertions.Assertions2;
import org.tudalgo.algoutils.tutor.general.assertions.Context;

import com.fasterxml.jackson.databind.node.ObjectNode;

import hProjekt.Project_TestP;
import hProjekt.mocking.MockConverterP;
import hProjekt.mocking.ReflectionUtilsP;
import hProjekt.mocking.StudentMethodCall;

@TestForSubmission
public class TileImplTest {
    @ParameterizedTest
    @MethodSource("provideGetNeighbours")
    public void testGetNeighbours(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.grid.TileImpl.class.getDeclaredMethod("getNeighbours");
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }

        Throwable lastCall = null;
        for (StudentMethodCall actual : results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                        .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                        .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                        .build();

                Set<Tile> expectedValue = ((Set<Tile>) (expected));
                Set<Tile> actualValue = ((Set<Tile>) (actual.call.returnValue()));
                assertSetEquals(
                        expectedValue,
                        actualValue,
                        context);
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideGetNeighbours() {
        return Project_TestP.parseJsonFile("hProjekt/model/grid/TileImpl_getNeighbours.json");
    }

    @ParameterizedTest
    @MethodSource("provideIsNear_basic")
    public void testIsNear_basic(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.grid.TileImpl.class.getDeclaredMethod("isNear", java.util.function.Predicate.class, int.class);
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }

        Throwable lastCall = null;
        for (StudentMethodCall actual : results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                        .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                        .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                        .build();

                Assertions2.assertEquals(expected, actual.call.returnValue(), context,
                        r -> "IsNear() did not return the expected value!");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideIsNear_basic() {
        return Project_TestP.parseJsonFile("hProjekt/model/grid/TileImpl_isNear_basic.json");
    }

    @ParameterizedTest
    @MethodSource("provideIsNear_complete")
    public void testIsNear_complete(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.grid.TileImpl.class.getDeclaredMethod("isNear", java.util.function.Predicate.class, int.class);
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }

        Throwable lastCall = null;
        for (StudentMethodCall actual : results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                        .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                        .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                        .build();

                Assertions2.assertEquals(expected, actual.call.returnValue(), context,
                        r -> "IsNear() did not return the expected value!");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideIsNear_complete() {
        return Project_TestP.parseJsonFile("hProjekt/model/grid/TileImpl_isNear_complete.json");
    }
}
