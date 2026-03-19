package hProjekt.model.grid;

import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

import hProjekt.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.tutor.general.assertions.*;

import com.fasterxml.jackson.databind.node.ObjectNode;

import hProjekt.mocking.MockConverterP;
import hProjekt.mocking.ReflectionUtilsP;
import hProjekt.mocking.StudentMethodCall;

import static hProjekt.Project_TestP.assertEqualsWithMatcher;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.contextBuilder;

@TestForSubmission
public class HexGridImplTest {
    @ParameterizedTest
    @MethodSource("provideSpawnAmulets_basic")
    public void testSpawnAmulets_basic(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.grid.HexGridImpl.class.getDeclaredMethod("spawnAmulets");
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        Consumer<Object> beforeEach = o -> Config.RANDOM.setSeed(123);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node, beforeEach);

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

                HexGridImpl actualGrid = ((HexGridImpl) (actual.invoked));
                HexGridImpl expectedGrid = ((HexGridImpl) (expected));
                actualGrid.getStructures().values().stream().filter(s -> s instanceof Statue).forEach(s -> {
                    verify(((Statue) (s)), times(1)).turn();
                    verify(((Statue) (s)), times(1)).spawnAmulet();
                });
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideSpawnAmulets_basic() {
        return Project_TestP.parseJsonFile("hProjekt/model/grid/HexGridImpl_spawnAmulets_basic.json");
    }


    @ParameterizedTest
    @MethodSource("provideSpawnAmulets_complete")
    public void testSpawnAmulets_complete(ObjectNode node) throws NoSuchMethodException {
        hProjekt.model.grid.HexGridImpl.class.getDeclaredMethod("spawnAmulets");
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        Consumer<Object> beforeEach = o -> Config.RANDOM.setSeed(123);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node, beforeEach);

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

                HexGridImpl actualGrid = ((HexGridImpl) (actual.invoked));
                HexGridImpl expectedGrid = ((HexGridImpl) (expected));
                actualGrid.getStructures().values().stream().filter(s -> s instanceof Statue).forEach(s -> {
                    verify(((Statue) (s)), times(1)).turn();
                    verify(((Statue) (s)), times(1)).spawnAmulet();
                });
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideSpawnAmulets_complete() {
        return Project_TestP.parseJsonFile("hProjekt/model/grid/HexGridImpl_spawnAmulets_complete.json");
    }
}
