package hProjekt.model.grid;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.tutor.general.assertions.*;

import com.fasterxml.jackson.databind.node.ObjectNode;

import hProjekt.Project_TestP;
import hProjekt.mocking.MockConverterP;
import hProjekt.mocking.ReflectionUtilsP;
import hProjekt.mocking.StudentMethodCall;

import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.contextBuilder;

@TestForSubmission
public class StatueTest {
    @ParameterizedTest
    @MethodSource("provideSpawnAmulet_basic")
    public void testSpawnAmulet_basic(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.grid.Statue.class.getDeclaredMethod("spawnAmulet");
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }


        Throwable lastCall = null;
        for (StudentMethodCall actual: results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                    .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                    .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                    .build();

                Assertions2.assertEquals(expected, actual.invoked, context, r -> "SpawnAmulet() did not return the expected value!");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideSpawnAmulet_basic() {
        return Project_TestP.parseJsonFile("hProjekt/model/grid/Statue_spawnAmulet_basic.json");
    }


    @ParameterizedTest
    @MethodSource("provideSpawnAmulet_complete")
    public void testSpawnAmulet_complete(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.grid.Statue.class.getDeclaredMethod("spawnAmulet");
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }


        Throwable lastCall = null;
        for (StudentMethodCall actual: results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                    .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                    .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                    .build();

                Assertions2.assertEquals(expected, actual.invoked, context, r -> "SpawnAmulet() did not return the expected value!");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideSpawnAmulet_complete() {
        return Project_TestP.parseJsonFile("hProjekt/model/grid/Statue_spawnAmulet_complete.json");
    }


    @ParameterizedTest
    @MethodSource("provideTurn_basic")
    public void testTurn_basic(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.grid.Statue.class.getDeclaredMethod("turn");
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }


        Throwable lastCall = null;
        for (StudentMethodCall actual: results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                    .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                    .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                    .build();

                Assertions2.assertEquals(expected, actual.invoked, context, r -> "Turn() did not return the expected value!");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideTurn_basic() {
        return Project_TestP.parseJsonFile("hProjekt/model/grid/Statue_turn_basic.json");
    }


    @ParameterizedTest
    @MethodSource("provideTurn_complete")
    public void testTurn_complete(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.grid.Statue.class.getDeclaredMethod("turn");
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }


        Throwable lastCall = null;
        for (StudentMethodCall actual: results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                    .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                    .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                    .build();

                Assertions2.assertEquals(expected, actual.invoked, context, r -> "Turn() did not return the expected value!");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideTurn_complete() {
        return Project_TestP.parseJsonFile("hProjekt/model/grid/Statue_turn_complete.json");
    }

}
