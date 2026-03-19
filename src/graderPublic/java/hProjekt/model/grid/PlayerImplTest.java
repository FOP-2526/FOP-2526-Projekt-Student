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
public class PlayerImplTest {
    @ParameterizedTest
    @MethodSource("provideAddAmulets")
    public void testAddAmulets(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.PlayerImpl.class.getDeclaredMethod("addAmulets", int.class);
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

                Assertions2.assertEquals(expected, actual.invoked, context, r -> "AddAmulets() did not return the expected value!");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideAddAmulets() {
        return Project_TestP.parseJsonFile("hProjekt/model/PlayerImpl_addAmulets.json");
    }


    @ParameterizedTest
    @MethodSource("provideGetAmulets")
    public void testGetAmulets(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.PlayerImpl.class.getDeclaredMethod("getAmulets");
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

                Assertions2.assertEquals(expected, actual.call.returnValue(), context, r -> "GetAmulets() did not return the expected value!");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideGetAmulets() {
        return Project_TestP.parseJsonFile("hProjekt/model/PlayerImpl_getAmulets.json");
    }


    @ParameterizedTest
    @MethodSource("provideGetColor")
    public void testGetColor(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.PlayerImpl.class.getDeclaredMethod("getColor");
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

                Assertions2.assertEquals(expected, actual.call.returnValue(), context, r -> "GetColor() did not return the expected value!");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideGetColor() {
        return Project_TestP.parseJsonFile("hProjekt/model/PlayerImpl_getColor.json");
    }


    @ParameterizedTest
    @MethodSource("provideGetHexGrid")
    public void testGetHexGrid(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.PlayerImpl.class.getDeclaredMethod("getHexGrid");
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

                Assertions2.assertEquals(expected, actual.call.returnValue(), context, r -> "GetHexGrid() did not return the expected value!");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideGetHexGrid() {
        return Project_TestP.parseJsonFile("hProjekt/model/PlayerImpl_getHexGrid.json");
    }


    @ParameterizedTest
    @MethodSource("provideGetID")
    public void testGetID(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.PlayerImpl.class.getDeclaredMethod("getID");
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

                Assertions2.assertEquals(expected, actual.call.returnValue(), context, r -> "GetID() did not return the expected value!");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideGetID() {
        return Project_TestP.parseJsonFile("hProjekt/model/PlayerImpl_getID.json");
    }


    @ParameterizedTest
    @MethodSource("provideGetName")
    public void testGetName(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.PlayerImpl.class.getDeclaredMethod("getName");
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

                Assertions2.assertEquals(expected, actual.call.returnValue(), context, r -> "GetName() did not return the expected value!");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideGetName() {
        return Project_TestP.parseJsonFile("hProjekt/model/PlayerImpl_getName.json");
    }


    @ParameterizedTest
    @MethodSource("provideIsAi")
    public void testIsAi(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.PlayerImpl.class.getDeclaredMethod("isAi");
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

                Assertions2.assertEquals(expected, actual.call.returnValue(), context, r -> "IsAi() did not return the expected value!");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideIsAi() {
        return Project_TestP.parseJsonFile("hProjekt/model/PlayerImpl_isAi.json");
    }


    @ParameterizedTest
    @MethodSource("provideRemoveAmulets")
    public void testRemoveAmulets(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.PlayerImpl.class.getDeclaredMethod("removeAmulets", int.class);
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

                Assertions2.assertEquals(expected, actual.call.returnValue(), context, r -> "RemoveAmulets() did not return the expected value!");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideRemoveAmulets() {
        return Project_TestP.parseJsonFile("hProjekt/model/PlayerImpl_removeAmulets.json");
    }
}
