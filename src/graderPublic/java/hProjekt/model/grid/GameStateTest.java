package hProjekt.model.grid;

import static hProjekt.Project_TestP.assertContainsAll;
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
public class GameStateTest {
    @ParameterizedTest
    @MethodSource("provideCanAddCardToTreasureTrail_basic")
    public void testCanAddCardToTreasureTrail_basic(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.GameState.class.getDeclaredMethod("canAddCardToTreasureTrail", javafx.scene.paint.Color.class,
                hProjekt.model.cards.PathCard.class);
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
                        r -> "CanAddCardToTreasureTrail() did not return the expected value!");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideCanAddCardToTreasureTrail_basic() {
        return Project_TestP.parseJsonFile("hProjekt/model/GameState_canAddCardToTreasureTrail_basic.json");
    }

    @ParameterizedTest
    @MethodSource("provideCanAddCardToTreasureTrail_complete")
    public void testCanAddCardToTreasureTrail_complete(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.GameState.class.getDeclaredMethod("canAddCardToTreasureTrail", javafx.scene.paint.Color.class,
                hProjekt.model.cards.PathCard.class);
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
                        r -> "CanAddCardToTreasureTrail() did not return the expected value!");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideCanAddCardToTreasureTrail_complete() {
        return Project_TestP.parseJsonFile("hProjekt/model/GameState_canAddCardToTreasureTrail_complete.json");
    }

    @ParameterizedTest
    @MethodSource("provideEvaluateTreasureTrail_basic")
    public void testEvaluateTreasureTrail_basic(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.GameState.class.getDeclaredMethod("evaluateTreasureTrail", javafx.scene.paint.Color.class);
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

                assertSetEquals((Set<Object>) expected, (Set<Object>) actual.call.returnValue(), context);
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideEvaluateTreasureTrail_basic() {
        return Project_TestP.parseJsonFile("hProjekt/model/GameState_evaluateTreasureTrail_basic.json");
    }

    @ParameterizedTest
    @MethodSource("provideEvaluateTreasureTrail_complete")
    public void testEvaluateTreasureTrail_complete(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.GameState.class.getDeclaredMethod("evaluateTreasureTrail", javafx.scene.paint.Color.class);
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

                assertSetEquals((Set<Object>) expected, (Set<Object>) actual.call.returnValue(), context);
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideEvaluateTreasureTrail_complete() {
        return Project_TestP.parseJsonFile("hProjekt/model/GameState_evaluateTreasureTrail_complete.json");
    }

    @ParameterizedTest
    @MethodSource("provideEvaluateTreasureTrail_mid")
    public void testEvaluateTreasureTrail_mid(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.GameState.class.getDeclaredMethod("evaluateTreasureTrail", javafx.scene.paint.Color.class);
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

                assertSetEquals((Set<Object>) expected, (Set<Object>) actual.call.returnValue(), context);
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideEvaluateTreasureTrail_mid() {
        return Project_TestP.parseJsonFile("hProjekt/model/GameState_evaluateTreasureTrail_mid.json");
    }

    @ParameterizedTest
    @MethodSource("provideGetTreasureTrail")
    public void testGetTreasureTrail(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.GameState.class.getDeclaredMethod("getTreasureTrail", javafx.scene.paint.Color.class);
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

                assertContainsAll((List<Object>) expected, (List<Object>) actual.call.returnValue(), context);
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideGetTreasureTrail() {
        return Project_TestP.parseJsonFile("hProjekt/model/GameState_getTreasureTrail.json");
    }
}
